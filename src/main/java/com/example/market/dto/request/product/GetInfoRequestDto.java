package com.example.market.dto.request.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetInfoRequestDto {

    @JsonIgnore
    private long userId;
    
}
