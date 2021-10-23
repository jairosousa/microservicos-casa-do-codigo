package com.jnsdev.microservicos.productapi.repository;

import com.jnsdev.microservicos.productapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 26/09/2021 - 17:10
 */
@Repository
public interface ProducrRepository extends JpaRepository<Product, Long> {
    @Query(value = "select p "
            + "from product p "
            + "join category c on p.category.id = c.id "
            + "where c.id = :categoryId ")
    public List<Product> getProductByCategory(@Param("categoryId") long categoryId);

    public Product findByProductIdentifier(String productIdentifier);
}
