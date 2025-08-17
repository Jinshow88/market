package com.example.market.dto.object.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class GetProductObjectDto {

    @Schema(example = "4", description = "판매자ID")
    private long sellerId;
    @Schema(example = "5", description = "카테고리ID")
    private long categoryId;

    private String sellerNickname; 
    @Schema(example = "5000", description = "가격")
    private long price;
    @Schema(example = "제목", description = "제목")
    private String title;
    @Schema(example = "5", description = "상세내용")
    private String descripion;
    @Schema(example = "대구", description = "지역")
    private String location;
    @Schema(example = "1", description = "상태") // 삭제,예약중,판매중,판매완료
    private long productState;
    @Schema(example = "5", description = "대표 이미지")
    private String thumbNailImage;
    @Schema(example = "5", description = "조회 수")
    private long viewCnt;
    
    // public void setSellerNickname(String sellerNickname) {
    //     this.sellerNickname = sellerNickname;
    // }


}

// public interface GetProductObjectDto {

//     @Schema(example = "4", description = "판매자ID")
//     long getsellerId();

//     @Schema(example = "5", description = "카테고리ID")
//     long getcategoryId();

//     @Schema(example = "5000", description = "가격")
//     long getprice();

//     @Schema(example = "제목", description = "제목")
//     String gettitle();

//     @Schema(example = "5", description = "상세내용")
//     String getdescripion();

//     @Schema(example = "대구", description = "지역")
//     String getlocation();

//     @Schema(example = "1", description = "상태") // 삭제,예약중,판매중,판매완료
//     long getproductState();

//     @Schema(example = "5", description = "대표 이미지")
//     String getthumbNailImage();

//     @Schema(example = "5", description = "조회 수")
//     long getviewCnt();
// }
