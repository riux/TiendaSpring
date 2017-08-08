package com.rem.spring.model;

import java.util.List;

public class ListaProductosCar {
	private List<ProductoCar> productos;

	public ListaProductosCar(List<ProductoCar> productos) {
		this.productos = productos;
	}
	
	public ListaProductosCar() {
	}

	public List<ProductoCar> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoCar> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "ListaProductosCar [productos=" + productos + "]";
	}
	
}
