package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.RegistrationService;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet(description = "This is servlet for registration", urlPatterns = { "/PathToRegistration" })
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrationController() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome to doGet Method!");
		
		// I've connected to service this way.
		RegistrationService service = new RegistrationService();
		
		// Here I've accepted parameters from request.
		String UserName = request.getParameter("UserName");
		String Password = request.getParameter("Password");
		String RepeatedPassword = request.getParameter("RepeatedPassword");
		String UserType = request.getParameter("UserType");
		
		// check if parameters are null
		
		// Calling parameter list
		service.WriteParemetersService(UserName, Password, RepeatedPassword, UserType);
		
		// Check if he password is valid
		boolean IsThePasswordOkay = service.IsThePasswordOkay(Password);
		
		if(IsThePasswordOkay) {
			// I'm asking if the password and repeated password are the same.
		    if(!Password.equals(RepeatedPassword)){
		    	// if the password and repeated password is incorrect, return answer to client.
				response.sendRedirect("html_stranice/Incorrectly_Repeated_Password.html");
		    }else {
		    	
		    
			    // writing user into database.
		        User user = service.fillUser(UserName,Password,UserType);
		        // save user in database.
		        boolean UserWritenIntoDatabase = service.writeUser(user);
		        if(UserWritenIntoDatabase) {
		        	// if the data is written into database, return to the main page.
		        	response.sendRedirect("MainPage.html");
		        }else {
		        	// if the data isn't written into database, return to registration.
		        	response.sendRedirect("html_stranice/Registration.html");
		        }
		    }
		}else {
			// if the password is incorrect, return answer to client.
			response.sendRedirect("html_stranice/Incorrect_Password.html");
		}
		
		}

	private User fillUser(String userName, String password, String userType) {
		// TODO Auto-generated method stub
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome to doPost Method!");
		
		String UserName = request.getParameter("UserName");
		String Password = request.getParameter("Password");
		String RepeatedPassword = request.getParameter("RepeatedPassword");
		String UserType = request.getParameter("UserType");
		
		System.out.println("Parameters are: ");
		System.out.println("UserName: " + UserName);
		System.out.println("Password: " + Password);
		System.out.println("RepeatedPassword: " + RepeatedPassword);
		System.out.println("UserType: " + UserType);
		
	}
}