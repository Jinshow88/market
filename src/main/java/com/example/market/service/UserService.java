package com.example.market.service;

import com.example.market.dto.request.user.LoginRequestDto;
import com.example.market.dto.response.user.LoginResponseDto;

import org.springframework.http.ResponseEntity;

public interface UserService {


    ResponseEntity<LoginResponseDto> login(LoginRequestDto dto);
}
