package com.example.market.service;

import com.example.market.dto.request.alarm.DeleteAlarmRequestDto;
import com.example.market.dto.request.alarm.GetAlarmRequestDto;
import com.example.market.dto.request.alarm.PostAlarmRequestDto;
import com.example.market.dto.response.alarm.DeleteAlarmResponseDto;
import com.example.market.dto.response.alarm.GetAlarmResponseDto;
import com.example.market.dto.response.alarm.PostAlarmResponseDto;

import org.springframework.http.ResponseEntity;

public interface AlarmService {

    //알림 등록
    public ResponseEntity<PostAlarmResponseDto> postAlarm(PostAlarmRequestDto dto);

    //알림 조회?
    public ResponseEntity<GetAlarmResponseDto> getAlarm(GetAlarmRequestDto dto);
    
    //알림 해제
    public ResponseEntity<DeleteAlarmResponseDto> deleteAlarm(DeleteAlarmRequestDto dto);

}
