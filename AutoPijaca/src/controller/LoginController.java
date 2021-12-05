package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserType;
import service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "Ovo je login", urlPatterns = { "/PathToLogin" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService service = new LoginService();
		
		String userName = request.getParameter("UserName");
		String password = request.getParameter("Password");
		
		service.setUpParameters(userName,password);
		
		// validation: user and password have to be filled.
		boolean areUserandPasswordEmpty = service.validateUserAndPasswordFromTheDatabase(userName, password);
		if(!areUserandPasswordEmpty) {
			response.sendRedirect("html_stranice/Login_failed.html");
		}
		// search the database for user with a specific user name and password.
		User user = service.returnUserByUserNameOrPassword(userName, password);
		if(user == null) {
			response.sendRedirect("html_stranice/Login_failed.html");
		}else {
			
			// Open session.
			HttpSession session = request.getSession();
			// put user into session object.
			session.setAttribute("user", user);
			if(user.getUserType().equals(UserType.BUYER)) {
				// redirect them to the buyer page.
				response.sendRedirect("jsp/Buyer.jsp");
			}else if(user.getUserType().equals(UserType.SELLER)) {
				// redirect them to the buyer page.
				response.sendRedirect("jsp/Seller.jsp");
			}else {
				// redirect them to the Admin page.
				response.sendRedirect("jsp/Admin.jsp");
			}
		}
	}
	
}
