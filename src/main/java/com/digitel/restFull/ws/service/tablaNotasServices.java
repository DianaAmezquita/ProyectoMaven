package com.digitel.restFull.ws.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.digitel.restFull.ws.converter.Convertidor;
import com.digitel.restFull.ws.entity.tablaNotas;
import com.digitel.restFull.ws.model.MtablaNotas;
import com.digitel.restFull.ws.repository.tablaNotasRepository;

@Service("servicio")
public class tablaNotasServices {
	
	@Autowired
	@Qualifier("repositorio")
	private tablaNotasRepository repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	private static final Log logger = LogFactory.getLog(tablaNotasServices.class);
	
	public boolean crear(tablaNotas tablanotas) {
		
		logger.info("Realizando el registro");
		try {
			
			repositorio.save(tablanotas);
			logger.info("Registro Realizado");
			return true;
			
		}catch(Exception e){
			logger.error("Hubo un Error al cargar los datos");
			return false;
		}
	}
	
	public boolean actualizar(tablaNotas tablanotas) {
		
		logger.info("Actualizando el registro");
		try {
			
			repositorio.save(tablanotas);
			logger.info("Registro actualizado");
			return true;
			
		}catch(Exception e){
			logger.error("Hubo un error al actualizar los datos.");
			return false;
		}
	}
	
	public boolean borrar(int id_digitel, String foto, String cedula, String firma, String huella) {
		
		logger.warn("Se estan borrando los datos.");
		try {
			
			tablaNotas tablanotas = repositorio.findByFotoAndCedulaAndFirmaAndHuella(foto, cedula, firma, huella);
			repositorio.delete(tablanotas);
			logger.info("Datos borrados.");
			return true;
			
		}catch(Exception e){
			logger.error("Ocurrio un error al borrar los datos");
			return false;
		}
	}
	
	public List<MtablaNotas> obtener(){
		logger.info("Obteniendo todos los elementos.");
		return convertidor.convertirLista(repositorio.findAll());
		
	}
	
	public MtablaNotas obtenerPorFotoCedulaFirmaHuella(String foto,String cedula, String firma, String huella){
		
		return new MtablaNotas(repositorio.findByFotoAndCedulaAndFirmaAndHuella(foto, cedula, firma, huella));
		
	}
	
	public List<MtablaNotas> obtenerPorPaginacion(Pageable pageable){
		
		return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
		
	}
	
}