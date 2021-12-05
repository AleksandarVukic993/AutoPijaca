package service;

import java.util.List;

import common.CommonMethods;
import dao.AdminDao;
import model.User;
import model.UserDetails;
import model.UserType;

public class AdminService {
	
	AdminDao dao = new AdminDao();
	CommonMethods common = new CommonMethods();

	public List<User> returnAllUsers() {
		return dao.returnAllUsers();
	}

	public UserType returnUserType(String userType) { 
		return common.returnUserType(userType); 
	}

	public List<User> returnUserByType(UserType type) {
		return dao.returnUserByType(type);
	}
	
	public User returnUserByName(String userName) {
		return dao.returnUserByUserName(userName);
	}
	
	public boolean updateBalance(UserDetails details, Double balance) {
		return dao.updateBalance(details, balance);
	}

	public User returnUserByUserName(String userName) {
		return null;
	}
	
	public UserDetails returnUserDetailsByUser(User userFromDb) {
		return dao.returnUserDetailsByUser(userFromDb);
	}
	
	public boolean updateBalance(UserDetails details, String balance) {
		return false;
	}
}