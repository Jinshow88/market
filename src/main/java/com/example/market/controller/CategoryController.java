package com.example.market.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
@Tag(name = "카테고리")
public class CategoryController {
    // 상품 목록 조회 : 카테고리, 최신순 정렬
    // 상품 등록 : 제목 내용 가격 이미지 업로드
    // 상품 상세보기 : 상품정보 판매자 정보
    // 상품 수정 삭제 - 본인만 가능
}
