package com.example.market.controller;

import com.example.market.common.swagger.description.revicw.PostRevicwSwagger;
import com.example.market.dto.request.revicw.DeleteRevicwRequestDto;
import com.example.market.dto.request.revicw.GetRevicwRequestDto;
import com.example.market.dto.request.revicw.PostRevicwRequestDto;
import com.example.market.dto.request.revicw.UpdateRevicwRequestDto;
import com.example.market.dto.response.revicw.DeleteRevicwResponseDto;
import com.example.market.dto.response.revicw.GetRevicwResponseDto;
import com.example.market.dto.response.revicw.PostRevicwResponseDto;
import com.example.market.dto.response.revicw.UpdateRevicwResponseDto;
import com.example.market.service.ReviewService;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviwe")
@Tag(name = "리뷰")
public class ReviewController {

    private final ReviewService service;
    // 리뷰등록
    @PostMapping
    @Operation(summary = "리뷰등록", description = PostRevicwSwagger.POST_REVICW_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = PostRevicwSwagger.POST_REVICW_RESPONSE_ERROR_CODE)
    public ResponseEntity<PostRevicwResponseDto> postRevicw(@RequestBody PostRevicwRequestDto dto){
        return service.postRevicw(dto);
    }

    // 리뷰수정
    @PutMapping
    public ResponseEntity<UpdateRevicwResponseDto> updateRevicw(@RequestPart UpdateRevicwRequestDto dto){
        return service.updateRevicw(dto);
    }

    // 리뷰 삭제
    @DeleteMapping
    public ResponseEntity<DeleteRevicwResponseDto> deleteRevicw(@ParameterObject DeleteRevicwRequestDto dto){
        return service.deleteRevicw(dto);
    }
    
    // 리뷰 조회
    @GetMapping
    public ResponseEntity<GetRevicwResponseDto> getRevicw(@RequestBody GetRevicwRequestDto dto){
        return service.getRevicw(dto);
    }

}
