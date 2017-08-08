package com.rem.spring.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.rem.spring.constant.ViewConstant;
import com.rem.spring.entity.Producto;
import com.rem.spring.entity.Usuario;
import com.rem.spring.service.CategoriaService;
import com.rem.spring.service.ProductoService;
import com.rem.spring.service.impl.FileUploadService;
import com.rem.spring.service.impl.UsuarioServiceImpl;

@Controller
//@PreAuthorize("permitAll()")
@RequestMapping("/usuario")
public class UsuarioController {
	

		private static final Log LOG = LogFactory.getLog(ProductoController.class);
		
		@Autowired
		@Qualifier("usuarioServiceImpl")
		private UsuarioServiceImpl usuarioServiceImpl;
		private BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		
		@GetMapping("/usuarioform")
		public String redirectUsuarioForm(Model model) {
			LOG.info("METODO: redirectUsuarioForm() -- PARAMETORS : ");
			
			Usuario usuario = new Usuario();
			
			model.addAttribute("usuario", usuario);
			return "usuario/agregar";
		}
		
		@PostMapping("/agregar")
		public String agregarUroducto(@ModelAttribute(name="usuario") Usuario usuario,
									  Model model) {
			
			usuario.setContrasenia(pe.encode(usuario.getContrasenia()));
			usuario.setEstado(true);
			LOG.info("METODO: agregarUroducto() -- PARAMETORS : " +usuario.toString());
			
			if (usuarioServiceImpl.agregarUsuario(usuario)!= null) {
				model.addAttribute("result", 1);
			} else {
				model.addAttribute("result", 0);
			}
			
			return "redirect:/index";
		}
		
		
		
	}

