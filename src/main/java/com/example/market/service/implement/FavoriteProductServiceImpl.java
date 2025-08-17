package com.example.market.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.market.dto.object.favoriteproduct.GetFavoriteSellerDto;
import com.example.market.dto.request.favoriteproduct.DeleteFavoriteRequestDto;
import com.example.market.dto.request.favoriteproduct.GetFavoriteRequestDto;
import com.example.market.dto.request.favoriteproduct.PostFavoriteRequestDto;
import com.example.market.dto.response.favoriteproduct.DeleteFavoriteResponseDto;
import com.example.market.dto.response.favoriteproduct.GetFavoriteResponseDto;
import com.example.market.dto.response.favoriteproduct.PostFavoriteResponseDto;
import com.example.market.entity.FavoriteProduct;
import com.example.market.entity.Product;
import com.example.market.entity.Users;
import com.example.market.exception.CustomException;
import com.example.market.exception.errorcode.CommonErrorCode;
import com.example.market.exception.errorcode.FavoriteProductErrorCode;
import com.example.market.exception.errorcode.ProductErrorCode;
import com.example.market.exception.errorcode.UserErrorCode;
import com.example.market.repository.FavoriteProductRepository;
import com.example.market.repository.ProductRepository;
import com.example.market.repository.UserRepository;
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
public class FavoriteProductServiceImpl implements FavoriteProductService {

    private final AuthenticationFacade authenticationFacade;
    private final FavoriteProductRepository repository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

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

        long productId = dto.getProductId();

        boolean productExists = productRepository.existsById(productId);

        if (productExists) {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new CustomException(ProductErrorCode.NP));
            Users seller = Optional.ofNullable(product.getSellerId())
                    .orElseThrow(() -> new CustomException(UserErrorCode.SNT));

            FavoriteProduct favorite = new FavoriteProduct();

            favorite.setProductId(product);
            favorite.setSellerId(seller);
            favorite.setIsValid(1);
            repository.save(favorite);
        } else {
            throw new CustomException(FavoriteProductErrorCode.NP);
        }

        return PostFavoriteResponseDto.success();
    }

    // 관심상품해제
    @Override
    @Transactional
    public ResponseEntity<DeleteFavoriteResponseDto> deleteFaProd(DeleteFavoriteRequestDto dto) {

        try {
            dto.setUserId(authenticationFacade.getLoginUserId());
            if (dto.getUserId() <= 0) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonErrorCode.MNF);
        }

        // userId 가져오기
        long userId = dto.getUserId();

        // userId로 Users 엔티티 조회
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(UserErrorCode.UNT));

        // 닉네임 가져오기
        String userNic = user.getUserNic();
        long favoriteId = dto.getFavoriteId();

        FavoriteProduct favoriteProduct = repository.findById(favoriteId)
                .orElseThrow(() -> new CustomException(FavoriteProductErrorCode.NP));
        if (favoriteProduct.getIsValid() == 1) {
            favoriteProduct.setIsValid(0);
            repository.save(favoriteProduct);
        } else if (favoriteProduct.getIsValid() == 0) {
            favoriteProduct.setIsValid(1);
            repository.save(favoriteProduct);
        }

        long isValid = favoriteProduct.getIsValid();
        return DeleteFavoriteResponseDto.success(userNic, isValid);
    }

    // 관심상품목록
    @Override
    @Transactional
    public ResponseEntity<GetFavoriteResponseDto> getFaProd(GetFavoriteRequestDto dto) {

        try {
            dto.setUserId(authenticationFacade.getLoginUserId());
            if (dto.getUserId() <= 0) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonErrorCode.MNF);
        }
        long productId = dto.getProductId();

        Users sellerId = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new CustomException(UserErrorCode.UNT));
        // Product product = productRepository.findById(productId)
        // .orElseThrow(() -> new CustomException(FavoriteProductErrorCode.NP));

        // List<FavoriteProduct> fav = repository.findById(dto.getFavoriteId());
        //         .orElseThrow(() -> new CustomException(FavoriteProductErrorCode.NP));

        // Users seller = Optional.ofNullable(product.getSellerId())
        // .orElseThrow(() -> new CustomException(UserErrorCode.SNT));
        List<Product> products = productRepository.findAllBySellerId(sellerId);
        List<GetFavoriteSellerDto> getFavoriteSellerDto = new ArrayList<>();

        for (Product product : products) {
            GetFavoriteSellerDto productDto = new GetFavoriteSellerDto();
            productDto.setTitle(product.getTitle());
            productDto.setSellerNic(product.getSellerId().getUserNic());
            // productDto.setIsValid(fav.getIsValid()); // 상품별 유효성 여부에 맞게 수정
            productDto.setSellerId(product.getSellerId().getUserId());

            getFavoriteSellerDto.add(productDto);
        }

        return GetFavoriteResponseDto.success(getFavoriteSellerDto);
    }
}
