package com.example.market.entity;

import com.example.market.entity.common.CreatedAt;

import jakarta.persistence.Column;
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
@Table(name = "favorite_profuct")
public class FavoriteProduct extends CreatedAt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "사용자ID")
    private long userId;
    @Column(name = "물품ID")
    private long productId;
    @Column(name = "찜상태")
    private boolean isValid;

}
