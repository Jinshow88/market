package com.example.market.entity;

import java.time.LocalDateTime;

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
@Table(name = "")
public class Product extends UpdatedAt{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long sellerId;

    private long buyerId;

    private long categoryId;

    private long price;

    private String title;

    private String descripion;

    private String location;

    private long productState;

    private String thumbNailImage;

    private long viewCnt;

    private long refreshCnt;

    private LocalDateTime refreshedAt;

}
