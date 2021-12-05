package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Car;
import model.User;
import model.UserDetails;

public class AddCarDao {
	
	SessionFactory sf = HibernateUtil.createSessionFactory();

	public Boolean isItRegistered(String[] isRegisterFromForm) {
		Boolean isRegister = false;
		
		if(isRegisterFromForm == null) {
			isRegister = false;
		}else {
			isRegister = true;
		}
		
		return null;
	}

	public Car fillCar(String manufacturer, String model, double price, String year, Boolean isRegister,
			UserDetails details) {
		
		Car car = new Car();
		car.setManufacturer(manufacturer);
		car.setModel(model);
		car.setPrice(price);
		car.setYear(year);
		car.setIsRegister(isRegister);
		car.setUserDetails(details);
		
		return car;
	}

	public boolean putCar(Car car) {
		Session session = sf.openSession();
	    session.beginTransaction();
	    try {
	    	session.save(car);
	    	session.getTransaction().commit();
	    	System.out.println("Car written into database.");
	    	return true;
	    	
	    }catch (Exception e) {
	    	session.getTransaction().rollback();
	    	System.out.println("Something went wrong in putCar!");
	    	e.printStackTrace();
	    	return false;
	    }finally{
	    	session.close();
	    }
	}

	public boolean joinUserDetialsAndCar(UserDetails details, Car car) {
		
		Session session = sf.openSession();
	    session.beginTransaction();
	    try {
	    	// I'm taking a persistent object from UserDetails database.
	    	UserDetails detailsFromDb = session.get(UserDetails.class, details.getIdUserDetails());
	    	// I'm initializing list cars because the fetch type is lazy.
	    	Hibernate.initialize(detailsFromDb.getCars());
	    	// I'm adding car in the list (rather joinUserDetailsCar)
	    	detailsFromDb.getCars().add(car);
	    	session.saveOrUpdate(detailsFromDb);
	    	
	    	session.getTransaction().commit();
	    	System.out.println("Car written into UserDetils list.");
	    	return true;
	    	
	    }catch (Exception e) {
	    	session.getTransaction().rollback();
	    	System.out.println("Something went wrong in putCar!");
	    	e.printStackTrace();
	    	return false;
	    }finally{
	    	session.close();
	    }
		
	}
	
}