package com.example.market.controller;

import com.example.market.common.swagger.description.auth.DeleteUserSwagger;
import com.example.market.common.swagger.description.favoriteproduct.GetFavoriteSwagger;
import com.example.market.common.swagger.description.favoriteproduct.PostFavoriteSwagger;
import com.example.market.dto.request.favoriteproduct.DeleteFavoriteRequestDto;
import com.example.market.dto.request.favoriteproduct.GetFavoriteRequestDto;
import com.example.market.dto.request.favoriteproduct.PostFavoriteRequestDto;
import com.example.market.dto.response.favoriteproduct.DeleteFavoriteResponseDto;
import com.example.market.dto.response.favoriteproduct.GetFavoriteResponseDto;
import com.example.market.dto.response.favoriteproduct.PostFavoriteResponseDto;
import com.example.market.service.FavoriteProductService;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @PostMapping("/PostProduct")
    @Operation(summary = "관심상품등록", description = PostFavoriteSwagger.POST_FAVORITE_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = PostFavoriteSwagger.POST_FAVORITE_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PostFavoriteResponseDto.class)))
    public ResponseEntity<PostFavoriteResponseDto> postFaProd(@RequestBody PostFavoriteRequestDto dto){
        return service.postFaProd(dto);
    }

    // 관심상품해제
    @PatchMapping("/PatchProduct")
    @Operation(summary = "관심상품해제", description = DeleteUserSwagger.DELETE_USER_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = DeleteUserSwagger.DELETE_USER_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation =  DeleteFavoriteResponseDto.class)))
    public ResponseEntity<DeleteFavoriteResponseDto> deleteFaProd(@RequestBody DeleteFavoriteRequestDto dto){
        return service.deleteFaProd(dto);
    }

    // 목록보기
    @GetMapping("/GetProduct")
    @Operation(summary = "목록보기", description = GetFavoriteSwagger.GET_FAVORITE_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = GetFavoriteSwagger.GET_FAVORITE_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetFavoriteResponseDto.class)))
    public ResponseEntity<GetFavoriteResponseDto> getFaProd(@ModelAttribute @ParameterObject GetFavoriteRequestDto dto){
        return service.getFaProd(dto);
    }
}
