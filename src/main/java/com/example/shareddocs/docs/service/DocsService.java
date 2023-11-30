package com.example.shareddocs.docs.service;

import com.example.shareddocs.docs.dto.DocsDto;
import com.example.shareddocs.docs.dto.DocsInitRequest;
import java.util.List;

public interface DocsService {

  /**
   * 문서 전체 조회
   */
  List<DocsDto> getAllDocs();

  /**
   * 문서 초기 생성
   */
  DocsDto createDocs(DocsInitRequest request);
}
