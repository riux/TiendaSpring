package com.rem.spring.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rem.spring.constant.ViewConstant;

@Controller
@RequestMapping("/login")
public class LoginController {

	public static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/login")
	public String showLoginForm(Model model,
								@RequestParam(name="error", required= false) String error,
								@RequestParam(name="logout", required= false) String logout) {
		LOG.info("METHOD: showLoginForm() -- PARAMS: error " +error+ ", logout "+logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Redirect a login");
		return ViewConstant.LOGIN;
	}
	
	@GetMapping("/validar")
	public String loginCheck() {
		LOG.info("METHOD: loginCheck()  ");
		LOG.info("Redirect a listar categorias");
		return "redirect:/producto/listar";
		
	}
	
	
	
}
