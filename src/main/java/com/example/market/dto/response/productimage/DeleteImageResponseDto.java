package com.example.market.dto.response.productimage;

import static com.example.market.common.swagger.GlobalConst.SUCCESS_CODE;
import static com.example.market.common.swagger.GlobalConst.SUCCESS_MESSAGE;

import com.example.market.dto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteImageResponseDto extends ResponseDto{

    private DeleteImageResponseDto(){
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
    }
    
    public ResponseEntity<DeleteImageResponseDto> success(){
        DeleteImageResponseDto result = new DeleteImageResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
