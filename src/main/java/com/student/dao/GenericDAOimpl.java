package com.student.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.studentpackage.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class GenericDAOimpl <T,ID> implements GenericDAO<T,ID>{
	
	private final Class<T> entityClass;
	
	public GenericDAOimpl(Class<T> entityClass) {
		this.entityClass=entityClass;
	}
	
	public void save(T entity) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction=session.beginTransaction();
			session.persist(entity);
			transaction.commit();
			
		    }catch(Exception e) {
			//if(transaction !=null && transaction.isActive()) {
				//transaction.rollback();
			//}
			System.out.println("ERROR WHILE SAVING ");
			e.printStackTrace();
		
		}		
	}
	
	
	
	public T findById(ID id) {
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			return session.find(entityClass,id);
		}catch(Exception e) {
			System.out.println("OPERATION FAILED");
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public List<T> findAll(){
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder builder=session.getCriteriaBuilder();
			CriteriaQuery<T> criteria=builder.createQuery(entityClass); 
			Root<T> root=criteria.from(entityClass);
			criteria.select(root);
			return session.createQuery(criteria).getResultList();
		}catch(Exception e) {
			System.out.println("OPERATION FAILED");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public void update(T entity) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			transaction =session.beginTransaction();
			session.merge(entity);
			transaction.commit();
			System.out.println("STUDENT RECORD UPDATED SUCCESSFULLY");
		}catch(Exception e) {
			if(transaction!=null && transaction.isActive()) {
				transaction.rollback();
			}
			System.out.println("OPERATION FAILED");
			e.printStackTrace();
		}
	}
	
	
	public void delete(ID id) {
		Transaction transaction=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			T entity=session.find(entityClass,id);
			
			if(entity!=null) {
				session.remove(entity);
				transaction.commit();
				System.out.println("STUDENT RECORD DELETED SCCESFULLY");
			}
			else{
				transaction.rollback();
				System.out.println("RECORD NOT FOUND");
			}	
			}catch(Exception e) {
				if(transaction!=null && transaction.isActive()) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
		}
	
	

}
