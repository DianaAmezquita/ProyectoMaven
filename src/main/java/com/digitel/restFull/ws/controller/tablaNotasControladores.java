package com.digitel.restFull.ws.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitel.restFull.ws.entity.tablaNotas;
import com.digitel.restFull.ws.model.MtablaNotas;
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

	@DeleteMapping("/tablaNotas/{id_digitel}/{foto}")
	public boolean borrartablaNotas(@PathVariable("id_digitel") int id_digitel, @PathVariable("foto") String foto, @PathVariable("cedula") String cedula, @PathVariable("firma") String firma, @PathVariable("huella") String huella) {
		return service.borrar(id_digitel, foto, cedula, firma, huella);
	}
	
	@GetMapping(value="/tablaNotas")
	public List<MtablaNotas> obtenertablaNotas(Pageable pageable){
		
		return service.obtenerPorPaginacion(pageable);
	}
	
}
