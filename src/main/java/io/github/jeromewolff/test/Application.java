package io.github.jeromewolff.test;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * The main entry point for the Spring Boot application.
 * This class initializes and runs the Spring Boot application using the specified configuration.
 *
 * @author Jerome Wolff
 */
@EnableAsync
@EnableJpaRepositories
@SpringBootApplication
public class Application {
  /**
   * The main method to start the Spring Boot application.
   *
   * @param args Command-line arguments passed to the application.
   */
  public static void main(String[] args) {
    new SpringApplicationBuilder(Application.class)
      .bannerMode(Banner.Mode.OFF)
      .run(args);
  }
}
