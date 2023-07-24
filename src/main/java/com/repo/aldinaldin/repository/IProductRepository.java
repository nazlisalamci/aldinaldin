package com.repo.aldinaldin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.repo.aldinaldin.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long>{
        @Query(value = "SELECT * FROM aldinaldin.product u WHERE u.seller_id = ?1  ",
    nativeQuery = true)
    List<Product> findProducts(long seller_id);
}
