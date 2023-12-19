package com.tap.vaccination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccination.dao.LoginDAO;
import com.tap.vaccination.entity.RegisterEntity;

@Component
public class LoginService {
	private LoginDAO loginDao;
	
	private JavaMailSenderImpl javaMailSenderImpl;
	
	@Autowired
	public LoginService(LoginDAO loginDao,JavaMailSenderImpl javaMailSenderImpl) {
		this.loginDao = loginDao;
		this.javaMailSenderImpl = javaMailSenderImpl;
	}
	
	public boolean validateLoginDetails(String email,String password) {
		boolean isValid = false;
		RegisterEntity entity = loginDao.getRegisterEntityByEmail(email);
		
		if(entity != null ) {
			if(entity.getLoginAttempts()<=2) {
				if(entity.getEmail().equals(email) && entity.getPassword().equals(password)) {
					loginDao.updateRegisterEntityByEmail(email,0);
					isValid = true;
					return isValid;
				}else if(entity.getLoginAttempts()<2){
					System.out.println("invalid login deatails ");
					loginDao.updateRegisterEntityByEmail(email,entity.getLoginAttempts()+1);
					isValid = false;
					return isValid;
				}else {
					System.out.println("email sending activity invoked");
					loginDao.updateRegisterEntityByEmail(email,entity.getLoginAttempts()+1);
					SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
					simpleMailMessage.setTo(entity.getEmail());
					simpleMailMessage.setSubject("EXCEED LOGIN ATTEMPTS ");
					simpleMailMessage.setText("Dear "+entity.getUserName()+", " + " YOU ARE BLOCKED, PLEASE RESET YOUR PASSWORD ");
					
					try {
						javaMailSenderImpl.send(simpleMailMessage);
					} catch (MailException e) {
						System.out.println(e.getMessage()); 
						System.out.println("something went wrong");
					}
				}
			}
		}
		
		return isValid;
	}
	public int getMemberCountByEmail(String email) {
		return loginDao.getMemberCountByEmail(email);
	}
}
