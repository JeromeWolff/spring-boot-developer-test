package io.github.jeromewolff.test.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

/**
 * Configuration class for managing application-specific settings.
 *
 * @author Jerome Wolff
 */
@Configuration
public class ApplicationConfiguration {
  @Value("${spring.application.message.generation.enabled}")
  private boolean messageGenerationEnabled;
  @Value("${spring.application.message.generation.count}")
  private int messagesToGenerateCount;

  /**
   * Creates a singleton instance of the {@link Random} class.
   *
   * @return A singleton instance of the {@link Random} class.
   */
  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
  Random random() {
    return new Random();
  }

  /**
   * Indicates whether the generation of random messages on startup is enabled.
   *
   * @return True if message generation is enabled, otherwise false.
   */
  public boolean isMessageGenerationEnabled() {
    return messageGenerationEnabled;
  }

  /**
   * Gets the count of random messages to generate on startup.
   *
   * @return The count of random messages to generate.
   */
  public int messagesToGenerateCount() {
    return messagesToGenerateCount;
  }
}
