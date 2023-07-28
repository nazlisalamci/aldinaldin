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
import com.repo.aldinaldin.services.ProductServices;

@RestController
@CrossOrigin
public class ProductController {
   @Autowired
   ProductServices productServices;

   @PostMapping(path = "api/1.0/create-product/{UserId}")
   public ResponseEntity<?> postCreate(@RequestBody Map<String, Product> requestBody,
         @PathVariable("UserId") Long user_id) throws Exception {
      return productServices.CreateProduct(requestBody.get("Product"), user_id);
   }

   @GetMapping(path = "api/1.0/get-product/{Id}")
   public ResponseEntity<?> GetProduct(@PathVariable("Id") Long id) throws Exception {
      return productServices.GetProduct(id);
   }

   @GetMapping(path = "api/1.0/delete-product/{Id}")
   public ResponseEntity<?> DeleteProduct(@PathVariable("Id") Long id) throws Exception {
      return productServices.DeleteProduct(id);
   }

   @PostMapping(path = "api/1.0/update-product")
   public ResponseEntity<?> UpdateProduct(@RequestBody Map<String, Product> requestBody) throws Exception {
      return productServices.UpdateProduct(requestBody.get("Product"));
   }

   @GetMapping(path = "api/1.0/get-all-product")
   public ResponseEntity<?> UpdateProduct() throws Exception {
      return productServices.GetAllProducts();
   }

}
