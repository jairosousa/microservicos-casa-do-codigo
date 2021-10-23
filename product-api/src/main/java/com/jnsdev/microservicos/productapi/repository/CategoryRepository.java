package com.jnsdev.microservicos.productapi.repository;

import com.jnsdev.microservicos.productapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Autor Jairo Nascimento
 * @Created 26/09/2021 - 17:09
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
