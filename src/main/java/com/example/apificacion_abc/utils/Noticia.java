package com.example.apificacion_abc.utils;

/**
 * Para leer las noticias de la página del diario
 */
public class Noticia {
	
	private String fecha;
	private String enlace;
	private String enlace_foto;
	private String titulo;
	private String resumen;


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
	

	
}
