package com.example.market.dto.response.auth;

import com.example.market.dto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpResponseDto extends ResponseDto{
    
    private long userId;
    private SignUpResponseDto(long userId){
        this.userId = userId;

    }

    public static ResponseEntity<SignUpResponseDto> success(long userId){
        SignUpResponseDto result = new SignUpResponseDto(userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
