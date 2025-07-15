package com.example.market.exception.errorcode;

import com.example.market.exception.ErrorCode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {
        // 400
    WG(HttpStatus.BAD_REQUEST, "글램핑 ID를 올바르게 입력해주세요."); // WRONG_GLAMP_ID

    private final HttpStatus httpStatus;
    private final String message;

}
