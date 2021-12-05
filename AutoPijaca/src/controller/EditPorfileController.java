package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDetails;
import service.EditProfileService;

/**
 * Servlet implementation class EditPorfileController
 */
@WebServlet(description = "For user detials editing", urlPatterns = { "/EditPorfileController" })
public class EditPorfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EditProfileService service = new EditProfileService();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("firstName");
		String phone = request.getParameter("firstName");
		String email = request.getParameter("firstName");
		String country = request.getParameter("firstName");
		String city = request.getParameter("firstName");
		String street = request.getParameter("firstName");
		String idUser = request.getParameter("idUser");
		
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Phone: " + phone);
		System.out.println("Email: " + email);
		System.out.println("Country: " + country);
		System.out.println("City: " + city);
		System.out.println("Street: " + street);
		System.out.println("Users ID " + idUser);
		
		// 1. In User details database, find a user with an accepted users ID.
		User user = service.returnUserByID(idUser);
		UserDetails details = service.returnUserByID(user);
		// If user details aren't found, return the error report.
		if(details == null) {
			response.sendRedirect("html_stranice/No_User_Details_Found.jsp");
		}else {
			// 2. Set User details and save updates in the database.
			boolean EditUserDetails = service.EditUserDetails(firstName, lastName, phone, email, country, city, street, details);
			if(EditUserDetails) {
				response.sendRedirect("jsp/Seller.jsp");
			}else {
				response.sendRedirect("html_stranice/NoUser_Details_Found.jsp");
			}
		}
		
	}

}
