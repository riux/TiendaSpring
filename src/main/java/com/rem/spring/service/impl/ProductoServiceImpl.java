package com.rem.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rem.spring.entity.CategoriaProducto;
import com.rem.spring.entity.Producto;
import com.rem.spring.repository.ProductoRepository;
import com.rem.spring.service.ProductoService;

@Service("productoServiceImpl")
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	@Qualifier("productoRepository")
	private ProductoRepository productoRepository;
	
	@Override
	public Producto agregarProducto(Producto producto) {
		Producto producto1 = productoRepository.save(producto);
		return producto1;
	}

	@Override
	public List<Producto> listarProductos() {
		List<Producto> productos = productoRepository.findAll();
		return productos;
	}

	@Override
	public void eliminarProducto(int id) {
		
		Producto producto = findProductoById(id);
		if (producto != null) {
			productoRepository.delete(producto);
		}
	}

	@Override
	public Producto findProductoById(int id) {
		Producto producto = productoRepository.findById(id);
		return producto;
	}

	@Override
	public List<Producto> findProductoByCategoria(CategoriaProducto categoria) {
		List<Producto> productos = productoRepository.findByCategoria(categoria);
		return productos;
	}
	
	

}
