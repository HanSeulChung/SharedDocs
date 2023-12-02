package com.example.shareddocs.docs.controller;

import com.example.shareddocs.docs.dto.DocsDto;
import com.example.shareddocs.docs.dto.DocsMessage;
import com.example.shareddocs.docs.entity.mongodb.Docs;
import com.example.shareddocs.docs.entity.mongodb.DocsRepository;
import java.util.NoSuchElementException;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;


@Controller
@RequiredArgsConstructor
public class DocsWebSocketController {
  private final DocsRepository docsRepository;

  @MessageMapping("/chat.showDocs")
  @SendTo("/topic/public")
  public DocsDto sendMessage(
      @Payload DocsMessage docsMessage
  ) {
    Docs docs = docsRepository.findByDocumentIdx(docsMessage.getDocumentIdx())
        .orElseThrow(() -> new EntityNotFoundException());
    return DocsDto.of(docs);
  }

//  @MessageMapping("/chat.bringDocs")
//  @SendTo("/topic/public")
//  public DocsMessage addUser(
//      @Payload DocsMessage docsMessage,
//      SimpMessageHeaderAccessor headerAccessor
//  ) {
//    // Add username in web socket session
//    headerAccessor.getSessionAttributes().put("documentIdx", docsMessage.getDocumentIdx());
//    return docsMessage;
//  }
}
//@Controller
//@RequiredArgsConstructor
//public class DocsWebSocketController {
//  private final DocsRepository docsRepository;
//  private final SimpMessageSendingOperations simpMessageSendingOperations;
//
//
//  @MessageMapping("/sendMessage") // 클라이언트에서 서버로 메시지를 보내는 엔드포인트
//  @SendTo("/topic/messages") // 서버에서 클라이언트로 메시지를 보내는 대상
//  public Message sendMessage(Message message) {
//    // 클라이언트로 보낼 메시지 처리
//    return new Message("Hello, Client!");
//  }
//
////  @MessageMapping("/docs")
////  @SendTo("/topic/documents")
////  public String viewDocs() throws Exception {
////    String documentId ="89f67a7b-2b37-4669-b934-c526b628db85";
////    Docs docs = docsRepository.findByDocumentIdx(documentId)
////        .orElseThrow(() -> new NoSuchElementException());
////    simpMessageSendingOperations.convertAndSend("/topic/documents", DocsDto.of(docs));
////    return "OK";
////  }
//}
