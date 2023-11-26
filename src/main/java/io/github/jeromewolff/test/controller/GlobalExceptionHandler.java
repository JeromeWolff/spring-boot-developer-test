package io.github.jeromewolff.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * GlobalExceptionHandler is a controller advice class that handles exceptions
 * globally for all controllers in the application.
 *
 * @author Jerome Wolff
 */
@ControllerAdvice
public final class GlobalExceptionHandler {
  /**
   * Handles exceptions and returns a ResponseEntity with an
   * appropriate error message and HTTP status code.
   *
   * @param exception The exception to be handled.
   * @return A ResponseEntity containing an error message and HTTP status code.
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    return new ResponseEntity<>("Internal Server Error: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
