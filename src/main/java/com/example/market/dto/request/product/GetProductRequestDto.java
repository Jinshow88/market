package com.example.market.dto.request.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductRequestDto {
    @JsonIgnore
    private long userId;

    private String title;
    @JsonIgnore
    private long viewCnt;
    @JsonIgnore
    private long productId;
}
