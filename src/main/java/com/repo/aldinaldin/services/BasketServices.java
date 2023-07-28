package com.repo.aldinaldin.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.repo.aldinaldin.model.Basket;
import com.repo.aldinaldin.model.Order;
import com.repo.aldinaldin.model.OrderProduct;
import com.repo.aldinaldin.model.Product;
import com.repo.aldinaldin.model.User;
import com.repo.aldinaldin.repository.IBasketRepository;
import com.repo.aldinaldin.repository.IOrderProductRepository;
import com.repo.aldinaldin.repository.IOrderRepository;
import com.repo.aldinaldin.repository.IProductRepository;
import com.repo.aldinaldin.repository.IUserRepository;

@Service
public class BasketServices {

    @Autowired
    IProductRepository productRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IBasketRepository basketRepository;
    @Autowired
    IOrderProductRepository orderProductRepository;
    @Autowired
    IOrderRepository orderRepository;

    public ResponseEntity<?> CreateBasket(Product product, long customer_id) {
        try {
            User getUser;
            getUser = userRepository.getOne(customer_id);

            Basket basket = Basket.builder()
                    .user(getUser)
                    .product(product)
                    .build();
            basketRepository.save(basket);

            return ResponseEntity.status(200).build();
        } catch (Error err) {
            return ResponseEntity.status(201).build();
        }
    }

    @Transactional
    public ResponseEntity<?> GetAllBaskets(long id) {
        try {
            List<Basket> baskets = basketRepository.findProductsByCustomerId(id);
            return ResponseEntity.status(200).body(baskets);
        } catch (Error err) {
            return ResponseEntity.status(404).build();
        }
    }

    public ResponseEntity<?> DeleteProduct(long id) {
        Basket basket = basketRepository.getOne(id);
        try {
            basketRepository.delete(basket);
            return ResponseEntity.status(200).build();
        } catch (Error err) {
            return ResponseEntity.status(404).build();
        }
    }

    @Transactional
    public ResponseEntity<?> CreateOrder(long id) {
        try {
            User getUser;
            getUser = userRepository.getOne(id);
            List<Basket> baskets = basketRepository.findProductsByCustomerId(id);

            double orderInvoice = 0;
            Order order = Order.builder()
                    .orderStatus("Hazırlanıyor")
                    .lastUpdatedDate(LocalDate.now())
                    .user(getUser)
                    .creationDate(LocalDate.now())
                    .build();
            orderRepository.save(order);
            for (Basket basket : baskets) {
                OrderProduct orderProduct = OrderProduct.builder()
                        .product(basket.getProduct())
                        .order(order)
                        .build();
                orderProductRepository.save(orderProduct);
                orderInvoice += basket.getProduct().getPrice();
                basketRepository.delete(basket);
            }
            order.setInvoice(orderInvoice);
            orderRepository.save(order);

            return ResponseEntity.status(200).build();
        } catch (Error err) {
            return ResponseEntity.status(404).build();
        }
    }

}
