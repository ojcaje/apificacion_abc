package com.example.apificacion_abc.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apificacion_abc.errors.api_error_response.ApiException;
import com.example.apificacion_abc.services.AbcService;
import com.example.apificacion_abc.utils.Noticia;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

/**
 * Controller para realizar las consultas
 */
@RestController
@RequestMapping("/consulta")
public class ConsultaController {

	/**
	 * Realizar las consultas a la página del diario y retornar en JSON
	 * @param q La búsqueda
	 * @return JSON
	 * @throws Exception
	 * @throws ApiException
	 */
	@Operation(summary = "Realizar las consultas", description = "Realiza la consulta a abc y devuelve los resultados")
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_PLAIN_VALUE, MediaType.TEXT_HTML_VALUE})
	public ArrayList<Noticia> consulta(
		@Parameter(required = true, description = "Texto de búsqueda") @RequestParam String q,
		@Parameter(required = false, description = "Atributo extra") @RequestParam(defaultValue = "false") String f) throws Exception, ApiException {

			// intentar devolver el html de abc o mostrar el error que ocurra
			ArrayList<Noticia> noticias = AbcService.arrayNoticias(q, f);
			if(noticias.size()>0){
				return noticias;
			}
			else{
				throw new ApiException("g267", "No se encuentran noticias para el texto: {"+q+"}", HttpStatus.NOT_FOUND);
			}
			
	}

}
