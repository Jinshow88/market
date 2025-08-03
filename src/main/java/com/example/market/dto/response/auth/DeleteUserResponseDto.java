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
public class DeleteUserResponseDto extends ResponseDto{

    private DeleteUserResponseDto() {
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
    }
    
    public static ResponseEntity<DeleteUserResponseDto> success(){
        DeleteUserResponseDto result = new DeleteUserResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
