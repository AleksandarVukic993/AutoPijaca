package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDetails;
import service.AddBalanceService;
import service.AdminService;

/**
 * Servlet implementation class AddBalanceController
 */
@WebServlet(description = "adding balance", urlPatterns = { "/AddBalanceController" })
public class AddBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminService servis = new AdminService();
		
		String userName = request.getParameter("userName");
		String balance = request.getParameter("balance");
		
		System.out.println("User Name: " + userName);
		System.out.println("Balance: " + balance);
		
		Double balanceForInsert = Double.parseDouble(balance);
		
		User userFromDb = servis.returnUserByUserName(userName);
		
		if(userFromDb != null) {
			System.out.println("User: " + userFromDb.getUserName());
			// I'm taking over UserDetails object.
			UserDetails details = servis.returnUserDetailsByUser(userFromDb);
			if(details == null) {
				response.sendRedirect("html_stranice/No_User_Found.html");
			}else {
				// Update balance on UserDetails
				boolean updateBalance = servis.updateBalance(details, balance);
				if(updateBalance) {
					response.sendRedirect("jsp/Admin.jsp");
				}else {
					response.sendRedirect("html_stranice/No_Balance_Added.hmtl");
				}
			}
		}
		
		AddBalanceService service = new AddBalanceService();
		
		User user = service.returnUserByUserName(userName);
		
		if(user != null) {
			
			boolean wasBalanceAdded = service.addBalanceToUser(user, balanceForInsert);
			   if(wasBalanceAdded) {
				   response.sendRedirect("jsp/Admin.jsp");
			   }else {
				   response.sendRedirect("jsp/AddBalance.jsp");
			   }
		}else {
			response.sendRedirect("html_stranice/User_Failed.html");
		}
		
	}
	
}
