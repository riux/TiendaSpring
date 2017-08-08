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
import org.springframework.web.servlet.ModelAndView;

import com.rem.spring.constant.ViewConstant;
import com.rem.spring.model.CategoriaProductoModel;
import com.rem.spring.service.CategoriaService;

@Controller
@PreAuthorize("hasRole('admin')")
@RequestMapping("/categoria")
public class CategoriaController {
	
	private static final Log LOG = LogFactory.getLog(CategoriaController.class);
	
	@Autowired
	@Qualifier("categoriaProductoImpl")
	private CategoriaService categoriaService;
	
	@GetMapping("/listarc")
	public String redirectListar() {
		return ViewConstant.CATEGORIA_LISTAR;
	}
	
	
	@GetMapping("/agregarform")
	public String redirectCategoriaForm( @RequestParam(name="id", required=false)int id, Model model) {
		
		CategoriaProductoModel categoriaProductoModel = new CategoriaProductoModel();
		if (id != 0) {
			categoriaProductoModel = categoriaService.findCategoriaByIdModel(id);
		}
		
		model.addAttribute("categoriaModel", categoriaProductoModel);
		return ViewConstant.CATEGORIA_AGREGAR;
	}
	
	@PostMapping("/agregar")
	public String agregarCategoria(@ModelAttribute(name="categoriaModel") CategoriaProductoModel categoriaProductoModel,
									Model model) {
		categoriaProductoModel.setEstado(true);
		LOG.info("METHOD: agregarCategoria() -- PARAMS: " +categoriaProductoModel.toString());
		
		if (categoriaService.agregarCategoriaProducto(categoriaProductoModel)!= null) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		
		return "redirect:/categoria/listar";
	}
	
	@GetMapping("/listar")
	public ModelAndView listarCategorias() {
		ModelAndView mav = new ModelAndView(ViewConstant.CATEGORIA_LISTAR);
		
//		User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		mav.addObject("usuario", usuario.getUsername());
		
		mav.addObject("categorias", categoriaService.listarCategoria());	
		return mav;
	}
	
	@GetMapping("/eliminar")
	public ModelAndView eliminarCategoria(@RequestParam(name="id", required=true)int id) {
		categoriaService.removeCategoria(id);
		return listarCategorias();
	}
	

}
