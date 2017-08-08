package com.rem.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rem.spring.converter.CategoriaConverter;
import com.rem.spring.entity.CategoriaProducto;
import com.rem.spring.model.CategoriaProductoModel;
import com.rem.spring.repository.CategoriaRepository;
import com.rem.spring.service.CategoriaService;

@Service("categoriaProductoImpl")
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	@Qualifier("categoriaRepository")
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	@Qualifier("categoriaConverter")
	private CategoriaConverter categoriaConverter;

	@Override
	public CategoriaProductoModel agregarCategoriaProducto(CategoriaProductoModel categoriaModel) {
		CategoriaProducto categoriaProducto = categoriaRepository.save(categoriaConverter.converterCategoriaModel2CategoriaProducto(categoriaModel));
		return categoriaConverter.converterCategoriaProducto2CategoriaProductoModel(categoriaProducto);
	}

	@Override
	public List<CategoriaProductoModel> listarCategoria() {
		List<CategoriaProducto> categorias = categoriaRepository.findAll();
		List<CategoriaProductoModel> categoriasModel = new ArrayList<CategoriaProductoModel>();
		
		for(CategoriaProducto categoria : categorias) {
			categoriasModel.add(categoriaConverter.converterCategoriaProducto2CategoriaProductoModel(categoria));
		}
		
		return categoriasModel;
	}

	@Override
	public CategoriaProducto finCategoriaById(int id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public void removeCategoria(int id) {
		CategoriaProducto categoriaProducto = finCategoriaById(id);
		if (categoriaProducto != null) {
			categoriaRepository.delete(categoriaProducto);
		}
		
	}

	@Override
	public CategoriaProductoModel findCategoriaByIdModel(int id) {
		
		return categoriaConverter.converterCategoriaProducto2CategoriaProductoModel(finCategoriaById(id));
	}

	@Override
	public  List<CategoriaProducto> findAllCategoria() {
		List<CategoriaProducto> categorias = categoriaRepository.findAll();
		return categorias;
	}

}
