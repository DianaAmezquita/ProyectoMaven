package com.digitel.restFull.ws.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitel.restFull.ws.entity.Usuario;

@Repository("gestoUsuario")
public interface GestorUsuario extends JpaRepository<Usuario, Serializable>{
	public abstract Usuario findByUsuario(String usuario);
	

}
