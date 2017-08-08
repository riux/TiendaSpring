package com.rem.spring.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rem.spring.entity.Rol;
import com.rem.spring.entity.Usuario;
import com.rem.spring.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioService  implements UserDetailsService {

	
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNombreUsuario(nombre);
		List<GrantedAuthority> authorities = buildAuthority(usuario.getRol());
		return buildUsuario(usuario, authorities);
	}
	
	private User buildUsuario(Usuario usuario, List<GrantedAuthority> authorities) {
		return new User(usuario.getNombreUsuario(), usuario.getContrasenia(), usuario.isEstado(), true, true, true, authorities);
	}
	
	private List<GrantedAuthority> buildAuthority(Set<Rol> roles){
		GrantedAuthority authority;
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		for (Rol rol : roles) {
			authorities.add(new SimpleGrantedAuthority(rol.getNombre()));
		}
		return new ArrayList<GrantedAuthority>(authorities);
	}
	
	

}
