package com.example.market.exception;

import lombok.Getter;

@Getter

public class CustomException extends RuntimeException {

    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage()); // 여기서 message 설정됨
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}



// @Getter
// @RequiredArgsConstructor
// public class CustomException extends RuntimeException {

// private final ErrorCode errorCode;

// public CustomException(ErrorCode errorCode) {
// super(errorCode.getMessage()); // 여기서 message 설정됨
// this.errorCode = errorCode;
// }

// public ErrorCode getErrorCode() {
// return errorCode;
// }
// }