package com.example.market.service.implement;

import com.example.market.dto.request.revicw.DeleteRevicwRequestDto;
import com.example.market.dto.request.revicw.GetRevicwRequestDto;
import com.example.market.dto.request.revicw.PostRevicwRequestDto;
import com.example.market.dto.request.revicw.UpdateRevicwRequestDto;
import com.example.market.dto.response.revicw.DeleteRevicwResponseDto;
import com.example.market.dto.response.revicw.GetRevicwResponseDto;
import com.example.market.dto.response.revicw.PostRevicwResponseDto;
import com.example.market.dto.response.revicw.UpdateRevicwResponseDto;
import com.example.market.service.ReviewService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    
    //리뷰등록
    @Override
    @Transactional
    public ResponseEntity<PostRevicwResponseDto> postRevicw(PostRevicwRequestDto dto){
        return null;
    }

    //리뷰수정
    @Override
    @Transactional
    public ResponseEntity<UpdateRevicwResponseDto> updateRevicw(UpdateRevicwRequestDto dto) {
        return null;
    }
    
    //리뷰 삭제
    @Override
    @Transactional
    public ResponseEntity<DeleteRevicwResponseDto> deleteRevicw(DeleteRevicwRequestDto dto){
        return null;
    }
    //리뷰 조회
    @Override
    @Transactional
    public ResponseEntity<GetRevicwResponseDto> getRevicw(GetRevicwRequestDto dto){
        return null;
    }
}
