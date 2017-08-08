package com.rem.spring.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rem.spring.entity.Producto;
import com.rem.spring.model.ListaProductosCar;
import com.rem.spring.model.ProductoCar;
import com.rem.spring.service.ProductoService;

@Controller
@RequestMapping("/compra")
public class CompraController {

	@Autowired
	@Qualifier("productoServiceImpl")
	private ProductoService productoService;

	private static final Log LOG = LogFactory.getLog(CategoriaController.class);

	@GetMapping("/carshop")
	public String indexCarShop() {

		return "compra/carshop";
	}

	@PostMapping("/pago")
	public void pago(@RequestBody List<ProductoCar> productos) {
		Producto producto = new Producto();
		for (ProductoCar productoCar : productos) {
			producto = productoService.findProductoById(productoCar.getId());
			double nuevoStock = producto.getStock() - Double.parseDouble(productoCar.getCantidad());
			producto.setStock(nuevoStock);
			if (productoService.agregarProducto(producto) != null) {
				LOG.info("METHOD: SE REALIZO LA COMPRA   ");
				
			} else {
				LOG.info("METHOD: SE REALIZO LA COMPRA   ");
			}
		}

	}
	
	@GetMapping("/success")
	public String success() {

		return "compra/success";
	}

}
