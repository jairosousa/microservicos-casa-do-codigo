package com.jnsdev.microservicos.shoppingapi.service;

import com.jnsdev.microservicos.shoppingclient.dto.ProductDTO;
import com.jnsdev.microservicos.shoppingclient.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @Autor Jairo Nascimento
 * @Created 28/09/2021 - 18:50
 */
@Service
public class ProductService {

    public ProductDTO getProductByIdentifier(String productIdentifier) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url =
                    "http://localhost:8081/product/" + productIdentifier;
            ResponseEntity<ProductDTO> response =
                    restTemplate.getForEntity(url, ProductDTO.class);
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new UserNotFoundException();
        }
    }
}
