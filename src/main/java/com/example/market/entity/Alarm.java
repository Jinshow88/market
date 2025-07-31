package com.example.market.entity;

import com.example.market.entity.common.CreatedAt;

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
@Table(name = "")
public class Alarm extends CreatedAt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;
    @Column(name = "사용자ID")
    private long userId;
    @Column(name = "알림유형")
    private long notificationType;
    @Column(name = "식별자")
    private long identifier;
    @Column(name = "확인여부")
    private boolean isRead;
    @Column(name = "삭제여부")
    private boolean isValid;
}
