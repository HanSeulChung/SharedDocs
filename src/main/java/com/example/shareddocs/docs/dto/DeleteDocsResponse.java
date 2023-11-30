package com.example.shareddocs.docs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DeleteDocsResponse {

  private String id;

  private String documentIdx;

  private String title;

  private String message;
}
