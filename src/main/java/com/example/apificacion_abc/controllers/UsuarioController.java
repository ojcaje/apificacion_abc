package com.example.apificacion_abc.controllers;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apificacion_abc.models.UsuarioModel;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@GetMapping()
	public ArrayList<UsuarioModel> get(){
		ArrayList<UsuarioModel> respuesta = new ArrayList<UsuarioModel>();
		respuesta.add(new UsuarioModel());

		return(respuesta);
	}
}
