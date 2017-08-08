package com.rem.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rem.spring.entity.Producto;
import com.rem.spring.entity.Usuario;
import com.rem.spring.repository.ProductoRepository;
import com.rem.spring.repository.UsuarioRepository;
import com.rem.spring.service.UsuarioService;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario agregarUsuario(Usuario usuario) {
		Usuario usuario1 = usuarioRepository.save(usuario);
		return usuario;
	}

	@Override
	public void eliminarUsuario(int id) {
		Usuario usuario = findUsuarioById(id);
		if (usuario != null) {
			usuarioRepository.delete(usuario);
		}
	}

	@Override
	public Usuario findUsuarioById(int id) {
		Usuario usuario = usuarioRepository.findById(id);
		return usuario;
	}

	@Override
	public Usuario findUsuarioByName(String name) {
		Usuario usuario = usuarioRepository.findByNombreUsuario(name);
		return usuario;
	}
	

}
