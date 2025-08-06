package com.example.market.entity;

import com.example.market.entity.common.UpdatedAt;

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
@Table(name = "review")
public class Review extends UpdatedAt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    
    @ManyToOne
    @JoinColumn(name = "물품ID")
    private Product productId;
    
    @ManyToOne
    @JoinColumn(name = "구매자ID")
    private Users buyerId;
    
    @ManyToOne
    @JoinColumn(name = "판매자ID")
    private Users sellerId;
    
    @Column(name = "거래후기타입")
    private long saleReviewType;
    
    @Column(name = "내용")
    private String content;

}
