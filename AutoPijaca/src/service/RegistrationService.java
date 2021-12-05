package service;

import common.CommonMethods;
import dao.RegistrationLoginDao;
import model.User;
import validation.Validation;

public class RegistrationService {
	
	Validation validation = new Validation();
	CommonMethods common = new CommonMethods();
	RegistrationLoginDao dao = new RegistrationLoginDao();
	
	public void WriteParemetersService(String UserName, String Password, String RepeatedPassword, String UserType) {
		
		validation.WriteParameters(UserName, Password, RepeatedPassword, UserType);
		
	}

	public boolean IsThePasswordOkay(String Password) {
		return validation.IsThePasswordOkay(Password);
	}

	public User fillUser(String UserName, String Password, String UserType) {
		return common.fillUser(UserName, Password, UserType);
	}

	public boolean writeUser(User user) {
		
		return dao.writeUser(user);
	}
	
}