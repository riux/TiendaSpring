package com.rem.spring.service;

import java.util.List;

import com.rem.spring.entity.CategoriaProducto;
import com.rem.spring.entity.Producto;

public interface ProductoService {
	
	public abstract Producto agregarProducto(Producto producto);
	
	public abstract List<Producto> listarProductos();
	
	public abstract void eliminarProducto(int id);
	
	public abstract Producto findProductoById(int id);
	
	public abstract List<Producto> findProductoByCategoria(CategoriaProducto categoria);
	

}
