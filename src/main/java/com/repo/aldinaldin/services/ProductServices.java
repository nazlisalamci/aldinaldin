package com.repo.aldinaldin.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.repo.aldinaldin.model.Product;
import com.repo.aldinaldin.model.User;
import com.repo.aldinaldin.repository.IProductRepository;
import com.repo.aldinaldin.repository.IUserRepository;

@Service
public class ProductServices {
    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IUserRepository userRepository;

    public ResponseEntity<?> CreateProduct(Product product, long id) {
        User getUser;
        getUser = userRepository.getOne(id);
        try {
            product.setUser(getUser);
            product.setDeleted(false);
            iProductRepository.save(product);
            return ResponseEntity.status(200).body(product);
        } catch (Error err) {
            return ResponseEntity.status(201).build();
        }

    }

    @Transactional
    public ResponseEntity<?> GetProduct(long id) {
        try {
            List<Product> products = iProductRepository.findProducts(id);
            return ResponseEntity.status(200).body(products);
        } catch (Error err) {
            return ResponseEntity.status(404).build();
        }

    }

    public ResponseEntity<?> DeleteProduct(long id) {
        Product product = iProductRepository.getOne(id);
        try {
            iProductRepository.delete(product);
            return ResponseEntity.status(200).build();
        } catch (Error err) {
            return ResponseEntity.status(404).build();
        }

    }

    @Transactional
    public ResponseEntity<?> UpdateProduct(Product product) {
        Product updateProduct = iProductRepository.getOne(product.getId());
        try {
            updateProduct.setName(product.getName());
            updateProduct.setDescription(product.getDescription());
            updateProduct.setImage(product.getImage());
            updateProduct.setPrice(product.getPrice());
            iProductRepository.save(updateProduct);
            return ResponseEntity.status(202).build();
        } catch (Error err) {
            return ResponseEntity.status(201).build();
        }

    }

    public ResponseEntity<?> GetAllProducts() {
        try {
            List<Product> products = iProductRepository.findAll();
            return ResponseEntity.status(200).body(products);
        } catch (Error err) {
            return ResponseEntity.status(404).build();
        }

    }

}
