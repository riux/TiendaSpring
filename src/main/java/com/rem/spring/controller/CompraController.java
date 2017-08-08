package com.rem.spring.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rem.spring.entity.Producto;
import com.rem.spring.entity.Usuario;
import com.rem.spring.model.ListaProductosCar;
import com.rem.spring.model.ProductoCar;
import com.rem.spring.service.CategoriaService;
import com.rem.spring.service.ProductoService;
import com.rem.spring.service.impl.UsuarioServiceImpl;

@Controller
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	@Qualifier("productoServiceImpl")
	private ProductoService productoService;
	
	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioServiceImpl usuarioServiceImpl;

	private static final Log LOG = LogFactory.getLog(CategoriaController.class);
	
	//@PreAuthorize("permitAll()")
	@GetMapping("/carshop")
	public String verificarCarShop() {

		return "compra/carshop";
	}
	
	
	@GetMapping("/comprar")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ModelAndView comprarCarShop() {
		
		ModelAndView mav =  new ModelAndView("compra/comprar");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String nombre = user.getUsername();
		Usuario usuario = usuarioServiceImpl.findUsuarioByName(nombre);
		
		mav.addObject("nombre", nombre);
		mav.addObject("puntos", usuario.getPuntos());
		mav.addObject("usuario", usuario);
		
		return mav;
	}
	//@PreAuthorize("permitAll()")
	@PostMapping("/pago")
	public void pago(@RequestBody List<ProductoCar> productos) {
		
		LOG.info("PAGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO ");
		
		Producto producto = new Producto();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String nombre = user.getUsername();
		Usuario usuario = usuarioServiceImpl.findUsuarioByName(nombre);
		double puntos = usuario.getPuntos();
		double punt = 0;
		for (ProductoCar productoCar : productos) {
			producto = productoService.findProductoById(productoCar.getId());
			double nuevoStock = producto.getStock() - Double.parseDouble(productoCar.getCantidad());
			punt +=  producto.getPropre();
			producto.setStock(nuevoStock);
			
			if (productoService.agregarProducto(producto) != null) {
				LOG.info("METHOD: SE REALIZO LA COMPRA   ");
				
			} else {
				LOG.info("METHOD: SE REALIZO LA COMPRA   ");
			}
		}
		LOG.info("valor : VALOR PUT   " + punt);
		usuario.setPuntos(puntos-punt);
		usuarioServiceImpl.agregarUsuario(usuario);

	}
	//@PreAuthorize("permitAll()")
	@GetMapping("/success")
	public ModelAndView success() {
		ModelAndView mav = new ModelAndView();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String nombre = user.getUsername();
		Usuario usuario = usuarioServiceImpl.findUsuarioByName(nombre);
		
		mav.addObject("nombre", nombre);
		mav.addObject("puntos", usuario.getPuntos());
		mav.addObject("usuario", usuario);
		return mav;
	}

}
