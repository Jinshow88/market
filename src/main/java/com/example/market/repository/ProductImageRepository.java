package com.example.market.repository;


import com.example.market.entity.Productimage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository<Productimage, Long>{
    
}
