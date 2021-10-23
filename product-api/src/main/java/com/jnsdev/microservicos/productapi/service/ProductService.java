package com.jnsdev.microservicos.productapi.service;

import com.jnsdev.microservicos.dto.ProductDTO;

import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 26/09/2021 - 17:13
 */
public interface ProductService {
    public List<ProductDTO> getAll();
    public List<ProductDTO> getProductByCategoryId(Long categoryId);
    public ProductDTO findByProductIdentifier(String productIdentifier);
    public ProductDTO save(ProductDTO productDTO);
    public void delete(long productId);
}
