package com.repo.aldinaldin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.repo.aldinaldin.model.Order;
import com.repo.aldinaldin.model.OrderProduct;
import com.repo.aldinaldin.repository.IOrderProductRepository;
import com.repo.aldinaldin.repository.IOrderRepository;

@Service
public class OrderServices {

    @Autowired
    IOrderRepository iOrderRepository;

    @Autowired
    IOrderProductRepository iOrderProductRepository;

    public ResponseEntity<?> GetAllOrders(long customer_id) {
        try {
            List<Order> orders = iOrderRepository.findOrdes(customer_id);
            return ResponseEntity.status(200).body(orders);
        } catch (Error err) {
            return ResponseEntity.status(201).build();
        }
    }
    @Transactional
    public ResponseEntity<?> OrderDetail(long order_id) {
        try {
            List<OrderProduct> orderProduct = iOrderProductRepository.findOrderDetail(order_id);
            return ResponseEntity.status(200).body(orderProduct);
        } catch (Error err) {
            return ResponseEntity.status(201).build();
        }
    }

    @Transactional
    public ResponseEntity<?> SellerOrders() {
        try {
             List<Order> orders = iOrderRepository.findAll();
            return ResponseEntity.status(200).body(orders);
        } catch (Error err) {
            return ResponseEntity.status(201).build();
        }
    }

  public ResponseEntity<?> OrderStatusChange(long id) {
        try {
            Order order=iOrderRepository.getOne(id);
            order.setOrderStatus(order.getOrderStatus()+1);
            iOrderRepository.save(order);
            return ResponseEntity.status(200).build();
        } catch (Error err) {
            return ResponseEntity.status(201).build();
        }
    }
      public ResponseEntity<?> CancelOrder(long id) {
        try {
            Order order=iOrderRepository.getOne(id);
            order.setOrderStatus(4);
            iOrderRepository.save(order);
            return ResponseEntity.status(200).build();
        } catch (Error err) {
            return ResponseEntity.status(201).build();
        }
    }
}
