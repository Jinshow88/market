package com.example.market.entity;



import com.example.market.entity.common.UpdatedAt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "category")
public class Category extends UpdatedAt{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoyId;
    @Column(name = "카테고리")
    private String name;

}
