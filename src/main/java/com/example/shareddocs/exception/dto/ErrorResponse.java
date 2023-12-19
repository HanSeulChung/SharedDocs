package com.example.shareddocs.exception.dto;


import com.example.shareddocs.exception.type.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorResponse {
  private ErrorCode errorCode;
  private String errorMessage;
}

