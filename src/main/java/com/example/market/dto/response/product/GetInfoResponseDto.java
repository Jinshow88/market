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
public class GetInfoResponseDto extends ResponseDto {

    private GetInfoResponseDto(){
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static ResponseEntity<GetInfoResponseDto> success(){
        GetInfoResponseDto result = new GetInfoResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
