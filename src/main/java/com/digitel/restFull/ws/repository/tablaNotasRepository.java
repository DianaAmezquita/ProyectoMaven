package com.digitel.restFull.ws.repository;

import java.awt.print.Pageable;
import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.digitel.restFull.ws.entity.tablaNotas;

@Repository("repositorio")
public interface tablaNotasRepository extends JpaRepository<tablaNotas,Serializable>, PagingAndSortingRepository<tablaNotas, Serializable>{
	
	public abstract tablaNotas findByFoto(String foto);
	
	public abstract tablaNotas findByCedula(String cedula);
	
	public abstract tablaNotas findByFirma(String firma);
	
	public abstract tablaNotas findByHuella(String huella);
	
	public abstract tablaNotas findByFotoAndCedulaAndFirmaAndHuella(String foto,String cedula, String firma, String huella);

	public abstract Page<tablaNotas> findAll(Pageable pageable);
	
}