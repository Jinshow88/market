package com.example.market.dto.response.product;

import static com.example.market.common.swagger.GlobalConst.SUCCESS_CODE;
import static com.example.market.common.swagger.GlobalConst.SUCCESS_MESSAGE;

import java.util.List;

import com.example.market.dto.ResponseDto;
import com.example.market.dto.object.product.GetProductObjectDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductResponseDto extends ResponseDto{

    private List<GetProductObjectDto> getProductObjectDtos;

    private GetProductResponseDto(List<GetProductObjectDto> getProductObjectDtos){
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
        this.getProductObjectDtos = getProductObjectDtos;
    }

    public static ResponseEntity<GetProductResponseDto> success(List<GetProductObjectDto> getProductObjectDtos){
        GetProductResponseDto result = new GetProductResponseDto(getProductObjectDtos);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
}
