package com.repo.aldinaldin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.repo.aldinaldin.model.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    
}
