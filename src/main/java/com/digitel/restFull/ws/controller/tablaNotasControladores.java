package com.digitel.restFull.ws.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.restFull.ws.entity.tablaNotas;
import com.digitel.restFull.ws.service.tablaNotasServices;

@RestController
@RequestMapping("/v1")
public class tablaNotasControladores {
	
	@Autowired
	@Qualifier("servicio")
	tablaNotasServices service;
	
	@PutMapping("/tablaNotas")
	public boolean agregartablaNotas(@RequestBody @Valid tablaNotas tablanotas) {
		
		return service.crear(tablanotas);
		
	}

	@PostMapping("/tablaNotas")
	public boolean actualizartablaNotas(@RequestBody @Valid tablaNotas tablanotas) {
		
		return service.actualizar(tablanotas);
		
	}
	
}
