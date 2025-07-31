package com.example.market.controller;

import com.example.market.dto.request.productimage.DeleteImageRequestDto;
import com.example.market.dto.request.productimage.GetImageRequestDto;
import com.example.market.dto.request.productimage.PostImageRequestDto;
import com.example.market.dto.request.productimage.UpdateImageRequestDto;
import com.example.market.dto.response.productimage.DeleteImageResponseDto;
import com.example.market.dto.response.productimage.GetImageResponseDto;
import com.example.market.dto.response.productimage.PostImageResponseDto;
import com.example.market.dto.response.productimage.UpdateImageResponseDto;
import com.example.market.service.ProductImageService;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/image")
@Tag(name = "상품이미지")
public class ProductimageController {

        private final ProductImageService service;

        // 상품이미지 등록
        @PostMapping
        public ResponseEntity<PostImageResponseDto> postImage(@RequestBody PostImageRequestDto dto){
                return service.postImage(dto);
        }

        // 상품이미지 삭제
        @DeleteMapping
        public ResponseEntity<DeleteImageResponseDto> deleteImage(@ParameterObject DeleteImageRequestDto dto){
                return service.deleteImage(dto);
        }

        // 상품이미지 수정
        @PatchMapping
        public ResponseEntity<UpdateImageResponseDto> updateImage(@RequestBody UpdateImageRequestDto dto){
                return service.updateImage(dto);
        }

        // 상품이미지 조회
        @GetMapping
        public ResponseEntity<GetImageResponseDto> getImage(@ParameterObject GetImageRequestDto dto){
                return service.getImage(dto);
        }
}
