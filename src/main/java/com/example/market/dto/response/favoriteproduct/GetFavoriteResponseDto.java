package com.example.market.dto.response.favoriteproduct;

import static com.example.market.common.swagger.GlobalConst.SUCCESS_CODE;
import static com.example.market.common.swagger.GlobalConst.SUCCESS_MESSAGE;

import java.util.List;

import com.example.market.dto.ResponseDto;
import com.example.market.dto.object.favoriteproduct.GetFavoriteSellerDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetFavoriteResponseDto extends ResponseDto{

    private List<GetFavoriteSellerDto> getFavoriteSellerDto;

    private GetFavoriteResponseDto(List<GetFavoriteSellerDto> getFavoriteSellerDto){
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
        this.getFavoriteSellerDto = getFavoriteSellerDto;
    }
    
    public static ResponseEntity<GetFavoriteResponseDto> success(List<GetFavoriteSellerDto> getFavoriteSellerDto){
        GetFavoriteResponseDto result = new GetFavoriteResponseDto(getFavoriteSellerDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
