package com.liaw.dev.User.exception;

public class EmailExistingException extends RuntimeException {
  public EmailExistingException(String message) {
    super(message);
  }
}
