package com.rem.spring.service.impl;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import com.rem.spring.entity.Producto;

@Service("productoFormatter")
public class ProductoFormatter implements Formatter<Producto>{

	@Autowired
	@Qualifier("productoServiceImpl")
	ProductoServiceImpl productosSrvice;

	@Override
	public String print(Producto producto, Locale local) {
		 return (producto != null ? producto.getId().toString() : "");
	}

	@Override
	public Producto parse(String text, Locale local) throws ParseException {
		 Integer id = Integer.valueOf(text);
	     return this.productosSrvice.findProductoById(id);
	}

	
}