package com.example.market.repository;

import com.example.market.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
    
    Boolean existsByUserName(String userName);

    Users findByUserEmail(String userEmail);
}
