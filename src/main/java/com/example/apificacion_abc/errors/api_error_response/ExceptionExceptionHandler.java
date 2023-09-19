package com.example.apificacion_abc.errors.api_error_response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Para sobreescribir el error de que falta un parámetro
 */
@ControllerAdvice
public class ExceptionExceptionHandler {

	@ExceptionHandler({Exception.class})
	public ResponseEntity<ApiError> handleApiErrorResponse(Exception ex) {
		return new ResponseEntity<ApiError>(new ApiError("g100", "Error interno del servidor"), HttpStatus.NOT_FOUND);
	}
}