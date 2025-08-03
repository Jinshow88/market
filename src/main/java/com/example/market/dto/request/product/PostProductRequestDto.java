package com.example.market.dto.request.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostProductRequestDto {
    @JsonIgnore
    private long userId;
    @Schema(example = "5000", description = "가격")
    private long price;
    @Schema(example = "제목", description = "제목")
    private String title;
    @Schema(example = "전자제품", description = "카테고리")
    private long categoryId;
    @Schema(example = "상세내용", description = "상세내용")
    private String descripion;
    @Schema(example = "대구", description = "지역")
    private String location;
    @JsonIgnore
    @Schema(example = "1", description = "상태")
    private long productState;
    @JsonIgnore
    private long viewCnt;

    private String thumbNailImage;
}
