package service;

import dao.AdminDao;
import dao.EditProfileDao;
import model.User;
import model.UserDetails;

public class EditProfileService {
	
	EditProfileDao dao = new EditProfileDao();
	AdminDao adminDao =  new AdminDao();
	
	public User returnUserByID(String idUser) {
		return adminDao.returnUserByID(idUser);
	}

	public UserDetails returnUserByID(User user) {
		return adminDao.returnUserDetailsByUser(user);
	}

	public boolean EditUserDetails(String firstName, String lastName, String phone, String email, String country,
			String city, String street, UserDetails details) {
		return dao.EditUserDetails(firstName, lastName, phone, email, country, city, street, details);
	}

	public UserDetails returnUserDetailsByUser(User user) {
		return null;
	}
	
}