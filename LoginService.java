package service;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.util.HibernateUtil;
import model.User;


public class LoginService {
	public boolean authnticateUser(String id , String password){
		
		User user = getUserByUserId(id);
		if(user != null && user.getId().equals(id) && user.getPassword().equals(password)){
			return true;
		}else{
			return false;
		}
		
	}
	public User getUserByUserId(String userId){
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		User user = null;
		
		try{
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("select from user where jwt='"+user.getId()+"'");
			user = (User) query.uniqueResult();
			tx.commit();
			
		}catch(Exception e){
			if(tx!= null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}
	public java.util.List<User> getAllUsers(){
		java.util.List<User> list = new ArrayList<>();
		Session session = HibernateUtil.openSession();
		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			list = session.createQuery("select * from jwt").list();

		}catch(Exception e){
			if(tx!= null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		return list;
	}

}
