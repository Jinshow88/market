package com.example.market.entity;

import com.example.market.entity.common.CreatedAt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "favorite_profuct")
public class FavoriteProduct extends CreatedAt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;
    @ManyToOne
    @JoinColumn(name = "사용자ID")
    private Users sellerId;
    @ManyToOne
    @JoinColumn(name = "물품ID")
    private Product productId;
    @Column(name = "찜상태")
    private boolean isValid;

}
