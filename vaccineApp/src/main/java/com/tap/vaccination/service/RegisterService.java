package com.tap.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccination.dao.RegisterDAO;
import com.tap.vaccination.entity.RegisterEntity;

@Component
public class RegisterService {
	private RegisterDAO registerDAO;
	
	
	@Autowired
	public RegisterService(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
		System.out.println("RegisterDAO successfully injected");
	}
	
	public boolean validateRegisterUserDetails(String userName,String email,String mobileNumber,
			String dob,String gender,String passwword,
			String confirmPasswword) {
		System.out.println("validateRegisterUserDetails() in RegisterService class" );
		boolean isValid = false;
		if(userName!=null && !userName.isBlank() && !userName.isEmpty() && userName.length()>2) {
			isValid = true;
		}else {
			isValid = false;
			return isValid;
		}
		if(email!=null && !email.isBlank() && !email.isEmpty()) {
			isValid = true;
		}else {
			isValid = false;
			return isValid;
		}
		if(mobileNumber!=null && !mobileNumber.isBlank() && !mobileNumber.isEmpty() ) {
			isValid = true;
		}else {
			isValid = false;
			return isValid;
		}
		if(dob!=null && !dob.isBlank() && !dob.isEmpty() ) {
			isValid = true;
		}else {
			isValid = false;
			return isValid;
		}
		if(gender!=null && !gender.isBlank() && !gender.isEmpty() ) {
			isValid = true;
		}else {
			isValid = false;
			return isValid;
		}
		if(passwword.equals(confirmPasswword)) {
			isValid=true;
		}else {
			isValid = false;
			return isValid;
		}
			
		return isValid;
	}
	
	public boolean saveRegisterEntity(String userName,String email,String mobileNumber,
									String dob,String gender,String passwword,
									String confirmPasswword) {
		System.out.println("saveRegisterEntity()in RegisterService class");
		RegisterEntity entity = new RegisterEntity(userName, email, mobileNumber, gender, dob, confirmPasswword);
		return registerDAO.saveRegisterEntity(entity);
	}
}
