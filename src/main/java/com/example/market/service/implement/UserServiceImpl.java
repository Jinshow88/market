package com.example.market.service.implement;

import com.example.market.dto.request.user.SignUpRequestDto;
import com.example.market.dto.response.user.SignUpResponseDto;
// import com.example.market.repository.UserRepository;
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

    // private final UserRepository userRepository;

    @Override
    @Transactional
    public ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto dto){
        return null ;
    }
    
}
