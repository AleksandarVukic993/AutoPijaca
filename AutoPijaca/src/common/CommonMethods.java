package common;

import model.User;
import model.UserType;

public class CommonMethods {

	public User fillUser(String userName, String password, String userType) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		if(userType.equals("0")) {
			user.setUserType(UserType.BUYER);
		}else {
			user.setUserType(UserType.SELLER);
		}
		
		return user;
	}

	public void setUpParameters(String userName, String password) {
		System.out.println("Login parameters:");
		System.out.println("UserName: " + userName);
		System.out.println("Password: " + password);
	}

	public UserType returnUserType(String userType) {
		
		UserType type = null;
		
		if(userType.equals("buyer")) {
			type = UserType.BUYER;
		}else if(userType.equals("seller")) {
			type = UserType.SELLER;
		}
		
		return type;
	}
	
	
	
}