package dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;
import model.UserDetails;

public class RegistrationLoginDao {
	
	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	public boolean writeUser(User user) {
		
		UserDetails details = new UserDetails();
		details.setUser(user);
		
		Session session = sf.openSession();
		    session.beginTransaction();
		    try {
		    	session.save(user);
		    	session.save(details);
		    	session.getTransaction().commit();
		    	System.out.println("User with a User Name: " + user.getUserName() + "has been writen into database");
		    	return true;
			} catch (Exception e) {
				session.getTransaction().rollback();
				System.out.println("Error, user failed to be writen into database!");
				return false;
			}finally {
				session.close();
			}
	}

	public User returnUserByUserNameOrPassword(String userName, String password) {
		
		User user = null;
		Session session = sf.openSession();
	    session.beginTransaction();
	    try {
	    	String hql = "from User where userName = :name and password = :password";
	    	Query query = session.createQuery(hql);
	    	     query.setParameter("name", userName);
	    	     query.setParameter("password", password);
	    	     
	    	user = (User) query.getSingleResult();
	    	
	        session.getTransaction().commit();
	    	System.out.println("User found!");
	    	return user;
	    	
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Error, user not found!");
			return null;
		}finally {
			session.close();
		}
	    
	}
	
}