package io.github.jeromewolff.test.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
/**
 * The {@code Message} class represents a message entity in the application.
 * It is annotated with JPA annotations for mapping to the database table "messages".
 *
 * @author Jerome Wolff
 */
@Entity
@Table(name = "messages")
public final class Message {
  /**
   * The unique identifier of the message.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  /**
   * The text content of the message.
   */
  private String text;
  /**
   * The timestamp indicating when the message was created.
   */
  private LocalDateTime timestamp;

  public Message() {}

  public Message(String text, LocalDateTime timestamp) {
    this.text = text;
    this.timestamp = timestamp;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}
