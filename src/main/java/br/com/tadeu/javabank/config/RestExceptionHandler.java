package br.com.tadeu.javabank.config;

import br.com.tadeu.javabank.exception.GenericApplicationException;
import br.com.tadeu.javabank.exception.ValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ConstraintViolationException.class })
	protected ResponseEntity<GenericApplicationException> handleApplicationException(ConstraintViolationException ex,
																					 WebRequest request) {
		ValidationException exception = new ValidationException(400, null, null);
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			exception.addMessage(violation.getMessage());
			exception.addField(violation.getPropertyPath().toString());
		}
		return handleApplicationException(exception, request);
	}

	@ExceptionHandler(value = { GenericApplicationException.class })
	protected ResponseEntity<GenericApplicationException> handleApplicationException(GenericApplicationException ex,
			WebRequest request) {
		return ResponseEntity.status(HttpStatus.valueOf(ex.getErrorCode())).body(ex);
	}
}
