package com.rem.spring.model;

import java.io.Serializable;

public class CategoriaProductoModel implements Serializable {
	
	private Integer id;
	private String nombre;
	private boolean estado;
	
	public CategoriaProductoModel(Integer id, String nombre, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
	}
	public CategoriaProductoModel() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "CategoriaProductoModel [id=" + id + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
	
}