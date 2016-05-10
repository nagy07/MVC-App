package service;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.util.HibernateUtil;
import model.User;

public class RegisterService {
	
	public boolean register(User user){
		if(isUserExist(user)) return false;
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try{
			 tx = session.getTransaction();
			 tx.begin();
			 session.saveOrUpdate(user);
			 tx.commit();
			
		}catch(Exception e){
			if(tx!= null){
				tx.rollback();
			}
			e.printStackTrace();
			
		}finally{
			session.close();
		}
		return true;
		
	}
	
	public boolean isUserExist(User user){
		boolean result = false;
		Transaction tx = null;
		try{
			Session session = HibernateUtil.openSession();
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("select from User where jwt='"+user.getId()+"'");
			User u = (User)query.uniqueResult();
			tx.commit();
			if(u!=null){
				result = true;
			}
		}catch(Exception e){
			if(tx!= null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return result;
	}
}



