package task_api.exceptions;

import task_api.exceptions.TaskNotFoundException;
import task_api.exceptions.MissingFieldsException;
import task_api.exceptions.IllegalStateException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.web.context.request.WebRequest;
import lombok.Data;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @Data
  static class ApiError {
    private final HttpStatus status;
    private final String message;
    private final String error;
  }

  @ExceptionHandler(TaskNotFoundException.class)
  public ResponseEntity<Object> handleTaskNotFoundException(TaskNotFoundException ex, WebRequest request) {
    String message = ex.getMessage();
    String error = "TaskNotFoundException";
    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, message, error);
    return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
    MethodArgumentTypeMismatchException ex, WebRequest request) {
    String message = ex.getName() + " should be of type " + ex.getRequiredType().getName();
    String error = "MethodArgumentTypeMismatchException";
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, message, error);
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MissingFieldsException.class)
  public ResponseEntity<Object> handleMissingFieldsException(MissingFieldsException ex) {
    String error = "MissingFieldsException";
    String message = ex.getMessage();
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, message, error);
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }


  @ExceptionHandler(ResourceAlreadyExistsException.class)
  public ResponseEntity<Object> handleResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {
    String error = "Resource Already Exists";
    String message = ex.getMessage();
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, message, error);
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(IllegalStateException.class)
  public ResponseEntity<Object> handleIllegalStateException(IllegalStateException ex) {
    String error = "Illegal state status";
    String message = ex.getMessage();
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, message, error);
    return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
  }

}