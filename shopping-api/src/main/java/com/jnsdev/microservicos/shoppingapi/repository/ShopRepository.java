package com.jnsdev.microservicos.shoppingapi.repository;

import com.jnsdev.microservicos.shoppingapi.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 26/09/2021 - 18:05
 */
@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository {

    public List<Shop> findAllByUserIdentifier(String userIdentifier);

    public List<Shop> findAllByTotalGreaterThan(Float total);

    List<Shop> findAllByDateGreaterThanEqual(Date date);
}
