package com.repo.aldinaldin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.repo.aldinaldin.model.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
     @Query(value = "SELECT * FROM aldinaldin.order u WHERE u.user_id = ?1 ORDER BY u.creation_date DESC ", nativeQuery = true)
    List<Order> findOrdes(long user_id);    
}
