package com.tap.vaccination.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccination.entity.RegisterEntity;

@Component
public class RegisterDAOImpl implements RegisterDAO{

	private SessionFactory sessionFactory;
	
	private JavaMailSenderImpl javaMailSenderImpl;

	@Autowired
	public RegisterDAOImpl(SessionFactory sessionFactory,JavaMailSenderImpl javaMailSenderImpl) {
		this.sessionFactory = sessionFactory;
		this.javaMailSenderImpl = javaMailSenderImpl;
		System.out.println("SessionFactory successffully injected by SpringMVC");
	}
	
	
	public boolean saveRegisterEntity(RegisterEntity registerEntity) {
		System.out.println("invoked saveRegisterEntity() in RegisterDAOImpl Class");
		Session session =null;
		Transaction transaction=null;
		boolean isDataSaved = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			registerEntity.setLoginAttempts(0);
			session.save(registerEntity);
			transaction.commit();
			isDataSaved = true;
		} catch (HibernateException hibernateException) {
			transaction.rollback();
			System.out.println("transaction is rollback : "+hibernateException);
		}finally {
				if(session!=null) {
					session.close();
					System.out.println("session is closed");
				}
			
		}
		
		if(isDataSaved) {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(registerEntity.getEmail());
			simpleMailMessage.setSubject("Registration successfull");
			simpleMailMessage.setText("Dear "+registerEntity.getUserName()+" " + "registration successfull,"
					+ " using this credential  to login vaccination App  Username: "
					+ ""+registerEntity.getEmail()+" Password "+registerEntity.getPassword());
			
			try {
				javaMailSenderImpl.send(simpleMailMessage);
				isDataSaved = true;
				return isDataSaved;
			} catch (MailException e) {
				isDataSaved = false;
				System.out.println(e.getMessage()); 
				System.out.println("something went wrong");
			}
		}
		return isDataSaved;
	}

}
