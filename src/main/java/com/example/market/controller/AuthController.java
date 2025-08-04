package com.example.market.controller;

import static com.example.market.common.swagger.description.auth.SignInSwagger.USER_SIGN_IN_DESCRIPTION;
import static com.example.market.common.swagger.description.auth.SignInSwagger.USER_SIGN_IN_RESPONSE_ERROR_CODE;

import com.example.market.common.swagger.description.auth.DeleteUserSwagger;
import com.example.market.common.swagger.description.auth.SignOutSwagger;
import com.example.market.common.swagger.description.auth.SignUpSwagger;
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
import jakarta.servlet.http.HttpServletResponse;
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
    public ResponseEntity<SignInResponseDto> signIn(HttpServletResponse res, @RequestBody SignInRequestDto dto) {
        return service.signIn(res, dto);
    }

    // 회원가입
    @PostMapping("/sign-up")
    @Operation(summary = "회원가입", description = SignUpSwagger.SIGN_UP_USER_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = SignUpSwagger.SIGN_UP_USER_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SignUpResponseDto.class)))
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto dto) {
        return service.signUp(dto);
    }

    // 로그아웃
    @PostMapping("/sign-out")
    @Operation(summary = "로그아웃", description = SignOutSwagger.USER_SIGN_OUT_DESCRIPION)
    @ApiResponse(responseCode = "200", description = SignOutSwagger.USER_SIGN_OUT_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SignOutResponseDto.class)))
    public ResponseEntity<SignOutResponseDto> signOut(@RequestBody SignOutRequestDto dto) {
        return service.signOut(dto);
    }

    //회원탈퇴
    @DeleteMapping("/delete-user")
    @Operation(summary = "회원탈퇴", description = DeleteUserSwagger.DELETE_USER_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = DeleteUserSwagger.DELETE_USER_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DeleteUserResponseDto.class)))
    public ResponseEntity<DeleteUserResponseDto> deleteUser(@ParameterObject DeleteUserRequestDto dto){
        return service.deleteUser(dto);
    }

}
