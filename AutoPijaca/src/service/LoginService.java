package service;

import common.CommonMethods;
import dao.RegistrationLoginDao;
import model.User;
import validation.Validation;

public class LoginService {
	
	CommonMethods common = new CommonMethods();
	Validation validation = new Validation();
	RegistrationLoginDao dao = new RegistrationLoginDao();
	
	public void setUpParameters(String userName, String password) {
		common.setUpParameters(userName, password);
	}

	public boolean validateUserAndPasswordFromTheDatabase(String userName, String password) {
		return validation.validateUserAndPasswordFromTheDatabase(userName, password);
	}

	public User returnUserByUserNameOrPassword(String userName, String password) {
		return dao.returnUserByUserNameOrPassword(userName, password);
	}
	
	
	
}