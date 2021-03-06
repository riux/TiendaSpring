package com.rem.spring.entity;
// Generated 26-jul-2017 14:25:36 by Hibernate Tools 5.2.3.Final

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.io.Serializable;

/**
 * Persona generated by hbm2java
 */
@Entity
public class Persona implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	private boolean estado;
	private Date fechaRegistro;
	private String nombres;
	private String apePaterno;
	private String apeMaterno;
	private String direccion;
	private Date fecNacimiento;
	private String genero;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="td_usuario_id")
	private Usuario usuario;

	
	public Persona() {
		
	}

	public Persona(Integer id, boolean estado, Date fechaRegistro, String nombres, String apePaterno, String apeMaterno,
			String direccion, Date fecNacimiento, String genero, Usuario usuario) {
		super();
		this.id = id;
		this.estado = estado;
		this.fechaRegistro = fechaRegistro;
		this.nombres = nombres;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.direccion = direccion;
		this.fecNacimiento = fecNacimiento;
		this.genero = genero;
		this.usuario = usuario;
	}

	public Persona(Integer id, boolean estado, Date fechaRegistro, String nombres, String apePaterno, String apeMaterno,
			Date fecNacimiento, String genero, Usuario usuario) {
		super();
		this.id = id;
		this.estado = estado;
		this.fechaRegistro = fechaRegistro;
		this.nombres = nombres;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.fecNacimiento = fecNacimiento;
		this.genero = genero;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecNacimiento() {
		return fecNacimiento;
	}

	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
