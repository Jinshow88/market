package com.example.market.dto.response.auth;

import static com.example.market.common.swagger.GlobalConst.SUCCESS_CODE;
import static com.example.market.common.swagger.GlobalConst.SUCCESS_MESSAGE;

import com.example.market.dto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignOutResponseDto extends ResponseDto {

    private SignOutResponseDto(){
        super(SUCCESS_CODE, SUCCESS_MESSAGE);

    }
    
    public static ResponseEntity<SignOutResponseDto> success(){
        SignOutResponseDto result = new SignOutResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
