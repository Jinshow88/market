package com.example.market.entity;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.example.market.entity.common.UpdatedAt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class Users extends UpdatedAt{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "이름")
    private String userName;
    @Column(name = "닉네임")
    private String userNic;
    @Column(name = "이메일")
    private String userEmail;
    @Column(name = "비밀번호")
    private String userPw;
    @Column(name = "휴대폰")
    private String userPhone;
    @Column(name = "주소")
    private String userAddress;

}
