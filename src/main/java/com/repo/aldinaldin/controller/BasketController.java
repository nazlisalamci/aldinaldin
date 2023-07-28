package com.repo.aldinaldin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.repo.aldinaldin.model.Product;
import com.repo.aldinaldin.services.BasketServices;

@RestController
@CrossOrigin
public class BasketController {
    @Autowired
    BasketServices basketServices;

    @PostMapping(path = "api/1.0/add-to-basket/{UserId}")
    public ResponseEntity<?> CreateBasket(@RequestBody Map<String, Product> requestBody,
            @PathVariable("UserId") Long user_id) throws Exception {
        return basketServices.CreateBasket(requestBody.get("Product"), user_id);
    }
    
   @GetMapping(path = "api/1.0/get-all-basket/{UserId}")
   public ResponseEntity<?> UpdateProduct(  @PathVariable("UserId") Long user_id) throws Exception {
      return basketServices.GetAllBaskets(user_id);
   }
   @GetMapping(path = "api/1.0/delete-product-in-basket/{Id}")
   public ResponseEntity<?> DeleteProduct(@PathVariable("Id") Long id) throws Exception {
      return basketServices.DeleteProduct(id);
   }
}
