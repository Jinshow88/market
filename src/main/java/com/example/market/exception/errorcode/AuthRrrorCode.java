package com.example.market.exception.errorcode;

import com.example.market.exception.ErrorCode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthRrrorCode implements ErrorCode {


    EUI(HttpStatus.BAD_REQUEST, "이미 존재하는 사용자입니다."); // EXISTENCE_USER_ID

    
    private final HttpStatus httpStatus;
    private final String message;
}
