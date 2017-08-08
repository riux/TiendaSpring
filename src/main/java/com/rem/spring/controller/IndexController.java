package com.rem.spring.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rem.spring.constant.ViewConstant;
import com.rem.spring.entity.CategoriaProducto;
import com.rem.spring.entity.Producto;
import com.rem.spring.service.CategoriaService;
import com.rem.spring.service.ProductoService;

@Controller
//@PreAuthorize("permitAll()")
@RequestMapping("/")
public class IndexController {

	
	private static final Log LOG = LogFactory.getLog(ProductoController.class);
	
	@Autowired
	@Qualifier("productoServiceImpl")
	private ProductoService productoService;
	
	@Autowired
	@Qualifier("categoriaProductoImpl")
	private CategoriaService categoriaService;
	
	
	//@PreAuthorize("permitAll()")
	@GetMapping("/index")
	public ModelAndView Index(@RequestParam(name="categoria", required=false) CategoriaProducto categoria ) {
		ModelAndView mav = new ModelAndView(ViewConstant.INDEX);
		mav.addObject("categorias", categoriaService.findAllCategoria());
		
		if (categoria != null) {
			mav.addObject("productos", productoService.findProductoByCategoria(categoria));
			return mav;
		}
		else {
		/*	List<Producto> productos = productoService.findProductoByCategoria(categoriaService.finCategoriaById(6));
			for (Producto producto : productos) {
				LOG.info("METODO: run() -- PARAMETORS :  "+ producto.toString());
				*/
			mav.addObject("productos", productoService.listarProductos());
			return mav;
			}
			
		}
		
		
	
}
