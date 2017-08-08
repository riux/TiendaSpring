package com.rem.spring.service.impl;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import com.rem.spring.entity.CategoriaProducto;

@Service("categoriaFormatter")
public class CategoriaFormatter implements Formatter<CategoriaProducto>{

	@Autowired
	@Qualifier("categoriaProductoImpl")
	CategoriaServiceImpl categoriaService;
	
	@Override
	public String print(CategoriaProducto categoria, Locale locale) {
		return (categoria != null ? categoria.getId().toString() : "");
	}

	@Override
	public CategoriaProducto parse(String text, Locale arg1) throws ParseException {
		Integer id = Integer.valueOf(text);
        return this.categoriaService.finCategoriaById(id);//return Type object form DB
	}
	
	
}