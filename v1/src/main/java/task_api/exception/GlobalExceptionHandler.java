package task_api.exception;

import task_api.exception.TaskNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.context.request.WebRequest;
import lombok.Data;


@RestControllerAdvice
class GlobalExceptionHandler {

  @Data
  static class ApiError {
    private final HttpStatus status;
    private final String message;
    private final String error;
}

  @ExceptionHandler(TaskNotFoundException.class)
  public ResponseEntity<Object> handleTaskNotFoundException(TaskNotFoundException ex, WebRequest request) {
    String message = "The task with the specified ID was not found.";
    String error = ex.getMessage();
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, message, error);
    return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
    MethodArgumentTypeMismatchException ex, WebRequest request) {
    String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }
}