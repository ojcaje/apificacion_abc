package com.example.apificacion_abc.utils;

import java.util.Objects;

/**
 * Para leer las noticias de la página del diario
 */
public class Noticia {
	
	private String fecha;
	private String enlace;
	private String enlace_foto;
	private String titulo;
	private String resumen;
	private String contenido_foto;
	private String content_type_foto;


	/**
	 * Constructor para los datos mínimos
	 * @param fecha
	 * @param enlace
	 * @param enlace_foto
	 * @param titulo
	 * @param resumen
	 */
	public Noticia(String fecha, String enlace, String enlace_foto, String titulo, String resumen) {
		this.fecha = fecha;
		this.enlace = enlace;
		this.enlace_foto = enlace_foto;
		this.titulo = titulo;
		this.resumen = resumen;
		this.contenido_foto = null;
		this.content_type_foto = null;
	}


	public String getContenido_foto() {
		return contenido_foto;
	}


	public void setContenido_foto(String contenido_foto) {
		this.contenido_foto = contenido_foto;
	}


	public String getContent_type_foto() {
		return content_type_foto;
	}


	public void setContent_type_foto(String content_type_foto) {
		this.content_type_foto = content_type_foto;
	}


	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	public String getEnlace_foto() {
		return enlace_foto;
	}
	public void setEnlace_foto(String enlace_foto) {
		this.enlace_foto = enlace_foto;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	
	public String toHTML(){
		String html;
		html ="<p>" + fecha + "</p>";
		html = html + "<p>" + enlace + "</p>";
		html = html + "<p>" + enlace_foto + "</p>";
		html = html + "<p>" + titulo + "</p>";
		html = html + "<p>" + resumen + "</p>";
		if (!Objects.isNull(contenido_foto)){
			html = html + "<p>" + contenido_foto + "</p>";
			html = html + "<p>" + content_type_foto + "</p>";
		}

		return html;
	}
	
}
