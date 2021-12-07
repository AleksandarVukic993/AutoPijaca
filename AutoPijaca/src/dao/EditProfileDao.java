package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Address;
import model.Contact;
import model.UserDetails;

public class EditProfileDao {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();

	public boolean EditUserDetails(String firstName, String lastName, String phone,
			String email, String country,String city, String street, UserDetails details) {
	}
	public boolean updateUserDetails(UserDetails details1, Double balance) {
			
		   boolean updateUserDetails = false;
			
			Session session = sf.openSession();
		    session.beginTransaction();
		    try {
		    	// I returned it from detached state to presenting state.
		    	UserDetails persistedUserDetails = session.get(UserDetails.class, details1.getIdUserDetails());
		    	System.out.println("In EditUserDetails method, I found UserDetails who's ID is: " + persistedUserDetails.getIdUserDetails());
		    	persistedUserDetails.setFirstName(firstName);
		    	persistedUserDetails.setLastName(lastName);
		    	if(persistedUserDetails.getContact() == null) {
		    		Contact contact = new Contact();
		    		contact.setEmail("defaultMail");
		    		contact.setPhone("defaultPhone");
		    		persistedUserDetails.setContact(contact);
		    		
		    		persistedUserDetails.getContact().setPhone(phone);
			    	persistedUserDetails.getContact().setEmail(email);
		    	}else {
		    		persistedUserDetails.getContact().setPhone(phone);
			    	persistedUserDetails.getContact().setEmail(email);
		    	}
		    	
		    	if(persistedUserDetails.getAddress() == null) {
		    		Address a = new Address();
		    		a.setCity("x");
		    		a.setCountry("y");
		    		a.setStreet("z");
		    		
		    		persistedUserDetails.setAddress(a);
		    		
		    		persistedUserDetails.getAddress().setCountry(country);
			    	persistedUserDetails.getAddress().setCity(city);
			    	persistedUserDetails.getAddress().setStreet(street);
		    	}else {
		    		persistedUserDetails.getAddress().setCountry(country);
			    	persistedUserDetails.getAddress().setCity(city);
			    	persistedUserDetails.getAddress().setStreet(street);
		    	}
		    	
		    	session.update(persistedUserDetails);
		    	updateUserDetails = true;
		    	
		    	session.getTransaction().commit();
		    	System.out.println("User details sucessfully updated! ");
		    	return updateUserDetails;
		    	
		    } catch (Exception e) {
		    	session.getTransaction().rollback();
		    	System.out.println("User details failed to update! " +e);
		    	return false;
		    }finally {
		    	session.close();
		    }
		}
	}
}