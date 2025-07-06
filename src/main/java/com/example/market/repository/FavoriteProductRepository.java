package com.example.market.repository;

import com.example.market.entity.FavoriteProduct;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteProductRepository extends JpaRepository<FavoriteProduct, Long>{
    
}
