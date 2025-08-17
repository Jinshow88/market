package com.example.market.dto.object.revicw;

import lombok.Data;

@Data
public class PostRevicwObjectDto {
    
    private long productId;

    private long buyerId;

    private long sellerId;

    private String content;

    private long saleReviewType;
}
