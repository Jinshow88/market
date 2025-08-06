package com.example.market.entity;

import java.time.LocalDateTime;

import com.example.market.entity.common.UpdatedAt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product")
public class Product extends UpdatedAt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @ManyToOne
    @JoinColumn(name = "판매자ID") // 외래키 이름
    private Users sellerId;
    @Column(name = "구매자ID")
    private long buyerId;
    @Column(name = "카테고리ID")
    private long categoryId;
    @Column(name = "가격")
    private long price;
    @Column(name = "글 제목")
    private String title;
    @Column(name = "상세내용")
    private String descripion;
    @Column(name = "지역")
    private String location;
    @Column(name = "상태") // 삭제,예약중,판매중,판매완료
    private long productState;
    @Column(name = "썸네일")
    private String thumbNailImage;
    @Column(name = "조회수")
    private long viewCnt;
    @Column(name = "끌어올리기 횟수") // 끌어올리기 횟수
    private long refreshCnt;
    @Column(name = "사용일시") // 끌어올리기 사용일시
    private LocalDateTime refreshedAt;



}
