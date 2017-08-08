package com.rem.spring.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.rem.spring.component.RequestTimeInterceptor;
import com.rem.spring.service.impl.CategoriaFormatter;
import com.rem.spring.service.impl.ProductoFormatter;

@Configuration
@ComponentScan(value = { "com.rem.spring.*" })
public class WebMvcComfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterceptor requestTimeInterceptor;

	@Autowired
	@Qualifier("categoriaFormatter")
	CategoriaFormatter categoriaFormatter;

	@Autowired
	@Qualifier("productoFormatter")
	ProductoFormatter productoFormatter;

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(categoriaFormatter);
		registry.addFormatter(productoFormatter);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestTimeInterceptor);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**");
	}

}
