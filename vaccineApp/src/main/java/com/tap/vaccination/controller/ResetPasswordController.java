package com.tap.vaccination.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.vaccination.service.ResetPasswordService;

@Controller
public class ResetPasswordController {
	
	private ResetPasswordService resetPasswordService;

	@Autowired
	public ResetPasswordController(ResetPasswordService resetPasswordService) {
		this.resetPasswordService = resetPasswordService;
	}
	
	@RequestMapping("/getResetPasswordPage")
	public String getResetPasswordPage() {
		return "/WEB-INF/resetPassword.jsp";
	}
	
	@RequestMapping("/resetPasswordrequestHandler")
	public String resetPassword(@RequestParam String email,
			@RequestParam String password,@RequestParam String confirmpassword,Model model) {
		System.out.println("invoked resetPassword() in ResetPasswordController class");
		boolean isValid = false;
		try {
			isValid = resetPasswordService.validatePasswordDetails(email, password, confirmpassword);
			if(isValid) {
				boolean isUpdate = resetPasswordService.updatePasswordByEmail(email, confirmpassword);
				if(isUpdate)
					model.addAttribute("update", "Your Password is reset successfully");
				else
					model.addAttribute("update", "Your Password is not reset try again...");
			}else {
				model.addAttribute("update", "invalid User Details try again...");
			}
		} catch (Exception e) {
			model.addAttribute("update", e.getMessage());
		} 
		
		return "/WEB-INF/resetPassword.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
