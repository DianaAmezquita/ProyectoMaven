package com.digitel.restFull.ws.model;

import com.digitel.restFull.ws.entity.tablaNotas;

public class MtablaNotas {
	
	/// tambien se realizara un constructor vacio
	
	public MtablaNotas() {
		
	}
	//ahora hare un constructor que pida como parametro una entity
	
	// ahora hare que pase de ser un modelo a una entidad llamandola
	
	public MtablaNotas(tablaNotas tablanotas) {
		this.id_digitel = tablanotas.getId_digitel();
		this.foto = tablanotas.getFoto();
		this.cedula = tablanotas.getCedula();
		this.firma = tablanotas.getFirma();
		this.huella = tablanotas.getHuella();
	}
	
	//este es el mismo que el tablaNotas solo que tiene como diferencia que va a trabajar con los controladores
	
	public MtablaNotas(int id_digitel, String foto, String cedula, String firma, String huella) {
		this.id_digitel = id_digitel;
		this.foto = foto;
		this.cedula = cedula;
		this.firma = firma;
		this.huella = huella;
	
	}
	
	// se hace la declaracion de variables
	
	private int id_digitel;
	
	private String foto;
	
	private String cedula;
	
	private String firma;
	
	private String huella;
	
	//se procede a arealizar los metdos setters y getters

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
