package com.example.shareddocs.docs.service.impl;

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
  public List<DocsDto> getAllDocs() {
    List<Docs> allDocs = docsRepository.findAll();

    if (allDocs.size() == 0) {
      return new ArrayList<>();
    }
    return DocsDto.of(allDocs);
  }

  @Override
  public DocsDto createDocs(DocsInitRequest request) {
    String uuid = UUID.randomUUID().toString();
    docsRepository.save(Docs.builder()
        .roomIdx(uuid)
        .title(request.getTitle())
        .content(request.getContent())
        .createMemberId(request.getCreateMemberId())
        .memberId(request.getMembersId())
        .build());

    // TODO findBy로 다시 찾지 않고 id를 가져오는 방법이 있는지 ?
    return DocsDto.of(docsRepository.findByRoomIdx(uuid).orElseThrow(() -> new NoSuchElementException()));
  }
}
