package com.rem.spring.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rem.spring.entity.CategoriaProducto;

@Repository("categoriaRepository")
public interface CategoriaRepository extends JpaRepository<CategoriaProducto, Serializable>{

	public abstract CategoriaProducto findById(int id);
	
}
