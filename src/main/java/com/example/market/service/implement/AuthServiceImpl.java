package com.example.market.service.implement;

import com.example.market.dto.request.auth.SignInRequestDto;
import com.example.market.dto.request.auth.SignOutRequestDto;
import com.example.market.dto.request.auth.SignUpRequestDto;
import com.example.market.dto.response.auth.SignInResponseDto;
import com.example.market.dto.response.auth.SignOutResponseDto;
import com.example.market.dto.response.auth.SignUpResponseDto;
import com.example.market.entity.Users;
import com.example.market.repository.UserRepository;
import com.example.market.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    @Override
    @Transactional
    public ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto dto) {
        Users users = Users.builder()
                .userName(dto.getUserName())
                .userNic(dto.getUserNic())
                .userEmail(dto.getUserEmail())
                .userPw(passwordEncoder.encode(dto.getUserPw()))
                .userPhone(dto.getUserPhone())
                .userAddress(dto.getUserAddress())
                .build();

        Users saveUser = userRepository.save(users);
        return SignUpResponseDto.success(saveUser.getUserId());
    }

    // 로그인
    @Override
    @Transactional
    public ResponseEntity<SignInResponseDto> signIn(SignInRequestDto dto) {
        return null;
    }

    // 로그아웃
    @Override
    @Transactional
    public ResponseEntity<SignOutResponseDto> signOut(SignOutRequestDto dto) {
        return null;
    }

}
