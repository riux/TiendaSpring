package com.rem.spring.model;

public class ProductoCar {
	private int id;
	private String cantidad;
	
	public ProductoCar(int id, String cantidad) {
		super();
		this.id = id;
		this.cantidad = cantidad;
	}
	
	public ProductoCar() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


}
