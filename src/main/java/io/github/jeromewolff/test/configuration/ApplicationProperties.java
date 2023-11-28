package io.github.jeromewolff.test.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for managing application-specific properties.
 *
 * @author Jerome Wolff
 */
@Configuration
@ConfigurationProperties(prefix = "spring.application.message.generation")
public class ApplicationProperties {
  private boolean messageGenerationEnabled;
  private int messagesToGenerateCount;

  /**
   * Indicates whether the generation of random messages on startup is enabled.
   *
   * @return True if message generation is enabled, otherwise false.
   */
  public boolean isMessageGenerationEnabled() {
    return messageGenerationEnabled;
  }

  void setMessageGenerationEnabled(boolean messageGenerationEnabled) {
    this.messageGenerationEnabled = messageGenerationEnabled;
  }

  /**
   * Gets the count of random messages to generate on startup.
   *
   * @return The count of random messages to generate.
   */
  public int messagesToGenerateCount() {
    return messagesToGenerateCount;
  }

  void setMessagesToGenerateCount(int messagesToGenerateCount) {
    this.messagesToGenerateCount = messagesToGenerateCount;
  }
}
