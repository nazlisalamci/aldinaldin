package com.repo.aldinaldin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.repo.aldinaldin.services.OrderServices;

@RestController
@CrossOrigin
public class OrdersController {
    @Autowired
    OrderServices orderServices;

    @GetMapping(path = "api/1.0/get-all-orders/{Id}")
    public ResponseEntity<?> GetAllOrders(@PathVariable("Id") Long id) throws Exception {
        return orderServices.GetAllOrders(id);
    }

    @GetMapping(path = "api/1.0/order-detail/{Id}")
    public ResponseEntity<?> OrderDetail(@PathVariable("Id") Long id) throws Exception {
        return orderServices.OrderDetail(id);
    }

    @GetMapping(path = "api/1.0/seller-all-orders")
    public ResponseEntity<?> SellerOrders() throws Exception {
        return orderServices.SellerOrders();
    }
     @GetMapping(path = "api/1.0/change-order-status/{Id}")
    public ResponseEntity<?> OrderStatusChange(@PathVariable("Id") Long id) throws Exception {
        return orderServices.OrderStatusChange(id);
    }
      @GetMapping(path = "api/1.0/cancel-order/{Id}")
    public ResponseEntity<?> CancelOrder(@PathVariable("Id") Long id) throws Exception {
        return orderServices.CancelOrder(id);
    }

}
