package com.example.market.entity;

import com.example.market.entity.common.UpdatedAt;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "review")
public class Review extends UpdatedAt{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private long productId;

    private long reviewerId;

    private long revieweeId;

    private long saleReviewType;

    private String content;




}
