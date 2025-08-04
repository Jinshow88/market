package com.example.market.security;

import com.example.market.common.swagger.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyUser {

    private long userId;
    private Role role;
    
}
