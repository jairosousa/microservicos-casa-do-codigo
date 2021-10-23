package com.jnsdev.microservicos.productapi.service.impl;

import com.jnsdev.microservicos.productapi.converter.DTOConverter;
import com.jnsdev.microservicos.productapi.model.Product;
import com.jnsdev.microservicos.productapi.repository.CategoryRepository;
import com.jnsdev.microservicos.productapi.repository.ProducrRepository;
import com.jnsdev.microservicos.productapi.service.ProductService;
import com.jnsdev.microservicos.shoppingclient.dto.ProductDTO;
import com.jnsdev.microservicos.shoppingclient.exception.CategoryNotFoundException;
import com.jnsdev.microservicos.shoppingclient.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Autor Jairo Nascimento
 * @Created 26/09/2021 - 17:15
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProducrRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductByCategoryId(Long categoryId) {
        List<Product> products =
                productRepository.getProductByCategory(categoryId);
        return products
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findByProductIdentifier(String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return DTOConverter.convert(product);
        }
        throw new ProductNotFoundException();
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Boolean existsCategory = categoryRepository
                .existsById(productDTO.getCategory().getId());
        if (!existsCategory) {
            throw new CategoryNotFoundException();
        }
        Product product = productRepository
                .save(Product.convert(productDTO));
        return DTOConverter.convert(product);
    }

    @Override
    public void delete(long productId) {
        Optional<Product> product =
                productRepository.findById(productId);
        if (product.isPresent()) {
            productRepository.delete(product.get());
        }
        throw new ProductNotFoundException();
    }
}
