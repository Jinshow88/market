package com.example.market.controller;

import com.example.market.common.swagger.description.product.DeleteProductSwagger;
import com.example.market.common.swagger.description.product.GetProductSwagger;
import com.example.market.common.swagger.description.product.PostProductSwagger;
import com.example.market.common.swagger.description.product.UpdateProductSwagger;
import com.example.market.dto.request.product.DeleteProductRequestDto;
import com.example.market.dto.request.product.GetProductRequestDto;
import com.example.market.dto.request.product.PostProductRequestDto;
import com.example.market.dto.request.product.UpdateProductRequestDto;
import com.example.market.dto.response.product.DeleteProductResponseDto;
import com.example.market.dto.response.product.GetProductResponseDto;
import com.example.market.dto.response.product.PostProductResponseDto;
import com.example.market.dto.response.product.UpdateProductResponseDto;
import com.example.market.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/api/product")
@Tag(name = "상품")
public class ProductController {

    private final ProductService service;

    // 상품등록
    @PostMapping("/post-product")
    @Operation(summary = "상품 등록", description = PostProductSwagger.POST_PRODUCT_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = PostProductSwagger.POST_PRODUCT_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PostProductResponseDto.class)))
    public ResponseEntity<PostProductResponseDto> postProduct(PostProductRequestDto dto){
        return service.postProduct(dto);
    }

    // 상품삭제
    @DeleteMapping("/delete-product")
    @Operation(summary = "상품 삭제", description = DeleteProductSwagger.DELETE_PRODUCT_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = DeleteProductSwagger.DELETE_PRODUCT_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DeleteProductResponseDto.class)))
    public ResponseEntity<DeleteProductResponseDto> deleteProduct(DeleteProductRequestDto dto){
        return service.deleteProduct(dto);
    }

    // 상품수정
    @PatchMapping("/patch-product")
    @Operation(summary = "상품 수정", description = UpdateProductSwagger.UPDATE_PRODUCT_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = UpdateProductSwagger.UPDATE_PRODUCT_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateProductResponseDto.class)))
    public ResponseEntity<UpdateProductResponseDto> updateProduct(UpdateProductRequestDto dto){

        return service.updateProduct(dto);
    }
    // 상품조회
    @GetMapping("/get-product")
    @Operation(summary = "상품 조회", description = GetProductSwagger.GET_PRODUCT_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = GetProductSwagger.GET_PRODUCT_RESPONSE_ERROR_CODE ,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetProductResponseDto.class)))
    public ResponseEntity<GetProductResponseDto> getProduct(GetProductRequestDto dto){
        return service.getProduct(dto);
    }
}
