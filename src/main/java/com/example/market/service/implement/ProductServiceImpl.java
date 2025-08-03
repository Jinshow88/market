package com.example.market.service.implement;

import com.example.market.dto.request.product.DeleteProductRequestDto;
import com.example.market.dto.request.product.GetProductRequestDto;
import com.example.market.dto.request.product.PostProductRequestDto;
import com.example.market.dto.request.product.UpdateProductRequestDto;
import com.example.market.dto.response.product.DeleteProductResponseDto;
import com.example.market.dto.response.product.GetProductResponseDto;
import com.example.market.dto.response.product.PostProductResponseDto;
import com.example.market.dto.response.product.UpdateProductResponseDto;
import com.example.market.entity.Product;
import com.example.market.exception.CustomException;
import com.example.market.exception.errorcode.CommonErrorCode;
import com.example.market.repository.ProductRepository;
import com.example.market.security.AuthenticationFacade;
import com.example.market.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final AuthenticationFacade authenticationFacade;

    // 상품등록
    @Override
    @Transactional
    public ResponseEntity<PostProductResponseDto> postProduct(PostProductRequestDto dto) {

        try {
            dto.setUserId(authenticationFacade.getLoginUserId());
            if (dto.getUserId() <= 0) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonErrorCode.MNF);
        }

        try {
            long price = dto.getPrice();
            String title = dto.getTitle();
            long categoryId = dto.getCategoryId();
            String descripion = dto.getDescripion();
            String location = dto.getLocation();
            // long productState = dto.getProductState();
            String thumbNailImage = dto.getThumbNailImage();

            Product product = new Product();

            product.setPrice(price);
            product.setTitle(title);
            product.setCategoryId(categoryId);
            product.setLocation(location);
            product.setDescripion(descripion);
            product.setProductState(1);
            product.setThumbNailImage(thumbNailImage);

            repository.save(product);
            return PostProductResponseDto.success();

        } catch (CustomException e) {
            e.printStackTrace();
            throw new CustomException(e.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonErrorCode.DBE);
        }
    }

    // 상품삭제
    @Override
    @Transactional
    public ResponseEntity<DeleteProductResponseDto> deleteProduct(DeleteProductRequestDto dto) {
        return null;
    }

    // 상품수정
    @Override
    @Transactional
    public ResponseEntity<UpdateProductResponseDto> updateProduct(UpdateProductRequestDto dto) {
        return null;
    }

    // 상품조회
    @Override
    @Transactional
    public ResponseEntity<GetProductResponseDto> getProduct(GetProductRequestDto dto) {
        return null;
    }
}
