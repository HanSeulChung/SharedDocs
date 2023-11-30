package com.example.shareddocs.docs.service;

import com.example.shareddocs.docs.dto.DocsDto;
import java.util.List;

public interface DocsService {

  /**
   * 문서 전체 조회
   */
  List<DocsDto> getAllDocs();
}
