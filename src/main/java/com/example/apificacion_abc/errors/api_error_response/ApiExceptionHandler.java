package com.example.apificacion_abc.errors.api_error_response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
	public class ApiExceptionHandler {

		@ExceptionHandler({ApiException.class})
		public ResponseEntity<ApiError> handleApiErrorResponse(ApiException ex) {
			return new ResponseEntity<ApiError>(ex.getError(), ex.getStatus());
		}
}