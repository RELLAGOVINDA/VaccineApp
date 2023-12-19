package com.tap.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccination.service.LoginService;

@Controller
public class LoginController {
	
	
	private LoginService loginService;
	public static String email = null;
	
	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	
	public LoginController() {
	}


	@RequestMapping("/getLoginPage")
	public String getLoginPage() {
		return "/WEB-INF/login.jsp";
	}
	
	
	@RequestMapping("/userlogin")
	public String loginDetails(@RequestParam String email,@RequestParam String password,Model model) {
		boolean isValid = loginService.validateLoginDetails(email, password);
		if(isValid) {
			this.email = email;
			model.addAttribute("email",email);
			model.addAttribute("memberCount",loginService.getMemberCountByEmail(email));
			
			return "/WEB-INF/home.jsp";
		}else {
			model.addAttribute("coupling","loginDetails invalid");
			return "/WEB-INF/login.jsp";
		}
		
	}
}
