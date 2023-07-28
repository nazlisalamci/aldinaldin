package com.repo.aldinaldin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.repo.aldinaldin.model.Basket;
import com.repo.aldinaldin.model.Product;

@Repository
public interface IBasketRepository extends JpaRepository<Basket, Long> {

    @Query(value = "SELECT * FROM aldinaldin.basket b WHERE b.customer_id = ?1", nativeQuery = true)
    List<Basket> findProductsByCustomerId(long customer_id);
}
