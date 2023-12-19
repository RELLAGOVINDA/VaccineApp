package com.tap.vaccination.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccination.entity.RegisterEntity;

@Component
public class ResetPasswordDAOImpl implements ResetPasswordDAO{
	
	private SessionFactory sessionFactory;
	private JavaMailSenderImpl javaMailSenderImpl;
	
	@Autowired
	public ResetPasswordDAOImpl(SessionFactory sessionFactory,JavaMailSenderImpl javaMailSenderImpl) {
		this.sessionFactory = sessionFactory;
		this.javaMailSenderImpl = javaMailSenderImpl;
	}

	public boolean updatePasswordByEmail(String email, String password) {
		System.out.println("invoked updatePasswordByEmail() in ResetPasswordDAOImpl class");
		Session session = null;
		Transaction transaction = null;
		RegisterEntity entity = null;
		Query query = null;
		boolean isUpdate = false;
		String hql = "from RegisterEntity where email='"+email+"'";
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery(hql);
			entity = (RegisterEntity)query.uniqueResult();
			entity.setLoginAttempts(0);
			entity.setPassword(password);
			transaction.commit();
			isUpdate = true;
			
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		if(isUpdate) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(email);
			mailMessage.setSubject("PASSWORD RESET SUCCESSFULL");
			mailMessage.setText("dear "+entity.getUserName() + " your password sucessfully "
					+ "update please use these crendentials to login into your account"
					+" emailId: "+email+" password: "+password);
			javaMailSenderImpl.send(mailMessage);
			System.out.println("mail successfully sent");
			return isUpdate;
		}
		return isUpdate;
	}
	
	
}
