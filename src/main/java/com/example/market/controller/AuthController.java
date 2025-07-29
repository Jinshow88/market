package com.example.market.controller;

import static com.example.market.common.swagger.description.auth.SignInSwgger.USER_SIGN_IN_DESCRIPTION;
import static com.example.market.common.swagger.description.auth.SignInSwgger.USER_SIGN_IN_RESPONSE_ERROR_CODE;

import com.example.market.dto.request.auth.DeleteUserRequestDto;
import com.example.market.dto.request.auth.SignInRequestDto;
import com.example.market.dto.request.auth.SignOutRequestDto;
import com.example.market.dto.request.auth.SignUpRequestDto;
import com.example.market.dto.response.auth.DeleteUserResponseDto;
import com.example.market.dto.response.auth.SignInResponseDto;
import com.example.market.dto.response.auth.SignOutResponseDto;
import com.example.market.dto.response.auth.SignUpResponseDto;
import com.example.market.service.AuthService;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "인증")
public class AuthController {
    private final AuthService service;
    // 회원가입 : 이메일, 비밀번호, 소셜로그인
    // 마이페이지 : 프로필, 내가쓴글, 찜목록
    // 로그아웃 : jwt 토근 삭제 및 무효화
    // 이메일 인증, 휴대폰 인증

    // 로그인
    @PostMapping("/sign-in")
    @Operation(summary = "로그인", description = USER_SIGN_IN_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = USER_SIGN_IN_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SignInResponseDto.class)))
    public ResponseEntity<SignInResponseDto> signIn(@RequestBody SignInRequestDto dto) {
        return service.signIn(dto);
    }

    // 회원가입
    @PostMapping("/sign-up")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto dto) {
        return service.signUp(dto);
    }

    // 로그아웃
    @PostMapping("/sign-out")
    public ResponseEntity<SignOutResponseDto> signOut(@RequestBody SignOutRequestDto dto) {
        return service.signOut(dto);
    }

    //회원탈퇴
    @DeleteMapping()
    public ResponseEntity<DeleteUserResponseDto> deleteUser(@ParameterObject DeleteUserRequestDto dto){
        return service.deleteUser(dto);
    }

}
