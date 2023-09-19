package com.example.apificacion_abc.errors.api_error_response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Para sobreescribir los errores en general
 */
@ControllerAdvice
public class ExceptionExceptionHandler {

	@ExceptionHandler({Exception.class})
	public ResponseEntity<ApiError> handleApiErrorResponse(Exception ex) {
		ex.printStackTrace();
		return new ResponseEntity<ApiError>(new ApiError("g100", "Error interno del servidor"), HttpStatus.NOT_FOUND);
	}
}