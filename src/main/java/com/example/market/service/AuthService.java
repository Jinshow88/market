package com.example.market.service;

import com.example.market.dto.request.auth.SignInRequestDto;
import com.example.market.dto.request.auth.SignOutRequestDto;
import com.example.market.dto.request.auth.SignUpRequestDto;
import com.example.market.dto.response.auth.SignInResponseDto;
import com.example.market.dto.response.auth.SignOutResponseDto;
import com.example.market.dto.response.auth.SignUpResponseDto;

import org.springframework.http.ResponseEntity;

public interface AuthService {
    // 회원가입
    ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto dto);

    // 로그인
    ResponseEntity<SignInResponseDto> signIn(SignInRequestDto dto);

    // 로그아웃
    ResponseEntity<SignOutResponseDto> signOut(SignOutRequestDto dto);

    //회원탈퇴
}
