package com.jnsdev.microservicos.userapi.service;

import com.jnsdev.microservicos.shoppingclient.dto.UserDTO;
import com.jnsdev.microservicos.shoppingclient.exception.UserNotFoundException;
import com.jnsdev.microservicos.userapi.converter.DTOConverter;
import com.jnsdev.microservicos.userapi.model.User;
import com.jnsdev.microservicos.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Autor Jairo Nascimento
 * @Created 24/09/2021 - 16:26
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios.stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        Optional<User> usuario = userRepository.findById(id);
        if (usuario.isPresent()) {
            return DTOConverter.convert(usuario.get());
        }
        return null;
    }

    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));
        return DTOConverter.convert(user);
    }

    public UserDTO delete(Long userId) {
        Optional<User> usuario = userRepository.findById(userId);
        if (usuario.isPresent()) {
            userRepository.delete(usuario.get());
        }
        return null;
    }

    public List<UserDTO> queryByName(String name) {
        List<User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios.stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findByCpf(String cpf) {
        User usuario = userRepository.findByCpf(cpf);
        if (usuario != null) {
            return DTOConverter.convert(usuario);
        }
        throw new UserNotFoundException();
    }
}
