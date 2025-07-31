package com.example.market.service;

import com.example.market.dto.request.productimage.DeleteImageRequestDto;
import com.example.market.dto.request.productimage.GetImageRequestDto;
import com.example.market.dto.request.productimage.PostImageRequestDto;
import com.example.market.dto.request.productimage.UpdateImageRequestDto;
import com.example.market.dto.response.productimage.DeleteImageResponseDto;
import com.example.market.dto.response.productimage.GetImageResponseDto;
import com.example.market.dto.response.productimage.PostImageResponseDto;
import com.example.market.dto.response.productimage.UpdateImageResponseDto;

import org.springframework.http.ResponseEntity;

public interface ProductImageService {

    //상품이미지 등록
    public ResponseEntity<PostImageResponseDto> postImage(PostImageRequestDto dto);

    //상품이미지 조회
    public ResponseEntity<GetImageResponseDto> getImage(GetImageRequestDto dto);

    //상품이미지 삭제
    public ResponseEntity<DeleteImageResponseDto> deleteImage(DeleteImageRequestDto dto);
    
    //상품이미지 수정
    public ResponseEntity<UpdateImageResponseDto> updateImage(UpdateImageRequestDto dto);
}
