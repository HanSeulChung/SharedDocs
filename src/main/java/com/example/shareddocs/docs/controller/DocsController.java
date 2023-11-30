package com.example.shareddocs.docs.controller;

import com.example.shareddocs.docs.dto.DocsDto;
import com.example.shareddocs.docs.dto.DocsInitRequest;
import com.example.shareddocs.docs.dto.DocsListResponse;
import com.example.shareddocs.docs.service.DocsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DocsController {
  private final DocsService docsService;

  @GetMapping("/team/{teamId}/documents")
  public ResponseEntity<List<DocsListResponse>> getDocs(@PathVariable Long teamId) {
    return ResponseEntity.ok()
              .body(DocsListResponse.toResponse(docsService.getAllDocs()));
  }

  @PostMapping("/team/{teamId}/documents")
  public ResponseEntity<DocsDto> createDocs(@PathVariable Long teamId, @RequestBody DocsInitRequest request) {
    return ResponseEntity.ok()
            .body(docsService.createDocs(request));
  }

}
