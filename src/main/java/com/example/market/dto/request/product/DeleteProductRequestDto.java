package com.example.market.dto.request.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteProductRequestDto {
    @JsonIgnore
    private long userId;

    
    private long productId;
    @JsonIgnore
    private String sellerId;

}
