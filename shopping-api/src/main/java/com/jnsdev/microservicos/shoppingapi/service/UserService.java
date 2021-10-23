package com.jnsdev.microservicos.shoppingapi.service;

import com.jnsdev.microservicos.dto.UserDTO;
import com.jnsdev.microservicos.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @Autor Jairo Nascimento
 * @Created 28/09/2021 - 18:48
 */

@Service
public class UserService {

    @Value("${USER_API_URL:http://localhost:8081/user/cpf/}")
    private String userApiURL;

    public UserDTO getUserByCpf(String cpf, String key) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = userApiURL + "cpf";
            UriComponentsBuilder builder = UriComponentsBuilder
                    .fromHttpUrl(url);
            builder.queryParam("key", key);
            ResponseEntity<UserDTO> response =
                    restTemplate.getForEntity(builder.toUriString(), UserDTO.class);
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new UserNotFoundException();
        }
    }
}
