package io.github.jeromewolff.test.configuration;

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
}
