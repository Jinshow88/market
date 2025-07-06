package com.example.market.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "인증")
public class AuthController {
    //회원가입 : 이메일, 비밀번호, 소셜로그인
    // 마이페이지 : 프로필, 내가쓴글, 찜목록
    // 로그아웃 : jwt 토근 삭제 및 무효화
    // 이메일 인증, 휴대폰 인증

}
