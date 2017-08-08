package com.rem.spring.entity;

import java.util.List;

public class Shopper {

	private List<String> listaProductos;

	public Shopper(List<String> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	public Shopper() {
		
	}

	public List<String> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<String> listaProductos) {
		this.listaProductos = listaProductos;
	}

	@Override
	public String toString() {
		return "Shopper [listaProductos=" + listaProductos + "]";
	}
	


}