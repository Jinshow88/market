package com.example.market.dto.request.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    private long id;
    private String userPw;
    private String userEmail;
}
