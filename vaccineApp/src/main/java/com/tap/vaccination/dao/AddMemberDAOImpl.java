package com.tap.vaccination.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vaccination.entity.MemberTableEntity;
import com.tap.vaccination.entity.RegisterEntity;

@Component
public class AddMemberDAOImpl implements AddMemberDAO{
	
	private SessionFactory sessionFactory;
	
	
	@Autowired
	public AddMemberDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	public boolean saveMemberEntity(MemberTableEntity memberTableEntity) {
		boolean isDataSave = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(memberTableEntity);
			transaction.commit();
			isDataSave = true;
		} catch (HibernateException e) {
			transaction.rollback();
			System.out.println("transaction rollback "+e.getMessage());
		} finally {
			if(session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		
		return isDataSave;
	}
	public List<MemberTableEntity> getAll(String email) {
		System.out.println("invoked getAll()  in dao class");
		Session session = null;
		Query query = null;
		List<MemberTableEntity> list = null;
		try {
			session = sessionFactory.openSession();
			query = session.createQuery("from MemberTableEntity where userEmail='"+email+"' ");
			list = query.getResultList();
			return list;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return list;
	}
	
	public boolean updateMemberCountByEmail(String email) {
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		boolean isUpdate = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("from RegisterEntity  where email='"+email+"'");
			RegisterEntity entity = (RegisterEntity)query.uniqueResult();
			entity.setMemberCount(entity.getMemberCount()+1);
			transaction.commit();
			isUpdate = true;
			return isUpdate;
			
		} catch (HibernateException e) {
			transaction.rollback();
			System.out.println(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return isUpdate;
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
	
	
	
	
	public MemberTableEntity getMemberEntityByIdProofNumber(String idProofNumber) {
		Session session = null;
		Query query = null;
		MemberTableEntity entity = null;
		try {
			session = sessionFactory.openSession();
			query = session.createQuery("from MemberTableEntity where idProofNumber='"+idProofNumber+"'");
			entity = (MemberTableEntity)query.uniqueResult();
			return entity;
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return entity;
	}
	
	public boolean updateMemberEntity(MemberTableEntity memberTableEntity) {
		boolean isDataUpdate = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(memberTableEntity);
			transaction.commit();
			isDataUpdate = true;
			return isDataUpdate;
		} catch (Exception e) {
			transaction.rollback();
			System.out.println("transaction is rollback "+ e.getMessage());
		} finally {
			if(session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return isDataUpdate;
	}
	
	
	public int deleteMemberEntityByIdNumber(String IdNumber) {
		Session session = null;
		Transaction transaction = null;
		Query query = null;
		int value = -1;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			query = session.createQuery("delete from MemberTableEntity where idProofNumber = '"+IdNumber+"'");
			value = query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			System.out.println("transaction is rollback because : "+e.getMessage());
		} finally {
			if(session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return value;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
