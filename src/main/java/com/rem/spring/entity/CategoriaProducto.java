package com.rem.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// Generated 26-jul-2017 14:25:36 by Hibernate Tools 5.2.3.Final

/**
 * CategoriaProducto generated by hbm2java
 */
@Entity
public class CategoriaProducto implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	private String nombre;
	private boolean estado;
	
	@OneToMany(mappedBy="categoria", cascade=CascadeType.ALL)
	private List<Producto>  producto;

	public CategoriaProducto() {
	}

	public CategoriaProducto(String nombre, boolean estado) {
		this.nombre = nombre;
		this.estado = estado;
	}
	
	public List<Producto> getProducto() {
		return producto;
	}
	
	public void setProducto(List<Producto> producto) {
		this.producto = producto;
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

}
