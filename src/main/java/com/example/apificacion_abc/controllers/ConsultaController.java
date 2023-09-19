package com.example.apificacion_abc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apificacion_abc.services.AbcService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * Controller para realizar las consultas
 */
@RestController
@RequestMapping("/consulta")
public class ConsultaController {

	@Operation(summary = "Realizar las consultas", description = "Realiza la consulta a abc y devuelve los resultados")
	@GetMapping()
	public String consulta(
		@Parameter(required = true, description = "Texto de búsqueda") @RequestParam String q) {

			// intentar devolver el html de abc o mostrar el error que ocurra
			try {
			
				return AbcService.getFromABC(q);
			
			} catch (Exception e) {
				e.printStackTrace();
				return "Error al cargar la búsqueda \n" + e.toString();
			}
	}
}
