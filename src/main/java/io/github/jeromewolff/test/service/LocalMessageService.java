package io.github.jeromewolff.test.service;

import io.github.jeromewolff.test.model.Message;
import io.github.jeromewolff.test.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The default {@link MessageService} implementation used for interacting with messages.
 *
 * @author Jerome Wolff
 * @see MessageService
 */
@Service
public class LocalMessageService implements MessageService {
  private final MessageRepository messageRepository;

  @Autowired
  private LocalMessageService(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  /**
   * Asynchronously retrieves all messages.
   *
   * @return A {@link CompletableFuture} containing a list of messages.
   */
  @Async
  @Override
  public CompletableFuture<List<Message>> getAllMessages() {
    List<Message> messages = this.messageRepository.findAll();
    return CompletableFuture.completedFuture(messages);
  }

  /**
   * Asynchronously saves a message.
   *
   * @param message The message to be saved.
   * @return A {@link CompletableFuture} containing the saved message.
   */
  @Async
  public CompletableFuture<Message> save(Message message) {
    Message saved = this.messageRepository.save(message);
    return CompletableFuture.completedFuture(saved);
  }
}
