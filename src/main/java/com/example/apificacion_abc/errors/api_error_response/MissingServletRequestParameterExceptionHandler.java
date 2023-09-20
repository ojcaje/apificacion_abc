package com.example.apificacion_abc.errors.api_error_response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Para sobreescribir el error de que falta un parámetro
 */
@ControllerAdvice
public class MissingServletRequestParameterExceptionHandler {

	@ExceptionHandler({MissingServletRequestParameterException.class})
	public ResponseEntity<ApiError> handleApiErrorResponse(MissingServletRequestParameterException ex) {
		return new ResponseEntity<ApiError>(new ApiError("g268", "Parámetros inválidos"), HttpStatus.NOT_FOUND);
	}
}