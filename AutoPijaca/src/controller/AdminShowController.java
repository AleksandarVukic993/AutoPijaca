package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserType;
import service.AdminService;

/**
 * Servlet implementation class AdminShowController
 */
@WebServlet(description = "show users", urlPatterns = { "/AdminShowController" })
public class AdminShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminService service = new AdminService();
		
		String userType = request.getParameter("userType");
		System.out.println("Parameter: " + userType);
		
		UserType type = service.returnUserType(userType);
		
		// give all users by choosing type
		List<User> users = service.returnUserByType(type);
		
		for(User u: users) {
			
		}
		
		if(users != null && !users.isEmpty()) {
			/*for(User u: users) {
				System.out.println("ID: " + u.getIdUser());
				System.out.println("User Name: " + u.getUserName());
				System.out.println("Password: " + u.getPassword());
				System.out.println("Type: " + u.getUserType());
			}*/
			
			// here I pack user in request object.
			request.setAttribute("users", users);
			// here I'm doing redirection of the existing request to the page Show_Users.jsp .
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Show_Users.jsp");
			// Here I'm packing the request into response.
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("jsp/Admin.jsp");
		}
	}
}