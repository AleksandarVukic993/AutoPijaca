package service;

import dao.AddCarDao;
import dao.AdminDao;
import model.Car;
import model.User;
import model.UserDetails;

public class AddCarService {
	
	AddCarDao dao = new AddCarDao();
	AdminDao adminDao = new AdminDao();
	
	public User returnUser(String userID) {
		return adminDao.returnUserByID(userID);
	}

	public UserDetails returnUserDetails(User user) {
		return adminDao.returnUserDetailsByUser(user);
	}

	public Boolean isItRegistered(String[] isRegisterFromForm) {
		return dao.isItRegistered(isRegisterFromForm);
	}

	public Car fillCar(String manufacturer, String model, double price, String year, Boolean isRegister,
			UserDetails details) {
		return dao.fillCar(manufacturer, model, price, year, isRegister, details);
	}

	public boolean putCar(Car car) {
		return dao.putCar(car);
	}

	public boolean joinUserDetialsAndCar(UserDetails details, Car car) {
		return dao.joinUserDetialsAndCar(details, car);
	}
	
}