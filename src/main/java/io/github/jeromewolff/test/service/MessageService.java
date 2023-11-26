package io.github.jeromewolff.test.service;

import io.github.jeromewolff.test.model.Message;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The {@link MessageService} interface defines methods for interacting with messages.
 *
 * @author Jerome Wolff
 */
public interface MessageService {
  /**
   * Asynchronously retrieves all messages.
   *
   * @return A {@link CompletableFuture} containing a list of messages.
   */
  @Async
  CompletableFuture<List<Message>> getAllMessages();

  /**
   * Asynchronously saves a message.
   *
   * @param message The message to be saved.
   * @return A {@link CompletableFuture} containing the saved message.
   */
  @Async
  CompletableFuture<Message> save(Message message);
}
