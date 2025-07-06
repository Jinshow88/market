package com.example.market.service.implement;

import com.example.market.dto.request.user.LoginRequestDto;
import com.example.market.dto.response.user.LoginResponseDto;
import com.example.market.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    @Override
    @Transactional
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto dto){
        return null;
    }
    
}
