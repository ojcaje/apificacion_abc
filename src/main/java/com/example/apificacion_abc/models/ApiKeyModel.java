package com.example.apificacion_abc.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ApiKey")
public class ApiKeyModel {
	@Id
	@Column(unique = true, nullable = false)
	private String key;

	public String getId() {
		return key;
	}

	public void setId(String key) {
		this.key = key;
	}

}
