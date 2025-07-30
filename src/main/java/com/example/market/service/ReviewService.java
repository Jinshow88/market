package com.example.market.service;

import com.example.market.dto.request.revicw.DeleteRevicwRequestDto;
import com.example.market.dto.request.revicw.GetRevicwRequestDto;
import com.example.market.dto.request.revicw.PostRevicwRequestDto;
import com.example.market.dto.request.revicw.UpdateRevicwRequestDto;
import com.example.market.dto.response.revicw.DeleteRevicwResponseDto;
import com.example.market.dto.response.revicw.GetRevicwResponseDto;
import com.example.market.dto.response.revicw.PostRevicwResponseDto;
import com.example.market.dto.response.revicw.UpdateRevicwResponseDto;

import org.springframework.http.ResponseEntity;

public interface ReviewService {
    
    //리뷰등록
    ResponseEntity<PostRevicwResponseDto> postRevicw(PostRevicwRequestDto dto);

    //리뷰수정
    ResponseEntity<UpdateRevicwResponseDto> updateRevicw(UpdateRevicwRequestDto dto);

    //리뷰 삭제
    ResponseEntity<DeleteRevicwResponseDto> deleteRevicw(DeleteRevicwRequestDto dto);
        
    //리뷰 조회
    ResponseEntity<GetRevicwResponseDto> getRevicw(GetRevicwRequestDto dto);
}
