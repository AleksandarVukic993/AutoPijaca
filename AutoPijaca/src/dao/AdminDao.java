package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;
import model.UserDetails;
import model.UserType;

public class AdminDao {
	
	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	public List<User> returnAllUsers(){
		
		List<User> users = new ArrayList<>();
		
		Session session = sf.openSession();
		    session.beginTransaction();
		    try {
		    	String hql = "from User";
		    	Query query = session.createQuery(hql);
		    	
		    	users = ( List<User>)query.getResultList();
		    	    System.out.println("Downloaded all Users.");
		    	session.getTransaction().commit();
		    	return users;
		    } catch (Exception e) {
		    	System.out.println("Downloading failed!");
		    	session.getTransaction().rollback();
		    	return null;
		    }finally {
		    	session.close();
		    }
			
	}

	public User returnUserByUserName(String userName) {
		User user = null;
		
		Session session = sf.openSession();
	    session.beginTransaction();
	    try {
	    	String hql = "from User were userName = :userName";
	    	Query query = session.createQuery(hql);
	    	    query.setParameter("userName", userName);
	    	user = (User)query.getSingleResult();
	    	    System.out.println("User found!");
	    	session.getTransaction().commit();
	    	return user;
	    } catch (Exception e) {
	    	System.out.println("User not found!");
	    	session.getTransaction().rollback();
	    	return null;
	    }finally {
	    	session.close();
	    }
		
	}

	public boolean addBalanceToUser(User user, Double balance) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			User userFromDb = session.get(User.class, user.getIdUser());
			String hql = "from User where user = :userFromDb";
			Query query = session.createQuery(hql);
			query.setParameter("userFromDb",userFromDb);
			
			UserDetails details = (UserDetails)query.getSingleResult();
			
			System.out.println("User's details found!");
			if(details.getBalance() != null) {
				details.setBalance(details.getBalance() + balance);
			}else {
				details.setBalance(balance);
			}
			session.update(details);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			System.out.println("Didn't add balance");
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
		
	}

	public List<User> returnUserByType(UserType type) {
		
		List<User> users = new ArrayList<User>();
		
		Session session = sf.openSession();
		    session.beginTransaction();
		try {
			
			String hql = "from User";
			
			if(type != null) {
				hql += " where userType = :type";
			}
			
			System.out.println("hql: " + hql);
			Query query = session.createQuery(hql);
			
			if(type != null) {
				query.setParameter("type", type);
			}
			
			users = (List<User>)query.getResultList();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		
		return users;
	}

	public UserDetails returnUserDetailsByUser(User userFromDb) {
		UserDetails details = new UserDetails();
		
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			
			String hql = "from UserDetails where user = :userFromDb";
			Query query = session.createQuery(hql);
			query.setParameter("userFromDb", userFromDb);
			
			details = (UserDetails) query.getSingleResult();
			
			session.getTransaction().commit();
			System.out.println("User exists with a user name: " + details.getIdUserDetails());
			return details;
		} catch (NonUniqueResultException e) {
			System.out.println("There are more than one user with this user name.");
			return null;
		} catch (NoResultException e) {
			System.out.println("There are no user with this user name.");
			return null;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Something went wrong.");
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
		
			
	}

	public boolean updateBalance(UserDetails details, Double balance) {
		boolean updateBalance = false;
		
		Session session = sf.openSession();
	    session.beginTransaction();
	    try {
	    	// I returned it from detached state to presenting state.
	    	UserDetails persistedUserDetails = session.get(UserDetails.class, details.getIdUserDetails());
	    	
	    	System.out.println("persistedUserDetails: " + persistedUserDetails.getIdUserDetails());
	    	
	    	if(persistedUserDetails.getBalance() != null) {
	    		persistedUserDetails.setBalance(balance + persistedUserDetails.getBalance());
	    	}else {
	    		persistedUserDetails.setBalance(balance);
	    	}
	    	
	    	session.update(persistedUserDetails);
	    	updateBalance = true;
	    	
	    	session.getTransaction().commit();
	    	System.out.println("User details balance sucessfully updated! ");
	    	return updateBalance;
	    	
	    } catch (Exception e) {
	    	session.getTransaction().rollback();
	    	System.out.println("User details balance failed to update! " +e);
	    	return false;
	    }finally {
	    	session.close();
	    }
		
	}
	
	public User returnUserByID(String userID ) {
		User user = new User();
		
		int idUser = Integer.parseInt(userID);
		
		Session session = sf.openSession();
	    session.beginTransaction();
	    try {
	    	user = session.get(User.class, userID);
	    	session.getTransaction().commit();
	    	System.out.println("User with " + userID + " exists.");
	    	return user;
	    	
	    }catch (Exception e) {
	    	session.getTransaction().rollback();
	    	System.out.println("Something went wrong in returnUserByID!");
	    	e.printStackTrace();
	    	return null;
	    }finally{
	    	session.close();
	    }
		
	    
	    
	}
	
}