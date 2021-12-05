package service;

import dao.AdminDao;
import model.User;

public class AddBalanceService {
	
	AdminDao dao = new AdminDao();

	public User returnUserByUserName(String userName) {
		return dao.returnUserByUserName(userName);
	}

	public boolean addBalanceToUser(User user, Double balance) {
		return dao.addBalanceToUser(user, balance);
	}
	
}