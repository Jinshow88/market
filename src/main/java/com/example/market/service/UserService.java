package com.example.market.service;

import com.example.market.dto.request.user.LoginRequestDto;
import com.example.market.dto.request.user.SignUpRequestDto;
import com.example.market.dto.response.user.LoginResponseDto;
import com.example.market.dto.response.user.SignUpResponseDto;

import org.springframework.http.ResponseEntity;

public interface UserService {

    
    ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto dto);

    ResponseEntity<LoginResponseDto> login(LoginRequestDto dto);
}
