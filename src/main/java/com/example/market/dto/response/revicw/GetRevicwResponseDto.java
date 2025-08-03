package com.example.market.dto.response.revicw;

import static com.example.market.common.swagger.GlobalConst.SUCCESS_CODE;
import static com.example.market.common.swagger.GlobalConst.SUCCESS_MESSAGE;

import com.example.market.dto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetRevicwResponseDto extends ResponseDto{

    private GetRevicwResponseDto(){
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static ResponseEntity<GetRevicwResponseDto> success(){
        GetRevicwResponseDto result = new GetRevicwResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
}
