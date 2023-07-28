package com.repo.aldinaldin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.repo.aldinaldin.model.Basket;
import com.repo.aldinaldin.model.Product;
import com.repo.aldinaldin.model.User;
import com.repo.aldinaldin.repository.IBasketRepository;
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

}
