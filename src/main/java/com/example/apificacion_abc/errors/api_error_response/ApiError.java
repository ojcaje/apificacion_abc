package com.example.apificacion_abc.errors.api_error_response;

/**
 * Clase para poder retornar el error al cliente de manera limpia,
 * o sea se retornarán sólo los datos personalizados
*/
public class ApiError {

	private String codigo;
	private String error;

	public ApiError(String codigo, String error) {
		this.codigo = codigo;
		this.error = error;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
