package com.example.market.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviwe")
@Tag(name = "리뷰")
public class ReviewController {
    // 리뷰등록
    // 리뷰수정
    // 리뷰 삭제
    // 리뷰 조회
}
