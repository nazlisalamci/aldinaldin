package com.repo.aldinaldin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.repo.aldinaldin.model.OrderProduct;

@Repository
public interface IOrderProductRepository extends JpaRepository<OrderProduct, Long> {
    
}
