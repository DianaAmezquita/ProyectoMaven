package com.digitel.restFull.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario {
	
	@GeneratedValue
	@Id
	@Column(name="ID" ,unique =true)
	private long id;
	
	@Column(name="USUARIO"  ,unique =true)
	private String usuario;
	
	@Column(name="CONTRASENA")
	private String contrasena;
	
	@Column(name="ROL")
	private byte rol;

	@Column(name="ACTIVO")
	private boolean activo;
	
	public long getId() {
		
		return id;
		
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public byte getRol() {
		return rol;
	}

	public void setRol(byte rol) {
		this.rol = rol;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
