package com.example.market.dto.request.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDto {
    private long id;
    private String userPw;
    private String userEmail;
}
