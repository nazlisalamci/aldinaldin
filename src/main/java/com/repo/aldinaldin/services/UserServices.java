package com.repo.aldinaldin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.repo.aldinaldin.model.User;
import com.repo.aldinaldin.repository.IUserRepository;

@Service
public class UserServices {

    @Autowired
    IUserRepository userRepository;

    public ResponseEntity<?> LoginUser(User user) {
        User getUser;
        getUser = userRepository.findByMailAndPassword(user.getMail(), user.getPassword());
        if (getUser != null) {
            return ResponseEntity.status(200).body(getUser);
        } else {
            return ResponseEntity.status(404).build();

        }

    }

}
