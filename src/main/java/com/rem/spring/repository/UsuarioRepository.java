package com.rem.spring.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rem.spring.entity.Producto;
import com.rem.spring.entity.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{
	
	public abstract Usuario findById(int id);
	public abstract Usuario findByNombreUsuario(String nombre);
}
