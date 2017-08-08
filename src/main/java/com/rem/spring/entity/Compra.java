package com.rem.spring.entity;
// Generated 26-jul-2017 14:25:36 by Hibernate Tools 5.2.3.Final
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Compra generated by hbm2java
 */
@Entity
public class Compra implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	private Date fechaCompra;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="td_usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy="compra", fetch= FetchType.LAZY)
	private List<DetalleCompra> detalleCompra;

	
	public Compra() {
	}

	public Compra(Integer id, Date fechaCompra, Usuario usuario) {
		super();
		this.id = id;
		this.fechaCompra = fechaCompra;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DetalleCompra> getDetalleCompra() {
		return detalleCompra;
	}

	public void setDetalleCompra(List<DetalleCompra> detalleCompra) {
		this.detalleCompra = detalleCompra;
	}

	
}