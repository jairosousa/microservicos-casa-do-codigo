package com.jnsdev.microservicos.userapi.converter;

import com.jnsdev.microservicos.shoppingclient.dto.UserDTO;
import com.jnsdev.microservicos.userapi.model.User;

/**
 * @Autor Jairo Nascimento
 * @Created 28/09/2021 - 18:14
 */
public class DTOConverter {
    public static UserDTO convert(User user) {
        UserDTO userDTO	=	new UserDTO();
        userDTO.setNome(user.getNome());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setCpf(user.getCpf());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setDataCadastro(user.getDataCadastro());
        return	userDTO;
    }
}
