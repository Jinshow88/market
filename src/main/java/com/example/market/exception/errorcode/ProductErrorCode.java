package com.example.market.exception.errorcode;

import com.example.market.exception.ErrorCode;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductErrorCode implements ErrorCode {

    NP(HttpStatus.BAD_REQUEST, "상품이 존재하지 않습니다!!!."); // NOT_PRODUCT
    

    private final HttpStatus httpStatus;
    private final String message;
}
