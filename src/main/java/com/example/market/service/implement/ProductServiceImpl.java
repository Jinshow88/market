package com.example.market.service.implement;

import java.util.ArrayList;
import java.util.List;

import com.example.market.dto.object.product.GetProductObjectDto;
import com.example.market.dto.request.product.DeleteProductRequestDto;
import com.example.market.dto.request.product.GetInfoRequestDto;
import com.example.market.dto.request.product.GetProductRequestDto;
import com.example.market.dto.request.product.PostProductRequestDto;
import com.example.market.dto.request.product.UpdateProductRequestDto;
import com.example.market.dto.response.product.DeleteProductResponseDto;
import com.example.market.dto.response.product.GetInfoResponseDto;
import com.example.market.dto.response.product.GetProductResponseDto;
import com.example.market.dto.response.product.PostProductResponseDto;
import com.example.market.dto.response.product.UpdateProductResponseDto;
import com.example.market.entity.Product;
import com.example.market.entity.Users;
import com.example.market.exception.CustomException;
import com.example.market.exception.errorcode.CommonErrorCode;
import com.example.market.exception.errorcode.ProductErrorCode;
import com.example.market.repository.ProductRepository;
import com.example.market.repository.UserRepository;
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
    private final UserRepository userRepository;

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
            long sellerId = dto.getUserId();

            Users seller = userRepository.findById(sellerId)
                    .orElseThrow(() -> new CustomException(CommonErrorCode.MNF));

            Product product = new Product();

            product.setPrice(price);
            product.setTitle(title);
            product.setCategoryId(categoryId);
            product.setLocation(location);
            product.setDescripion(descripion);
            product.setProductState(1);
            product.setThumbNailImage(thumbNailImage);
            // product.setSellerId(seller);
            product.setSellerId(seller);

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
            long productId = dto.getProductId();
            long sellerId = dto.getUserId();

            Product product = repository.findById(productId)
                    .orElseThrow(() -> new CustomException(CommonErrorCode.DBE));

            if (product.getSellerId().getUserId() != sellerId) {
                throw new CustomException(CommonErrorCode.DBE);
            }

            repository.deleteById(productId);
            return DeleteProductResponseDto.success();
        } catch (CustomException e) {
            e.printStackTrace();
            throw new CustomException(e.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonErrorCode.DBE);
        }
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

        List<GetProductObjectDto> getProductObjectDtos = new ArrayList<>();

        try {
            dto.setUserId(authenticationFacade.getLoginUserId());
            if (dto.getUserId() <= 0) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonErrorCode.MNF);
        }

        String title = dto.getTitle();
        List<Product> productList = repository.findAllByTitle(title);

        try {
            if (productList.isEmpty()) {
                throw new CustomException(ProductErrorCode.NP); // 상품 없음
            }

            for (Product product : productList) {
                GetProductObjectDto productDto = new GetProductObjectDto();
                productDto.setSellerId(product.getSellerId().getUserId());
                productDto.setSellerNickname(product.getSellerId().getUserNic());
                productDto.setCategoryId(product.getCategoryId());
                productDto.setPrice(product.getPrice());
                productDto.setTitle(product.getTitle());
                // productDto.setDescription(product.getDescription());
                productDto.setLocation(product.getLocation());
                productDto.setProductState(product.getProductState());
                productDto.setThumbNailImage(product.getThumbNailImage());
                productDto.setViewCnt(product.getViewCnt());

                getProductObjectDtos.add(productDto);
            }

            return GetProductResponseDto.success(getProductObjectDtos);
        } catch (CustomException e) {
            e.printStackTrace();
            throw new CustomException(e.getErrorCode());
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonErrorCode.DBE);
        }
    }


    //상품상세조회
    @Override
    @Transactional
    public ResponseEntity<GetInfoResponseDto> getInfo(GetInfoRequestDto dto){
        return GetInfoResponseDto.success();
    }
}
