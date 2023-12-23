package com.example.shareddocs.docs.dto;

import com.example.shareddocs.docs.entity.mongodb.Docs;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DocsDto {

  private String id;

  private String title;

  private String content;
  private Long writerId;
  private Long modifierId;

  private Long writerId;
  private Long modifierId;

  private Long teamId;

  private LocalDateTime createdDt;
  private LocalDateTime updatedDt;

  public static List<DocsDto> of(List<Docs> docsList) {

    if (docsList != null ){
      List<DocsDto> docsListResponseList = new ArrayList<>();
      for (Docs docs : docsList) {
        docsListResponseList.add(of(docs));
      }
      return docsListResponseList;
    }
    return new ArrayList<>();
  }

  public static DocsDto of(Docs docs) {
    return DocsDto.builder()
        .id(docs.getId())
        .title(docs.getTitle())
        .content(docs.getContent())
        .writerId(docs.getWriterId())
        .modifierId(docs.getModifierId())
        .teamId(docs.getTeamId())
        .createdDt(docs.getCreatedDt())
        .updatedDt(docs.getUpdatedDt())
        .build();
  }
}
