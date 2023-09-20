package com.example.apificacion_abc.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ApiKey")
public class ApiKeyModel {
	@Id
	@Column(unique = true, nullable = false)
	private String clave;

	public String getId() {
		return clave;
	}

	public void setId(String clave) {
		this.clave = clave;
	}

}
