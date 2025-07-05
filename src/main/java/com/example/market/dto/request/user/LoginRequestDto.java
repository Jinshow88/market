package com.example.market.dto.request.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDto {
    
    @JsonIgnore
    private long id;

    private String userPw;

    private String userEmail;
}
