package com.delinkcious.linkservice.domain;

import lombok.Getter;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
// JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우, 해당 클래스의 필드도 칼럼으로 인식하게 함
@MappedSuperclass
// BaseTimeEntity 클래스에 Auditing 기능 포함
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    // Entity가 생성되어 저장될 때 시간이 자동 저장됨
    @CreatedDate
    private LocalDateTime createdDate;
    // 조회한 Entity의 값을 변경할 때 시간이 자동 저장됨
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
