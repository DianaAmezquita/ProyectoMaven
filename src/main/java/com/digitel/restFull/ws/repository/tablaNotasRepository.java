package com.digitel.restFull.ws.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitel.restFull.ws.entity.tablaNotas;

@Repository("repositorio")
public interface tablaNotasRepository extends JpaRepository<tablaNotas,Serializable>{
	
	public abstract tablaNotas findByFoto(String foto);
	
	public abstract tablaNotas findByCedula(String cedula);
	
	public abstract tablaNotas findByFirma(String firma);
	
	public abstract tablaNotas findByHuella(String huella);
	
	public abstract tablaNotas findByFotoAndCedulaAndFirmaAndHuella(String foto,String cedula, String firma, String huella);
}