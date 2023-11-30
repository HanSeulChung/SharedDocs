package com.example.shareddocs.docs.service;

import com.example.shareddocs.docs.dto.DeleteDocsResponse;
import com.example.shareddocs.docs.dto.DocsDto;
import com.example.shareddocs.docs.dto.DocsInitRequest;
import java.util.List;

public interface DocsService {

  /**
   * 문서 전체 조회
   */
  List<DocsDto> getDocsList();

  /**
   * 문서 초기 생성
   */
  DocsDto createDocs(DocsInitRequest request);

  /**
   * 문서 삭제
   */
  DeleteDocsResponse deleteDocs(Long teamId, String documentId);

  /**
   * 문서 전체 삭제
   * 추후 나중 서비스때는 구현 X
   */
  String deleteAllDocs(Long teamId);
}
