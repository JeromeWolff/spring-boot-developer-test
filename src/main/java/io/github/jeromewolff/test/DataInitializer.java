package io.github.jeromewolff.test;

import io.github.jeromewolff.test.configuration.ApplicationConfiguration;
import io.github.jeromewolff.test.configuration.ApplicationProperties;
import io.github.jeromewolff.test.model.Message;
import io.github.jeromewolff.test.service.MessageService;
import io.github.jeromewolff.test.util.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * DataInitializer is a Spring component that initializes the application data.
 * It generates random messages and saves them to the database upon application startup.
 */
@Component
public final class DataInitializer implements CommandLineRunner {
  private final ApplicationProperties applicationProperties;
  private final MessageService messageService;
  private final RandomGenerator randomGenerator;

  @Autowired
  private DataInitializer(
    ApplicationProperties applicationProperties,
    MessageService messageRepository,
    RandomGenerator randomGenerator
  ) {
    this.applicationProperties = applicationProperties;
    this.messageService = messageRepository;
    this.randomGenerator = randomGenerator;
  }

  /**
   * {@inheritDoc}
   * Runs the data initialization process upon application startup.
   *
   * @param args The command line arguments.
   */
  @Override
  public void run(String... args) {
    if (!this.applicationProperties.isMessageGenerationEnabled()) {
      return;
    }
    this.generateRandomMessages();
  }

  /**
   * Generates random messages if the database table is empty.
   * Checks if the provided list of messages is empty, and if so,
   * triggers the generation of random messages using the {@link MessageService}.
   */
  private void generateRandomMessages() {
    this.messageService.getAllMessages()
      .thenAcceptAsync(this.generateMessagesIfAbsent());
  }

  /**
   * Checks if the provided list of messages is empty, and if so,
   * triggers the generation of random messages using the {@link MessageService}.
   */
  private Consumer<List<Message>> generateMessagesIfAbsent() {
    return messages -> {
      if (messages == null || messages.isEmpty()) {
        this.generateRandomMessages(this.applicationProperties.messagesToGenerateCount());
      }
    };
  }

  /**
   * Generates random messages and saves them to the database.
   *
   * @param count The number of messages to generate.
   */
  private void generateRandomMessages(int count) {
    IntStream.range(0, count)
      .forEach(index -> generateAndSaveRandomMessage());
  }

  /**
   * Generates and saves a random message to the database.
   */
  private void generateAndSaveRandomMessage() {
    LocalDateTime dateTime = this.randomGenerator.generateRandomDateTime();
    String text = this.randomGenerator.generateRandomText();
    Message message = new Message(text, dateTime);
    this.messageService.save(message);
  }
}
