package com.digitel.restFull.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	public boolean crear(tablaNotas tablanotas) {
		
		try {
			
			repositorio.save(tablanotas);
			return true;
			
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean actualizar(tablaNotas tablanotas) {
		
		try {
			
			repositorio.save(tablanotas);
			return true;
			
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean borrar(int id_digitel, String foto, String cedula, String firma, String huella) {
		
		try {
			
			tablaNotas tablanotas = repositorio.findByFotoAndCedulaAndFirmaAndHuella(foto, cedula, firma, huella);
			repositorio.delete(tablanotas);
			return true;
			
		}catch(Exception e){
			return false;
		}
	}
	
	public List<MtablaNotas> obtener(){
		
		return convertidor.convertirLista(repositorio.findAll());
		
	}
	
	public MtablaNotas obtenerPorFotoCedulaFirmaHuella(String foto,String cedula, String firma, String huella){
		
		return new MtablaNotas(repositorio.findByFotoAndCedulaAndFirmaAndHuella(foto, cedula, firma, huella));
		
	}
	
}