package com.example.shareddocs.docs.controller;


import com.example.shareddocs.docs.dto.DeltaMessage;
import com.example.shareddocs.docs.dto.DocsDto;
import com.example.shareddocs.docs.dto.RequestedDocument;
import com.example.shareddocs.docs.dto.SelectionChangeMessage;
import com.example.shareddocs.docs.entity.mongodb.Docs;
import com.example.shareddocs.docs.entity.mongodb.DocsRepository;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class DocsWebSocketController {
  private final DocsRepository docsRepository;

  private final SimpMessagingTemplate messagingTemplate;
  @MessageMapping("/doc.showDocs")
  @SendTo("/topic/public")
  public DocsDto sendMessage(
      @Payload RequestedDocument requestedDocument
  ) {
    Docs docs = docsRepository.findById(requestedDocument.getDocumentId())
        .orElseThrow(() -> new NoSuchElementException());
    return DocsDto.of(docs);
  }

  @MessageMapping("/doc.updateDocsBySelectionChange")
  public void handleBroadCastBySelectionChange(@Payload DeltaMessage deltaMessage) {
    LinkedHashMap<String, Integer> deltaValue = (LinkedHashMap<String, Integer>) deltaMessage.getDeltaValue();

    System.out.println(deltaMessage);

    Integer index = deltaValue.get("index");
    Integer length = deltaValue.get("length");

    SelectionChangeMessage selectionChangeMessage = SelectionChangeMessage.builder()
          .eventName("selection-change")
          .index(index)
          .length(length)
          .build();
    messagingTemplate.convertAndSend("/topic/broadcastBySelectionChange", selectionChangeMessage);
  }

  @MessageMapping("/doc.updateDocsByTextChange")
  public void handleBroadCastByTextChange(@Payload DeltaMessage deltaMessage) {

    System.out.println(deltaMessage);

    messagingTemplate.convertAndSend("/topic/broadcastByTextChange", deltaMessage);
  }
}


