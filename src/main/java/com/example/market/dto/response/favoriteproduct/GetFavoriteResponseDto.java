package com.example.market.dto.response.favoriteproduct;

import static com.example.market.common.swagger.GlobalConst.SUCCESS_CODE;
import static com.example.market.common.swagger.GlobalConst.SUCCESS_MESSAGE;

import com.example.market.dto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetFavoriteResponseDto extends ResponseDto{

    private GetFavoriteResponseDto(){
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
    }
    
    public static ResponseEntity<GetFavoriteResponseDto> success(){
        GetFavoriteResponseDto result = new GetFavoriteResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
