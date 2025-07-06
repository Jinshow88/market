package com.example.market.repository;

import com.example.market.entity.Manner;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MannerRepository extends JpaRepository<Manner, Long>{
    
}
