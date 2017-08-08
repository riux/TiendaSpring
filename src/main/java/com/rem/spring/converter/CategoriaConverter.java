package com.rem.spring.converter;

import org.springframework.stereotype.Component;

import com.rem.spring.entity.CategoriaProducto;
import com.rem.spring.model.CategoriaProductoModel;

@Component("categoriaConverter")
public class CategoriaConverter {
	
	public CategoriaProducto converterCategoriaModel2CategoriaProducto(CategoriaProductoModel categoriaModel) {
		CategoriaProducto categoriaProducto = new CategoriaProducto();
		
		categoriaProducto.setId(categoriaModel.getId());
		categoriaProducto.setNombre(categoriaModel.getNombre());
		categoriaProducto.setEstado(categoriaModel.isEstado());
		
		return categoriaProducto;
	}
	
	public CategoriaProductoModel converterCategoriaProducto2CategoriaProductoModel(CategoriaProducto categoriaProducto) {
		CategoriaProductoModel categoriaProductoModel = new CategoriaProductoModel();
		
		categoriaProductoModel.setId(categoriaProducto.getId());
		categoriaProductoModel.setNombre(categoriaProducto.getNombre());
		categoriaProductoModel.setEstado(categoriaProducto.isEstado());
		
		return categoriaProductoModel;
	}

}
