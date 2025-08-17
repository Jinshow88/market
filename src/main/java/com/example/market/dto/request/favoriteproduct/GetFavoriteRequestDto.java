package com.example.market.dto.request.favoriteproduct;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class GetFavoriteRequestDto {
    @JsonIgnore
    private long userId;
    @JsonIgnore
    private long productId;
    @JsonIgnore
    private long favoriteId;
}
