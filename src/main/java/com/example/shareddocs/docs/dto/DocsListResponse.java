package com.example.shareddocs.docs.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DocsListResponse {

  private String id;

  private String roomIdx;

  private String title;

  private Long createMemberId;

  public static List<DocsListResponse> toResponse(List<DocsDto> docsDtoList) {

    if (docsDtoList != null ){
      List<DocsListResponse> docsListResponseList = new ArrayList<>();
      for (DocsDto docsDto : docsDtoList) {
        docsListResponseList.add(toResponse(docsDto));
      }
      return docsListResponseList;
    }
    return new ArrayList<>();
  }

  public static DocsListResponse toResponse(DocsDto docsDto) {
    return DocsListResponse.builder()
                          .id(docsDto.getId())
                          .roomIdx(docsDto.getRoomIdx())
                          .title(docsDto.getTitle())
                          .createMemberId(docsDto.getCreateMemberId())
                          .build();
  }
}
