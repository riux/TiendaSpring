package com.rem.spring.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rem.spring.entity.CategoriaProducto;
import com.rem.spring.entity.Producto;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Serializable> {

	public abstract Producto findById(int id);
	
	public abstract List<Producto> findByCategoria(CategoriaProducto categoria);
}
