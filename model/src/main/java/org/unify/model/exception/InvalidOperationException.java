package org.unify.model.exception;

public class InvalidOperationException extends RuntimeException {
  public InvalidOperationException(String operation) {
    super("The operation '" + operation + "' does not exist or is not allowed.");
  }
}