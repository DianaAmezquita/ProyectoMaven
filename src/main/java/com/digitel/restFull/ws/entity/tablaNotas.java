package com.digitel.restFull.ws.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

//para mapear la base de datos y acceder a los metodos

@Table(name="tablaNotas")
@Entity
@XmlRootElement

//este archivo se va a trabajar con los repositorios

public class tablaNotas implements Serializable{
	
	//constructor vacio para que hibernate pueda acceder
	
	public tablaNotas() {
		
	}
	
	//constructor para poder hacer uso de la base de datos
	
	public tablaNotas(int id_digitel, String foto, String cedula, String firma, String huella) {
		this.id_digitel = id_digitel;
		this.foto = foto;
		this.cedula = cedula;
		this.firma = firma;
		this.huella = huella;
	}

	//Creacion de la base de dados
	
	@GeneratedValue
	@Id
	@Column(name="ID_DIGITEL")
	private int id_digitel;
	
	@Column(name="FOTO")
	private String foto;
	
	@Column(name="CEDULA")
	private String cedula;
	
	@Column(name="FIRMA")
	private String firma;
	
	@Column(name="HUELLA")
	private String huella;
	
	//getters y setters de la misma

	public int getId_digitel() {
		return id_digitel;
	}

	public void setId_digitel(int id_digitel) {
		this.id_digitel = id_digitel;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getHuella() {
		return huella;
	}

	public void setHuella(String huella) {
		this.huella = huella;
	}
	
	
}
