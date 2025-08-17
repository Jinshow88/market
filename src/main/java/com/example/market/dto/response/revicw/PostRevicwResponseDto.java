package com.example.market.dto.response.revicw;

import static com.example.market.common.swagger.GlobalConst.SUCCESS_CODE;
import static com.example.market.common.swagger.GlobalConst.SUCCESS_MESSAGE;

import com.example.market.dto.ResponseDto;
import com.example.market.dto.object.revicw.PostRevicwObjectDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRevicwResponseDto extends ResponseDto{

    private PostRevicwObjectDto postRevicwObjectDto;
    private PostRevicwResponseDto(PostRevicwObjectDto postRevicwObjectDto){
        super(SUCCESS_CODE, SUCCESS_MESSAGE);
        this.postRevicwObjectDto = postRevicwObjectDto;
    }

    public static ResponseEntity<PostRevicwResponseDto> success(PostRevicwObjectDto postRevicwObjectDto){
        PostRevicwResponseDto result = new PostRevicwResponseDto(postRevicwObjectDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    
}
