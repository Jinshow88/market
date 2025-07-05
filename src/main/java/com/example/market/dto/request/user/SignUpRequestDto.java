package com.example.market.dto.request.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {
    
    private String userEmail;

    private String userPw;

    private String userNic;

    private String userName;

    private String userPhone;

    private String userAddress;
}
