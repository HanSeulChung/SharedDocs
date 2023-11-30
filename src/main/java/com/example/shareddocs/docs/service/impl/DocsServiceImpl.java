package com.example.shareddocs.docs.service.impl;

import com.example.shareddocs.docs.dto.DocsDto;
import com.example.shareddocs.docs.entity.mongodb.Docs;
import com.example.shareddocs.docs.entity.mongodb.DocsRepository;
import com.example.shareddocs.docs.service.DocsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocsServiceImpl implements DocsService {
  private final DocsRepository docsRepository;
  @Override
  public List<DocsDto> getAllDocs() {
    List<Docs> allDocs = docsRepository.findAll();

    if (allDocs.size() == 0) {
      return null;
    }
    return DocsDto.of(allDocs);
  }
}
