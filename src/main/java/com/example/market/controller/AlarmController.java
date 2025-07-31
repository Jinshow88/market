package com.example.market.controller;

import com.example.market.dto.request.alarm.DeleteAlarmRequestDto;
import com.example.market.dto.request.alarm.GetAlarmRequestDto;
import com.example.market.dto.request.alarm.PostAlarmRequestDto;
import com.example.market.dto.response.alarm.DeleteAlarmResponseDto;
import com.example.market.dto.response.alarm.GetAlarmResponseDto;
import com.example.market.dto.response.alarm.PostAlarmResponseDto;
import com.example.market.service.AlarmService;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/alarm")
@Tag(name = "알림")
public class AlarmController {

    private final AlarmService service;

    // 알림등록
    @PostMapping
    public ResponseEntity<PostAlarmResponseDto> postAlarm(@RequestBody PostAlarmRequestDto dto){
        return service.postAlarm(dto);
    }

    // 알림삭제
    @DeleteMapping
    public ResponseEntity<DeleteAlarmResponseDto> deleteAlarm(@ParameterObject DeleteAlarmRequestDto dto){
        return service.deleteAlarm(dto);
    }
    // 알림조회
    @GetMapping
    public ResponseEntity<GetAlarmResponseDto> getAlarm(@ParameterObject GetAlarmRequestDto dto){
        return service.getAlarm(dto);
    }
}
