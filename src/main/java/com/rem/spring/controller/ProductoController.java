package com.rem.spring.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.rem.spring.service.CategoriaService;
import com.rem.spring.service.ProductoService;
import com.rem.spring.service.impl.FileUploadService;

@Controller
@PreAuthorize("permitAll()")
@RequestMapping("/producto")
public class ProductoController {

	private static final Log LOG = LogFactory.getLog(ProductoController.class);
	
	@Autowired
	@Qualifier("fileUploadService")
	private FileUploadService fileUploadService;
	
	@Autowired
	@Qualifier("productoServiceImpl")
	private ProductoService productoService;
	
	@Autowired
	@Qualifier("categoriaProductoImpl")
	private CategoriaService categoriaService;
	
	
	@GetMapping("/agregarform")
	public String redirectProductoForm( @RequestParam(name="id", required=false)int id, Model model) {
		LOG.info("METODO: redirectProductoForm(() -- PARAMETORS : ");
		
		Producto producto = new Producto();
		if (id != 0) {
			 producto = productoService.findProductoById(id);
		}
		model.addAttribute("producto", producto);
		model.addAttribute("categorias", categoriaService.findAllCategoria());
		return ViewConstant.PRODUCTO_AGREGAR;
	}
	
	
	@PostMapping("/agregar")
	public String agregarProducto(@ModelAttribute(name="producto") Producto producto,
							     @RequestParam("imagen") MultipartFile imagen,
								  Model model) {
		
		producto.setImagenUrl(fileUploadService.store(imagen));
		producto.setProest(true);
		LOG.info("METODO: agregarProducto() -- PARAMETORS : " +producto.toString());
		
		if (productoService.agregarProducto(producto)!= null) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		
		return "redirect:/producto/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView listarProductos() {
		ModelAndView mav = new ModelAndView(ViewConstant.PRODUCTO_LISTAR);
		
//		User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		mav.addObject("usuario", usuario.getUsername());
		
		mav.addObject("productos", productoService.listarProductos());	
		return mav;
	}
	
	@GetMapping("/eliminar")
	public ModelAndView eliminarProducto(@RequestParam(name="id", required=true)int id) {
		productoService.eliminarProducto(id);
		return listarProductos();
	}
	
//	@ModelAttribute("categorias")
//	public List<CategoriaProducto> categorias() {
//		return categoriaService.findAllCategoria();
//	}
}
