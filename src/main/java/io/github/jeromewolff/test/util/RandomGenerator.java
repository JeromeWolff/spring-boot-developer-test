package io.github.jeromewolff.test.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Utility class for generating random text, dates and times.
 *
 * @author Jerome Wolff
 */
@Component
public final class RandomGenerator {
  private static final String[] MESSAGE_PARTS = "Develop a simple RESTful API with Spring Boot that provides access to a messages table in a database The API should retrieve all records from the table and return them in JSON format via a GET request".split(" ");
  private static final int DEFAULT_MIN_WORDS = 10;
  private static final int DEFAULT_MAX_WORDS = 20;
  private static final int LAST_YEAR = LocalDateTime.now().getYear() - 1;
  private final Random random;

  @Autowired
  private RandomGenerator(Random random) {
    this.random = random;
  }

  /**
   * Constructs random text by combining random parts of predefined message parts.
   *
   * @return The constructed random text.
   */
  public String generateRandomText() {
    return this.generateRandomText(DEFAULT_MIN_WORDS, DEFAULT_MAX_WORDS);
  }

  /**
   * Generates random text with a specified maximum word count.
   *
   * @param maxWords The maximum number of words in the generated text.
   * @return The constructed random text.
   */
  public String generateRandomText(int maxWords) {
    return this.generateRandomText(Math.min(DEFAULT_MIN_WORDS, maxWords), maxWords);
  }

  /**
   * Generates random text within a specified word count range.
   *
   * @param minWords The minimum number of words in the generated text.
   * @param maxWords The maximum number of words in the generated text.
   * @return The constructed random text.
   */
  public String generateRandomText(int minWords, int maxWords) {
    int messageLength = this.random.nextInt(minWords, maxWords);
    int partsLength = MESSAGE_PARTS.length;
    return IntStream.range(0, messageLength)
      .map(index -> this.random.nextInt(partsLength))
      .mapToObj(index -> MESSAGE_PARTS[index])
      .map(text -> MessageFormat.format("{0} ", text))
      .collect(Collectors.joining())
      .trim();
  }

  /**
   * Generates a random date and time within the last year.
   *
   * @return The generated random date and time.
   */
  public LocalDateTime generateRandomDateTime() {
    LocalDate date = this.generateRandomDate();
    LocalTime time = this.generateRandomTime();
    return LocalDateTime.of(date, time);
  }

  /**
   * Generates a random date within the last year.
   *
   * @return The generated random date.
   */
  public LocalDate generateRandomDate() {
    int dayOfYear = this.random.nextInt(1, 365);
    return LocalDate.ofYearDay(LAST_YEAR, dayOfYear);
  }

  /**
   * Generates a random time.
   *
   * @return The generated random time.
   */
  public LocalTime generateRandomTime() {
    int hour = this.random.nextInt(0, 23);
    int minute = this.random.nextInt(0, 59);
    return LocalTime.of(hour, minute);
  }
}
