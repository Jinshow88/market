package com.example.market.dto.request.revicw;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRevicwRequestDto {
    @JsonIgnore
    private long userId;
    
    @JsonIgnore
    private long productId;

    @JsonIgnore
    private long buyerId;

    @JsonIgnore
    private long sellerId;

    @JsonIgnore
    private long saleReviewType;

    private String content;



}
