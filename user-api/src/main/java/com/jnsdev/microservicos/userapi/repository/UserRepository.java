package com.jnsdev.microservicos.userapi.repository;

import com.jnsdev.microservicos.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 24/09/2021 - 16:22
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByCpf(String cpf);

    List<User> queryByNomeLike(String name);
}
