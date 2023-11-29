package com.example.shareddocs.base;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

  @Column(nullable = false,updatable = false)
  @CreatedDate
  private String createDt;

  @Column(nullable = false,updatable = false)
  @LastModifiedDate
  private String updateDt;
}
