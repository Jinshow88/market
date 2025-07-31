package com.example.market.service.implement;

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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // 상품등록
    @Override
    @Transactional
    public ResponseEntity<PostProductResponseDto> postProduct(PostProductRequestDto dto) {
        return null;
    }

    // 상품삭제
    @Override
    @Transactional
    public ResponseEntity<DeleteProductResponseDto> deleteProduct(DeleteProductRequestDto dto) {
        return null;
    }

    // 상품수정
    @Override
    @Transactional
    public ResponseEntity<UpdateProductResponseDto> updateProduct(UpdateProductRequestDto dto) {
        return null;
    }

    // 상품조회
    @Override
    @Transactional
    public ResponseEntity<GetProductResponseDto> getProduct(GetProductRequestDto dto) {
        return null;
    }
}
