package com.example.market.dto.response.product;

import static com.example.market.common.swagger.GlobalConst.SUCCESS_CODE;
import static com.example.market.common.swagger.GlobalConst.SUCCESS_MESSAGE;

import com.example.market.dto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductResponseDto extends ResponseDto{

    private UpdateProductResponseDto(){
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static ResponseEntity<UpdateProductResponseDto> success(){
        UpdateProductResponseDto result = new UpdateProductResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
}
