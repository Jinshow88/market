package com.example.market.dto.request.favoriteproduct;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteFavoriteRequestDto {

    @JsonIgnore
    private long userId;

    private long favoriteId;
    @JsonIgnore
    private long isValid;
    @JsonIgnore
    private String userNic;

}
