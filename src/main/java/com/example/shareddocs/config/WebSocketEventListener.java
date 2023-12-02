package com.example.shareddocs.config;

import com.example.shareddocs.docs.dto.DocsMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener {

  private final SimpMessageSendingOperations messagingTemplate;

  @EventListener
  public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
    String documentIdx = (String) headerAccessor.getSessionAttributes().get("documentIdx");
    if (documentIdx != null) {
      log.info("documentIdx disconnected: {}", documentIdx);
      var docsMessage = DocsMessage.builder()
          .documentIdx(documentIdx)
          .build();
      messagingTemplate.convertAndSend("/topic/public", docsMessage);
    }
  }
}
