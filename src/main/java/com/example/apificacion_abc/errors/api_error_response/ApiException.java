package com.example.apificacion_abc.errors.api_error_response;

import org.springframework.http.HttpStatus;

/**
 * Para retornar los errores personalizados
 */
public class ApiException extends Throwable {

	private ApiError error; // aquí irán los datos del error
	private HttpStatus status;

	public ApiException(String codigo, String error, HttpStatus status) {
		this.error = new ApiError(codigo, error);
		this.status = status;
	}

	public ApiError getError() {
		return error;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
