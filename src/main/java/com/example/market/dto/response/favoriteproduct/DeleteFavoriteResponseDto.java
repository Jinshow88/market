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
public class DeleteFavoriteResponseDto extends ResponseDto{

    private String userNic;
    private long isValid;

    private DeleteFavoriteResponseDto(String userNic, long isValid){
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
        this.userNic = userNic;
        this.isValid = isValid;
    }
    
    public static ResponseEntity<DeleteFavoriteResponseDto> success(String userNic, long isValid){
        DeleteFavoriteResponseDto result = new DeleteFavoriteResponseDto(userNic, isValid);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
