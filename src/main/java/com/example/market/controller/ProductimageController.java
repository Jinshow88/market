package com.example.market.controller;

import com.example.market.common.swagger.description.productimage.DeleteImageSwagger;
import com.example.market.common.swagger.description.productimage.GetImageSwagger;
import com.example.market.common.swagger.description.productimage.PostImageSwagger;
import com.example.market.common.swagger.description.productimage.UpdateImageSwagger;
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
@RequestMapping("/api/image")
@Tag(name = "상품이미지")
public class ProductImageController {

        private final ProductImageService service;

        // 상품이미지 등록
        @PostMapping("/post-image")
        @Operation(summary = "이미지등록", description = PostImageSwagger.POST_PRODUCT_IMAGE_DESCRIPTION)
        @ApiResponse(responseCode = "200", description = PostImageSwagger.POST_PRODUCT_IMAGE_RESPONSE_ERROR_CODE,
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = PostImageResponseDto.class)))
        public ResponseEntity<PostImageResponseDto> postImage(@RequestBody PostImageRequestDto dto){
                return service.postImage(dto);
        }

        // 상품이미지 삭제
        @DeleteMapping("/delete-image")
        @Operation(summary = "아미지삭제", description = DeleteImageSwagger.DELETE_PRODUCT_IMAGE_DESCRIPTION)
        @ApiResponse(responseCode = "200", description = DeleteImageSwagger.DELETE_PRODUCT_IMAGE_RESPONSE_ERROR_CODE,
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = DeleteImageResponseDto.class)))
        public ResponseEntity<DeleteImageResponseDto> deleteImage(@ParameterObject DeleteImageRequestDto dto){
                return service.deleteImage(dto);
        }

        // 상품이미지 수정
        @PatchMapping("/retouch-image")
        @Operation(summary = "이미지 수정", description = UpdateImageSwagger.UPDATE_PRODUCT_IMAGE_DESCRIPTION)
        @ApiResponse(responseCode = "200", description = UpdateImageSwagger.UPDATE_PRODUCT_IMAGE_RESPONSE_ERROR_CODE,
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateImageResponseDto.class)))
        public ResponseEntity<UpdateImageResponseDto> updateImage(@RequestBody UpdateImageRequestDto dto){
                return service.updateImage(dto);
        }

        // 상품이미지 조회
        @GetMapping("/get-image")
        @Operation(summary = "이미지 조회", description = GetImageSwagger.GET_PRODUCT_IMAGE_DESCRIPTION)
        @ApiResponse(responseCode = "200", description = GetImageSwagger.GET_PRODUCT_IMAGE_RESPONSE_ERROR_CODE,
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetImageResponseDto.class)))
        public ResponseEntity<GetImageResponseDto> getImage(@ParameterObject GetImageRequestDto dto){
                return service.getImage(dto);
        }
}
