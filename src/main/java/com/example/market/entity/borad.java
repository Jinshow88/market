package com.example.market.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "borads")

public class borad {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String borad;
}
