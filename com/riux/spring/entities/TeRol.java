package com.riux.spring.entities;
// Generated 26-jul-2017 13:11:43 by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * TeRol generated by hbm2java
 */
public class TeRol implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private boolean estado;
	private Set tdUsuarios = new HashSet(0);

	public TeRol() {
	}

	public TeRol(String nombre, boolean estado) {
		this.nombre = nombre;
		this.estado = estado;
	}

	public TeRol(String nombre, boolean estado, Set tdUsuarios) {
		this.nombre = nombre;
		this.estado = estado;
		this.tdUsuarios = tdUsuarios;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Set getTdUsuarios() {
		return this.tdUsuarios;
	}

	public void setTdUsuarios(Set tdUsuarios) {
		this.tdUsuarios = tdUsuarios;
	}

}
