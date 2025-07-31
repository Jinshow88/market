package com.example.market.service.implement;

import com.example.market.dto.request.productimage.DeleteImageRequestDto;
import com.example.market.dto.request.productimage.GetImageRequestDto;
import com.example.market.dto.request.productimage.PostImageRequestDto;
import com.example.market.dto.request.productimage.UpdateImageRequestDto;
import com.example.market.dto.response.productimage.DeleteImageResponseDto;
import com.example.market.dto.response.productimage.GetImageResponseDto;
import com.example.market.dto.response.productimage.PostImageResponseDto;
import com.example.market.dto.response.productimage.UpdateImageResponseDto;
import com.example.market.service.ProductImageService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {

        // 상품이미지 등록
        @Override
        @Transactional
        public ResponseEntity<PostImageResponseDto> postImage(PostImageRequestDto dto) {
                return null;
        }

        // 상품이미지 수정
        @Override
        @Transactional
        public ResponseEntity<UpdateImageResponseDto> updateImage(UpdateImageRequestDto dto) {
                return null;
        }

        // 상품이미지 삭제
        @Override
        @Transactional
        public ResponseEntity<DeleteImageResponseDto> deleteImage(DeleteImageRequestDto dto) {
                return null;
        }

        // 상품이미지 조회
        @Override
        @Transactional
        public ResponseEntity<GetImageResponseDto> getImage(GetImageRequestDto dto) {
                return null;
        }
}
