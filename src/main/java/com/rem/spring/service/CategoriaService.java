package com.rem.spring.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.rem.spring.entity.CategoriaProducto;
import com.rem.spring.model.CategoriaProductoModel;
//@PreAuthorize("permitAll()")
public interface CategoriaService {
	
	public abstract CategoriaProductoModel agregarCategoriaProducto(CategoriaProductoModel categoriaModel);

	public abstract List<CategoriaProductoModel> listarCategoria();
	
	public abstract CategoriaProducto finCategoriaById(int id);
	
	public abstract void removeCategoria(int id);
	
	public abstract CategoriaProductoModel findCategoriaByIdModel(int id);
	
	public abstract List<CategoriaProducto> findAllCategoria();
}
