package com.example.market.dto.request.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequestDto {

    private String userEmail;

    private String userPw;
}
