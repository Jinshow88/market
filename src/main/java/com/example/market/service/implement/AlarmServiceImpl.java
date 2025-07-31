package com.example.market.service.implement;

import com.example.market.dto.request.alarm.DeleteAlarmRequestDto;
import com.example.market.dto.request.alarm.GetAlarmRequestDto;
import com.example.market.dto.request.alarm.PostAlarmRequestDto;
import com.example.market.dto.response.alarm.DeleteAlarmResponseDto;
import com.example.market.dto.response.alarm.GetAlarmResponseDto;
import com.example.market.dto.response.alarm.PostAlarmResponseDto;
import com.example.market.service.AlarmService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlarmServiceImpl implements AlarmService {

    // 알림등록
    @Override
    @Transactional
    public ResponseEntity<PostAlarmResponseDto> postAlarm(PostAlarmRequestDto dto) {
        return null;
    }

    // 알림조회
    @Override
    @Transactional
    public ResponseEntity<GetAlarmResponseDto> getAlarm(GetAlarmRequestDto dto) {
        return null;
    }

    // 알림해제
    @Override
    @Transactional
    public ResponseEntity<DeleteAlarmResponseDto> deleteAlarm(DeleteAlarmRequestDto dto) {
        return null;
    }
}
