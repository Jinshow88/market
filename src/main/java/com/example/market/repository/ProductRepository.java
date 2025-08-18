package com.example.market.repository;

import java.util.List;

import com.example.market.entity.Product;
import com.example.market.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByTitle(String title);

    List<Product> findAllBySellerId(Users sellerId);

}
