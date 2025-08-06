package com.example.market.entity;

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
@Table(name = "manner")
public class Manner extends UpdatedAt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mannerId;
    @ManyToOne
    @JoinColumn(name = "판매자ID")
    private Users sellerId;
    @ManyToOne
    @JoinColumn(name = "구매자ID")
    private Users buyerId;
    @Column(name = "평가점수")
    private long score;

}
