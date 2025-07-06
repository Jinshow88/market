package com.example.market.dto.request.auth;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {
    @JsonIgnore
    private long id;

    private String userName;
    
    private String userNic;

    private String userEmail;

    private String userPw;

    private String userPhone;

    private String userAddress;
}
