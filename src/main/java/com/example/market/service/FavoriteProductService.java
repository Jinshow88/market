package com.example.market.service;

import com.example.market.dto.request.favoriteproduct.DeleteFavoriteRequestDto;
import com.example.market.dto.request.favoriteproduct.GetFavoriteRequestDto;
import com.example.market.dto.request.favoriteproduct.PostFavoriteRequestDto;
import com.example.market.dto.response.favoriteproduct.DeleteFavoriteResponseDto;
import com.example.market.dto.response.favoriteproduct.GetFavoriteResponseDto;
import com.example.market.dto.response.favoriteproduct.PostFavoriteResponseDto;

import org.springframework.http.ResponseEntity;

public interface FavoriteProductService {

    //관심상품등록
    ResponseEntity<PostFavoriteResponseDto> postFaProd(PostFavoriteRequestDto dto);
    //관심상품해제
    ResponseEntity<DeleteFavoriteResponseDto> deleteFaProd(DeleteFavoriteRequestDto dto);
    //관심상품목록
    ResponseEntity<GetFavoriteResponseDto> getFaProd(GetFavoriteRequestDto dto);


}
