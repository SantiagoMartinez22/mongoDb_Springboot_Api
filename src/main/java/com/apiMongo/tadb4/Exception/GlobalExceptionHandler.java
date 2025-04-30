package com.apiMongo.tadb4.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  // Manejo específico para InvalidIdException
  @ExceptionHandler(InvalidIdException.class)
  public ResponseEntity<String> handleInvalidIdException(InvalidIdException ex) {
    return ResponseEntity
            .badRequest()
            .body(ex.getMessage());
  }

  // Manejo general de excepciones no controladas
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
    ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            ex.getMessage(),
            request.getDescription(false)
    );
    return ResponseEntity
            .internalServerError()
            .body(errorResponse);
  }

  // Manejo de errores de validación (@Valid)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
    String errorMessage = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .findFirst()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .orElse("Error de validación");

    ErrorResponse errorResponse = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            errorMessage,
            "Validation error"
    );
    return ResponseEntity
            .badRequest()
            .body(errorResponse);
  }


  public record ErrorResponse(
          int statusCode,
          String message,
          String details
  ) {}
}

