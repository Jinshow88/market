package com.example.market.service.implement;

import com.example.market.common.security.AppProperties;
import com.example.market.common.security.CookieUtils;
import com.example.market.common.swagger.Role;
import com.example.market.dto.request.auth.DeleteUserRequestDto;
import com.example.market.dto.request.auth.SignInRequestDto;
import com.example.market.dto.request.auth.SignOutRequestDto;
import com.example.market.dto.request.auth.SignUpRequestDto;
import com.example.market.dto.response.auth.DeleteUserResponseDto;
import com.example.market.dto.response.auth.SignInResponseDto;
import com.example.market.dto.response.auth.SignOutResponseDto;
import com.example.market.dto.response.auth.SignUpResponseDto;
import com.example.market.entity.Users;
import com.example.market.exception.CustomException;
import com.example.market.exception.errorcode.AuthErrorCode;
import com.example.market.exception.errorcode.CommonErrorCode;
import com.example.market.jwt.JwtTokenProvider;
import com.example.market.repository.UserRepository;
import com.example.market.security.MyUser;
import com.example.market.service.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AppProperties appProperties;
    private final CookieUtils cookieUtils;

    // 회원가입
    @Override
    @Transactional
    public ResponseEntity<SignUpResponseDto> signUp(SignUpRequestDto dto) {

        try {
            String userName = dto.getUserName();
            String userNic = dto.getUserNic();
            String userEmail = dto.getUserEmail();
            String userPw = dto.getUserPw();
            String userPhone = dto.getUserPhone();
            String userAddress = dto.getUserAddress();
            String userRole = dto.getUserRole();

            // Boolean isExist = repository.existsByUserName(userName);

            if (repository.existsByUserName(userName)) {
                throw new CustomException(AuthErrorCode.EUI);
            }

            Users users = new Users();
            
            users.setUserName(userName);
            users.setUserNic(userNic);
            users.setUserEmail(userEmail);
            users.setUserPw(bCryptPasswordEncoder.encode(userPw));
            users.setUserPhone(userPhone);
            users.setUserAddress(userAddress);
            users.setRole(Role.ROLE_USER);

            repository.save(users);

            return SignUpResponseDto.success();
        } catch (CustomException e) {
            e.printStackTrace();
            throw new CustomException(e.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonErrorCode.DBE);
        }
    }

    // 로그인
    @Override
    @Transactional
    public ResponseEntity<SignInResponseDto> signIn(HttpServletResponse res, SignInRequestDto dto) {

        String accessToken = null;
        String refreshToken = null;
        try {
            String userEmail = dto.getUserEmail();
            String userPw = dto.getUserPw();

            Users users = repository.findByUserEmail(userEmail);
            if (users == null) {
                throw new CustomException(AuthErrorCode.NEU);
            }
            if (!bCryptPasswordEncoder.matches(userPw, users.getUserPw())) {
                throw new CustomException(AuthErrorCode.PW);
            }

            MyUser myUser = MyUser.builder()
                    .userId(users.getUserId())
                    .role(users.getRole())
                    .build();

            accessToken = jwtTokenProvider.generateAccessToken(myUser);
            refreshToken = jwtTokenProvider.generateRefreshToken(myUser);

            
            int refreshTokenMaxAge = appProperties.getJwt().getRefreshTokenCookieMaxAge();
            cookieUtils.deleteCookie(res, "refresh-token");
            cookieUtils.setCookie(res, "refresh-token", refreshToken, refreshTokenMaxAge);
            
            return SignInResponseDto.success(accessToken);
        } catch (CustomException e) {
            e.printStackTrace();
            throw new CustomException(e.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonErrorCode.DBE);
        }

    }

    // 로그아웃
    @Override
    @Transactional
    public ResponseEntity<SignOutResponseDto> signOut(SignOutRequestDto dto) {
        return null;
    }

    // 회원탈퇴
    @Override
    @Transactional
    public ResponseEntity<DeleteUserResponseDto> deleteUser(DeleteUserRequestDto dto) {
        return null;
    }
}
