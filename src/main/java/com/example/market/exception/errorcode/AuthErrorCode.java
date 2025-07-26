package com.example.market.exception.errorcode;

import com.example.market.exception.ErrorCode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthErrorCode implements ErrorCode {

    EUI(HttpStatus.BAD_REQUEST, "이미 존재하는 사용자입니다."), // EXISTENCE_USER_ID
    NEU(HttpStatus.BAD_REQUEST, "존재하지 않는 사용자입니다."), // NOT_EXISTENCE_USER_ID
    PW(HttpStatus.BAD_REQUEST, "비밀번호가 틀렸습니다."); // PASSWORD_WRONG

    private final HttpStatus httpStatus;
    private final String message;
}
