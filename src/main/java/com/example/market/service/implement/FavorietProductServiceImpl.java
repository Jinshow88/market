package com.example.market.service.implement;

import com.example.market.dto.request.favoriteproduct.DeleteFavoriteRequestDto;
import com.example.market.dto.request.favoriteproduct.GetFavoriteRequestDto;
import com.example.market.dto.request.favoriteproduct.PostFavoriteRequestDto;
import com.example.market.dto.response.favoriteproduct.DeleteFavoriteResponseDto;
import com.example.market.dto.response.favoriteproduct.GetFavoriteResponseDto;
import com.example.market.dto.response.favoriteproduct.PostFavoriteResponseDto;
import com.example.market.exception.CustomException;
import com.example.market.exception.errorcode.CommonErrorCode;
import com.example.market.security.AuthenticationFacade;
import com.example.market.service.FavoriteProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class FavorietProductServiceImpl implements FavoriteProductService {

    private final AuthenticationFacade authenticationFacade;

    // 관심상품등록
    @Override
    @Transactional
    public ResponseEntity<PostFavoriteResponseDto> postFaProd(PostFavoriteRequestDto dto) {
        try {
            dto.setUserId(authenticationFacade.getLoginUserId());
            if (dto.getUserId() <= 0) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonErrorCode.MNF);
        }

        long userId = dto.getUserId();
        long sellerId = dto.getSellerId();
        long productId = dto.getProductId();

        return PostFavoriteResponseDto.success();
    }

    // 관심상품해제
    @Override
    @Transactional
    public ResponseEntity<DeleteFavoriteResponseDto> deleteFaProd(DeleteFavoriteRequestDto dto) {
        return DeleteFavoriteResponseDto.success();
    }

    // 관심상품목록
    @Override
    @Transactional
    public ResponseEntity<GetFavoriteResponseDto> getFaProd(GetFavoriteRequestDto dto) {
        return GetFavoriteResponseDto.success();
    }
}
