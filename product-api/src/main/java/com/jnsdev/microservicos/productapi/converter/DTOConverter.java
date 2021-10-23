package com.jnsdev.microservicos.productapi.converter;

import com.jnsdev.microservicos.productapi.model.Category;
import com.jnsdev.microservicos.productapi.model.Product;
import com.jnsdev.microservicos.shoppingclient.dto.CategoryDTO;
import com.jnsdev.microservicos.shoppingclient.dto.ProductDTO;

/**
 * @Autor Jairo Nascimento
 * @Created 28/09/2021 - 18:14
 */
public class DTOConverter {

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(
                product.getProductIdentifier());
        productDTO.setDescricao(product.getDescricao());

        if (product.getCategory() != null) {
            productDTO.setCategory(
                    DTOConverter.convert(product.getCategory()));
        }
        return productDTO;
    }

    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }
}
