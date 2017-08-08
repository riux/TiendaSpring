package com.rem.spring.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomResourceConfiguration extends WebMvcConfigurerAdapter{

	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        //registry.addResourceHandler("/pro/**").addResourceLocations("file:/home/riux/Riux/Proyectos Eclipse/TiendaSpring/pro/");
	    }
}
