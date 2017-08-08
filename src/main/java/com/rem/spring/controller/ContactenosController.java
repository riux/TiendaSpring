package com.rem.spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("permitAll()")
@RequestMapping("/contacto")
public class ContactenosController {

	@GetMapping("/contactenos")
	public String contactenos() {
		return "/contacto/contactenos";
	}
	
}
