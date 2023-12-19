package com.tap.vaccination.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	
	@GetMapping("/logout")
	public String logout()  {
		
		return "/WEB-INF/login.jsp";
	}
}
