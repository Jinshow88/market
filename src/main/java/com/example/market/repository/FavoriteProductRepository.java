package com.example.market.repository;

import java.util.List;

import com.example.market.entity.FavoriteProduct;
import com.example.market.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteProductRepository extends JpaRepository<FavoriteProduct, Long> {

    long findByIsValid(Integer isValid);

    List<FavoriteProduct> findByProductId(Product productId);

    List<FavoriteProduct> findAllBySellerId_UserId(Long userId);
}
