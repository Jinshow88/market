package com.example.market.service.implement;

import com.example.market.dto.object.revicw.PostRevicwObjectDto;
import com.example.market.dto.request.revicw.DeleteRevicwRequestDto;
import com.example.market.dto.request.revicw.GetRevicwRequestDto;
import com.example.market.dto.request.revicw.PostRevicwRequestDto;
import com.example.market.dto.request.revicw.UpdateRevicwRequestDto;
import com.example.market.dto.response.revicw.DeleteRevicwResponseDto;
import com.example.market.dto.response.revicw.GetRevicwResponseDto;
import com.example.market.dto.response.revicw.PostRevicwResponseDto;
import com.example.market.dto.response.revicw.UpdateRevicwResponseDto;
import com.example.market.entity.Product;
import com.example.market.entity.Review;
import com.example.market.entity.Users;
import com.example.market.exception.CustomException;
import com.example.market.exception.errorcode.CommonErrorCode;
import com.example.market.exception.errorcode.ProductErrorCode;
import com.example.market.repository.ProductRepository;
import com.example.market.repository.ReviewRepository;
import com.example.market.repository.UserRepository;
import com.example.market.security.AuthenticationFacade;
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

    private final AuthenticationFacade authenticationFacade;
    private final ReviewRepository repository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    // 리뷰등록
    @Override
    @Transactional
    public ResponseEntity<PostRevicwResponseDto> postRevicw(PostRevicwRequestDto dto) {
        Long loginUserId = authenticationFacade.getLoginUserId();
        PostRevicwObjectDto postRevicwObjectDto = null;
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
        long productId = dto.getProductId();
        Users loginUser = userRepository.getReferenceById(loginUserId);

        boolean existsById = repository.existsById(productId);

        if (loginUserId == userId) {
            if (existsById) {
                Product product = productRepository.findById(productId)
                        .orElseThrow(() -> new CustomException(ProductErrorCode.NP));

                Review review = new Review();

                review.setProductId(product);
                review.setSellerId(loginUser);
                review.setContent(dto.getContent());
                review.setSaleReviewType(1);

                repository.save(review);
            }
        } else {

            if (existsById) {
                Product product = productRepository.findById(productId)
                        .orElseThrow(() -> new CustomException(ProductErrorCode.NP));

                Review review = new Review();

                review.setProductId(product);
                review.setBuyerId(loginUser);
                review.setContent(dto.getContent());
                review.setSaleReviewType(1);

                repository.save(review);
            }
        }

        return PostRevicwResponseDto.success(postRevicwObjectDto);
    }

    // 리뷰수정
    @Override
    @Transactional
    public ResponseEntity<UpdateRevicwResponseDto> updateRevicw(UpdateRevicwRequestDto dto) {
        return UpdateRevicwResponseDto.success();
    }

    // 리뷰 삭제
    @Override
    @Transactional
    public ResponseEntity<DeleteRevicwResponseDto> deleteRevicw(DeleteRevicwRequestDto dto) {
        return DeleteRevicwResponseDto.success();
    }

    // 리뷰 조회
    @Override
    @Transactional
    public ResponseEntity<GetRevicwResponseDto> getRevicw(GetRevicwRequestDto dto) {
        return GetRevicwResponseDto.success();
    }
}
