package com.example.market.controller;

import com.example.market.common.swagger.description.revicw.DeleteRevicwSwagger;
import com.example.market.common.swagger.description.revicw.GetRevicwSwagger;
import com.example.market.common.swagger.description.revicw.PostRevicwSwagger;
import com.example.market.common.swagger.description.revicw.UpdateRevicwSwagger;
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
@RequestMapping("/api/reviwe")
@Tag(name = "리뷰")
public class ReviewController {

    private final ReviewService service;
    // 리뷰등록
    @PostMapping
    @Operation(summary = "리뷰등록", description = PostRevicwSwagger.POST_REVICW_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = PostRevicwSwagger.POST_REVICW_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PostRevicwResponseDto.class)))
    public ResponseEntity<PostRevicwResponseDto> postRevicw(@RequestBody PostRevicwRequestDto dto){
        return service.postRevicw(dto);
    }

    // 리뷰수정
    @PatchMapping
    @Operation(summary = "리뷰수정", description = UpdateRevicwSwagger.UPDATE_REVICW_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = UpdateRevicwSwagger.UPDATE_REVICW_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UpdateRevicwResponseDto.class)))
    public ResponseEntity<UpdateRevicwResponseDto> updateRevicw(@RequestBody UpdateRevicwRequestDto dto){
        return service.updateRevicw(dto);
    }

    // 리뷰 삭제
    @DeleteMapping
    @Operation(summary = "리뷰삭제", description = DeleteRevicwSwagger.DELETE_REVICW_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = DeleteRevicwSwagger.DELETE_REVICW_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DeleteRevicwResponseDto.class)))
    public ResponseEntity<DeleteRevicwResponseDto> deleteRevicw(@ParameterObject DeleteRevicwRequestDto dto){
        return service.deleteRevicw(dto);
    }
    
    // 리뷰 조회
    @GetMapping
    @Operation(summary = "리뷰조회", description = GetRevicwSwagger.GET_REVICW_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = GetRevicwSwagger.GET_REVICW_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetRevicwResponseDto.class)))
    public ResponseEntity<GetRevicwResponseDto> getRevicw(@ParameterObject GetRevicwRequestDto dto){
        return service.getRevicw(dto);
    }

}
