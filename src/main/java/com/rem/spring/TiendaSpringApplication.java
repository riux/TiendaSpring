package com.rem.spring;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rem.spring.controller.CategoriaController;
import com.rem.spring.entity.Producto;
import com.rem.spring.service.impl.CategoriaServiceImpl;
import com.rem.spring.service.impl.FileUploadService;
import com.rem.spring.service.impl.ProductoServiceImpl;

@SpringBootApplication
public class TiendaSpringApplication  implements CommandLineRunner{

	@Resource()
	FileUploadService fileUploadService;
//	prueba mostrar porudcto por catefgoria inicio

	
	private static final Log LOG = LogFactory.getLog(CategoriaController.class);
	
	
//	prueba fin
	
	public static void main(String[] args) {
		SpringApplication.run(TiendaSpringApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		
//		fileUploadService.deleteAll();
//		fileUploadService.init();
		
	}
}
