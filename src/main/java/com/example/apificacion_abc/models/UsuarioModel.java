package com.example.apificacion_abc.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Model creado sólo a modo de prueba
 */
@Entity
@Table(name = "usuario")
public class UsuarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;


	private String nombre;

	
	public Long getId() {
		return (long) 1;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return "nombre 1";
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
