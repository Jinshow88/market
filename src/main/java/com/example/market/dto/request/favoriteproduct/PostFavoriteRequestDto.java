package com.example.market.dto.request.favoriteproduct;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostFavoriteRequestDto {
    @JsonIgnore
    private long userId;
    @JsonIgnore
    private long sellerId;

    private long productId;



}
