package com.repo.aldinaldin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.repo.aldinaldin.model.User;
import com.repo.aldinaldin.services.UserServices;

@RestController
@CrossOrigin
public class UserController {
    
    @Autowired
    UserServices userServices;

    @PostMapping("api/1.0/login-user")
    public ResponseEntity<?> postLoginUser(@RequestBody Map<String, User> requestParams) throws Exception {
        //return ResponseEntity.status(200).body(requestParams.get("User").getMail());
       return  userServices.LoginUser(requestParams.get("User")); 
    }
    
}

