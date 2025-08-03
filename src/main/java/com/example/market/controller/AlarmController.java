package com.example.market.controller;

import com.example.market.common.swagger.description.alarm.DeleteAlarmSwagger;
import com.example.market.common.swagger.description.alarm.GetAlarmSwagger;
import com.example.market.common.swagger.description.alarm.PostAlarmSwagger;
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
@RequestMapping("/api/alarm")
@Tag(name = "알림")
public class AlarmController {

    private final AlarmService service;

    // 알림등록
    @PostMapping("/post-alarm")
    @Operation(summary = "알림등록", description = PostAlarmSwagger.POST_ALARM_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = PostAlarmSwagger.POST_ALARM_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PostAlarmResponseDto.class)))
    public ResponseEntity<PostAlarmResponseDto> postAlarm(@RequestBody PostAlarmRequestDto dto){
        return service.postAlarm(dto);
    }

    // 알림삭제
    @DeleteMapping("/delete-alarm")
    @Operation(summary = "알림해제", description = DeleteAlarmSwagger.DELETE_ALARM_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = DeleteAlarmSwagger.DELETE_ALARM_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DeleteAlarmResponseDto.class)))
    public ResponseEntity<DeleteAlarmResponseDto> deleteAlarm(@ParameterObject DeleteAlarmRequestDto dto){
        return service.deleteAlarm(dto);
    }
    // 알림조회
    @GetMapping("/get-alarm")
    @Operation(summary = "알림조회", description = GetAlarmSwagger.GET_ALARM_DESCRIPTION)
    @ApiResponse(responseCode = "200", description = GetAlarmSwagger.GET_ALARM_RESPONSE_ERROR_CODE,
    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetAlarmResponseDto.class)))
    public ResponseEntity<GetAlarmResponseDto> getAlarm(@ParameterObject GetAlarmRequestDto dto){
        return service.getAlarm(dto);
    }
}
