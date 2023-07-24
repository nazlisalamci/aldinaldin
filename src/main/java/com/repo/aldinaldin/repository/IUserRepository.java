package com.repo.aldinaldin.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repo.aldinaldin.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Long>{
    User findByMailAndPassword(String mail, String password);
}
