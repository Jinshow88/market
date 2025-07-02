package com.example.market.dto.response.user;

import com.example.market.dto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto extends ResponseDto {
    
    private LoginResponseDto(){

    }

    public static ResponseEntity<ResponseDto> success(){
        ResponseDto result = new ResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
