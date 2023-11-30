package com.example.shareddocs.docs.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DocsInitRequest {

  private String title;

  private String content;

  private Long createMemberId;

  private List<Long> membersId;
}
