package com.tap.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccination.service.RegisterService;

@Controller
public class RegisterController {

private RegisterService registerService;
	
	@Autowired
	public RegisterController(RegisterService registerService) {
		this.registerService = registerService;
		System.out.println("RegisterService successfully injected");
	}


	@RequestMapping("/getRegisterPage")
	public String getRegisterPage() {
		return "/WEB-INF/register.jsp";
	}
	
	@RequestMapping("/saveUserDetails")
	public String registerUserDetails(@RequestParam String userName,@RequestParam String email,
									@RequestParam String mobileNumber,@RequestParam String dob,
									@RequestParam String gender,@RequestParam String passwword,
									@RequestParam String confirmPasswword,Model model) {
		System.out.println("invoked registerUserDetails() in RegisterController class");
		
		boolean isValid = registerService.validateRegisterUserDetails(userName, email, mobileNumber, dob,
													gender, passwword, confirmPasswword);
		if(isValid) {
			System.out.println("datavalid");
			boolean isDataSave = registerService.saveRegisterEntity(userName, email, mobileNumber, dob, gender, passwword, confirmPasswword);
			if(isDataSave) {
				model.addAttribute("save","Registration Successfull");
			}else {
				model.addAttribute("save","Registration not Successfull");
			}
		}else {
			model.addAttribute("save","invalid Register Details...");
		}
		
		return "/WEB-INF/register.jsp";
	}
}
