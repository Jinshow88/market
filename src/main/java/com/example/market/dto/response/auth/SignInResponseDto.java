package com.example.market.dto.response.auth;

import static com.example.market.common.swagger.GlobalConst.SUCCESS_CODE;
import static com.example.market.common.swagger.GlobalConst.SUCCESS_MESSAGE;

import com.example.market.dto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SignInResponseDto extends ResponseDto {

    private String accessToken;

    private SignInResponseDto(String accessToken) {
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
        this.accessToken = accessToken;
    }

    public static ResponseEntity<SignInResponseDto> success(String accessToken) {
        SignInResponseDto result = new SignInResponseDto(accessToken);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
