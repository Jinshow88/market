package com.example.market.entity;

import com.example.market.entity.common.UpdatedAt;

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
@Table(name = "review")
public class Review extends UpdatedAt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String reviewId;
    @Column(name = "물품ID")
    private long productId;
    @Column(name = "구매자ID")
    private long reviewerId;
    @Column(name = "판매자ID")
    private long revieweeId;
    @Column(name = "거래후기타입")
    private long saleReviewType;
    @Column(name = "내용")
    private String content;

}
