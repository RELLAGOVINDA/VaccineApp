package com.tap.vaccination.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.tap.vaccination.entity.RegisterEntity;

@Component
public class LoginDAOImpl implements LoginDAO {
	
	private SessionFactory sessionFactory;
	
	
	@Autowired
	public LoginDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	public RegisterEntity getRegisterEntityByEmail(String email) {
		Session session = null;
		Query query = null;
		Transaction transaction = null;
		RegisterEntity entity = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("from RegisterEntity where email='"+email+"'");
			entity = (RegisterEntity)query.uniqueResult();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return entity;
	}



	public void updateRegisterEntityByEmail(String email,int loginAttempts) {
		Session session = null;
		Query query = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("update RegisterEntity set loginAttempts = '"+loginAttempts+"' where email='"+email+"'");
			query.executeUpdate();
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	}
	
	public int getMemberCountByEmail(String email) {
		Session session = null;
		Query query = null;
		RegisterEntity entity = null;
		int memberCount = -1;
		try {
			session = sessionFactory.openSession();
			query = session.createQuery("from RegisterEntity  where email='"+email+"'");
			entity = (RegisterEntity)query.uniqueResult();
			memberCount = entity.getMemberCount();
			return memberCount;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(session != null)
				session.close();
		}
		return memberCount;
	}

}
