package com.jnsdev.microservicos.productapi.controller;

import com.jnsdev.microservicos.productapi.service.ProductService;
import com.jnsdev.microservicos.shoppingclient.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 26/09/2021 - 17:20
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<ProductDTO> getProducts() {
        List<ProductDTO> produtos = productService.getAll();
        return produtos;
    }

    @GetMapping("/product/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(
            @PathVariable Long categoryId) {
        List<ProductDTO> produtos =
                productService.getProductByCategoryId(categoryId);
        return produtos;
    }

    @GetMapping("/product/{productIdentifier}")
    ProductDTO findById(@PathVariable String productIdentifier) {
        return productService
                .findByProductIdentifier(productIdentifier);
    }

    @PostMapping("/product")
    ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @DeleteMapping("/product/{id}")
    void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
