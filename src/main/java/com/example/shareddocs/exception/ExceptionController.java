package com.example.shareddocs.exception;


import com.example.shareddocs.exception.dto.ErrorResponse;
import com.example.shareddocs.exception.type.ErrorCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@RestControllerAdvice
public class ExceptionController {


  @ExceptionHandler(CustomException.class)
  public ErrorResponse handleCustomException(CustomException e) {
    return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
  }

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public ErrorResponse handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
    ErrorCode errorCode = ErrorCode.IMG_FILE_VOLUMNE_TOO_BIG_EXCEPTION;
    return new ErrorResponse(errorCode, errorCode.getErrorMessage());
  }


}