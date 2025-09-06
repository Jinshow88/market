package com.example.market.service;

import com.example.market.dto.request.product.DeleteProductRequestDto;
import com.example.market.dto.request.product.GetInfoRequestDto;
import com.example.market.dto.request.product.GetProductRequestDto;
import com.example.market.dto.request.product.PostProductRequestDto;
import com.example.market.dto.request.product.UpdateProductRequestDto;
import com.example.market.dto.response.product.DeleteProductResponseDto;
import com.example.market.dto.response.product.GetInfoResponseDto;
import com.example.market.dto.response.product.GetProductResponseDto;
import com.example.market.dto.response.product.PostProductResponseDto;
import com.example.market.dto.response.product.UpdateProductResponseDto;

import org.springframework.http.ResponseEntity;

public interface ProductService {

    //상품등록
    public ResponseEntity<PostProductResponseDto> postProduct(PostProductRequestDto dto);

    //상품삭제
    public ResponseEntity<DeleteProductResponseDto> deleteProduct(DeleteProductRequestDto dto);

    //상품수정
    public ResponseEntity<UpdateProductResponseDto> updateProduct(UpdateProductRequestDto dto);

    //상품조회
    public ResponseEntity<GetProductResponseDto> getProduct(GetProductRequestDto dto);

    //상품 상세조회
    public ResponseEntity<GetInfoResponseDto> getInfo(GetInfoRequestDto dto);
}
