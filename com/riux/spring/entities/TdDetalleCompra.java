package com.riux.spring.entities;
// Generated 26-jul-2017 13:11:43 by Hibernate Tools 5.2.3.Final

/**
 * TdDetalleCompra generated by hbm2java
 */
public class TdDetalleCompra implements java.io.Serializable {

	private Integer id;
	private TdCompra tdCompra;
	private TdProducto tdProducto;
	private int cantidad;

	public TdDetalleCompra() {
	}

	public TdDetalleCompra(TdCompra tdCompra, TdProducto tdProducto, int cantidad) {
		this.tdCompra = tdCompra;
		this.tdProducto = tdProducto;
		this.cantidad = cantidad;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TdCompra getTdCompra() {
		return this.tdCompra;
	}

	public void setTdCompra(TdCompra tdCompra) {
		this.tdCompra = tdCompra;
	}

	public TdProducto getTdProducto() {
		return this.tdProducto;
	}

	public void setTdProducto(TdProducto tdProducto) {
		this.tdProducto = tdProducto;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
