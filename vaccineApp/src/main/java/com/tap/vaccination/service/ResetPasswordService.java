package com.tap.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccination.dao.ResetPasswordDAO;

@Component
public class ResetPasswordService {
	
	private ResetPasswordDAO resertPasswordDAO;
	
	@Autowired
	public ResetPasswordService(ResetPasswordDAO resertPasswordDAO) {
		this.resertPasswordDAO = resertPasswordDAO;
	}
	
	
	public boolean validatePasswordDetails(String email,String password,String confirmpassword) throws  Exception{
		boolean isValid = false;
		if(email.isBlank() || email.isEmpty() || email == null)
			throw new Exception("enter valid email");
		if(password.isBlank() || password.isEmpty() || password == null) 
			throw new Exception("enter valid password");
		if(confirmpassword.isBlank() || confirmpassword.isEmpty() || confirmpassword == null) 
			throw new Exception("enter valid confirmpassword");
		if(!password.equals(confirmpassword))
			throw new Exception("password and confirmpassword should be same");
		
		isValid = true;
		return isValid;
	}
	
	public boolean updatePasswordByEmail(String email,String password) {
		return resertPasswordDAO.updatePasswordByEmail(email, password);
	}
	
	
	
	
	
	
}
