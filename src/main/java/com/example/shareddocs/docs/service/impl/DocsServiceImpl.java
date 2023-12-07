package com.example.shareddocs.docs.service.impl;

import com.example.shareddocs.docs.dto.DeleteDocsResponse;
import com.example.shareddocs.docs.dto.DocsDto;
import com.example.shareddocs.docs.dto.DocsInitRequest;
import com.example.shareddocs.docs.entity.mongodb.Docs;
import com.example.shareddocs.docs.entity.mongodb.DocsRepository;
import com.example.shareddocs.docs.service.DocsService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocsServiceImpl implements DocsService {
  private final DocsRepository docsRepository;
  @Override
  public List<DocsDto> getDocsList() {
    // TODO 조회시에도 사용자에 관해서 유효성 검사 추후 추가
    List<Docs> allDocs = docsRepository.findAll();

    if (allDocs.size() == 0) {
      return new ArrayList<>();
    }
    return DocsDto.of(allDocs);
  }

  @Override
  public DocsDto createDocs(DocsInitRequest request) {
    // TODO 생성시에도 사용자에 관해서 유효성 검사 추후 추가
    String uuid = UUID.randomUUID().toString();
    docsRepository.save(Docs.builder()
        .documentIdx(uuid)
        .title(request.getTitle())
        .content(request.getContent())
        .writerId(request.getWriterId())
        .build());

    // TODO findBy로 다시 찾지 않고 id를 가져오는 방법이 있는지 ?
    return DocsDto.of(docsRepository.findByDocumentIdx(uuid).orElseThrow(() -> new NoSuchElementException()));
  }

  @Override
  public DeleteDocsResponse deleteDocs(Long teamId, String documentId) {
    //TODO: teamId와 추후 사용자의 SecurityUtils 값을 받아 유효성 검사를 추가해야한다.
    Docs docs = docsRepository.findByDocumentIdx(documentId)
        .orElseThrow(() -> new NoSuchElementException());

    docsRepository.deleteByDocumentIdx(documentId);

    return DeleteDocsResponse.builder()
        .id(docs.getId())
        .documentIdx(docs.getDocumentIdx())
        .title(docs.getTitle())
        .message("삭제 되었습니다.")
        .build();
  }

  @Override
  public String deleteAllDocs(Long teamId) {
    docsRepository.deleteAll();
    return "문서가 전체 삭제되었습니다.";
  }
}
