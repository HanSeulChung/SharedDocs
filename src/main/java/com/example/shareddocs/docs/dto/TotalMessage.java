package com.example.shareddocs.docs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TotalMessage {
  private String eventName; // 이벤트 유형
  private String content; // Quill에서 받은 전체 content 값
}
