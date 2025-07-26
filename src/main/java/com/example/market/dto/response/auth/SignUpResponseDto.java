package com.example.market.dto.response.auth;

import com.example.market.dto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

import static com.example.market.common.swagger.GlobalConst.SUCCESS_CODE;
import static com.example.market.common.swagger.GlobalConst.SUCCESS_MESSAGE;

@Setter
@Getter
public class SignUpResponseDto extends ResponseDto {

    // private long userId;
    private SignUpResponseDto() {
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
        // this.userId = userId;

    }

    public static ResponseEntity<SignUpResponseDto> success() {
        SignUpResponseDto result = new SignUpResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
