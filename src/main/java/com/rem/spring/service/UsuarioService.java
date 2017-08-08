package com.rem.spring.service;

import com.rem.spring.entity.Producto;
import com.rem.spring.entity.Usuario;

public interface UsuarioService {

	public abstract Usuario agregarUsuario(Usuario usuario);

	public abstract void eliminarUsuario(int id);

	public abstract Usuario findUsuarioById(int id);
	
	public abstract Usuario findUsuarioByName(String name);


}
