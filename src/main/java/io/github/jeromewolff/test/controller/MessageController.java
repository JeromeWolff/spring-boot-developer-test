package io.github.jeromewolff.test.controller;

import io.github.jeromewolff.test.model.Message;
import io.github.jeromewolff.test.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * REST Controller for managing messages.
 *
 * @author Jerome Wolff
 */
@RestController
@RequestMapping("/api/messages")
public class MessageController {
  private final MessageService messageService;

  @Autowired
  private MessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  /**
   * Handles GET requests to retrieve all messages.
   *
   * @return A CompletableFuture containing a ResponseEntity with the list of messages.
   *         If an exception occurs, a ResponseEntity with status 500 and a {@code null} body is returned.
   */
  @GetMapping
  public CompletableFuture<ResponseEntity<List<Message>>> getAllMessages() {
    return this.messageService.getAllMessages()
      .thenApply(ResponseEntity::ok)
      .exceptionally(throwable -> ResponseEntity.status(500).body(null));
  }
}
