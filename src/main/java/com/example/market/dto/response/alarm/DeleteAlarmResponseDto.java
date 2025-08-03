package com.example.market.dto.response.alarm;

import static com.example.market.common.swagger.GlobalConst.SUCCESS_CODE;
import static com.example.market.common.swagger.GlobalConst.SUCCESS_MESSAGE;

import com.example.market.dto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeleteAlarmResponseDto extends ResponseDto{
    
    private DeleteAlarmResponseDto(){
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public static ResponseEntity<DeleteAlarmResponseDto> success(){
        DeleteAlarmResponseDto result = new DeleteAlarmResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
