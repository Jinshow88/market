package com.example.market.controller;

import com.example.market.dto.request.favoriteproduct.DeleteFavoriteRequestDto;
import com.example.market.dto.request.favoriteproduct.GetFavoriteRequestDto;
import com.example.market.dto.request.favoriteproduct.PostFavoriteRequestDto;
import com.example.market.dto.response.favoriteproduct.DeleteFavoriteResponseDto;
import com.example.market.dto.response.favoriteproduct.GetFavoriteResponseDto;
import com.example.market.dto.response.favoriteproduct.PostFavoriteResponseDto;
import com.example.market.service.FavoriteProductService;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/favorite")
@Tag(name = "관심상품")
public class FavoriteProductController {
    
    private final FavoriteProductService service;
    // 관심상품등록
    @PostMapping
    public ResponseEntity<PostFavoriteResponseDto> postFaProd(@RequestBody PostFavoriteRequestDto dto){
        return service.postFaProd(dto);
    }

    // 관심상품해제
    @DeleteMapping
    public ResponseEntity<DeleteFavoriteResponseDto> deleteFaProd(@ParameterObject DeleteFavoriteRequestDto dto){
        return service.deleteFaProd(dto);
    }

    // 목록보기
    @GetMapping
    public ResponseEntity<GetFavoriteResponseDto> getFaProd(@ParameterObject GetFavoriteRequestDto dto){
        return service.getFaProd(dto);
    }
}
