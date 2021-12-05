package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDetails;
import service.EditProfileService;

public class ProfileController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws Servlet
    
        EditProfileService service = new EditProfileService();
    
        String UserID = request.getParameter("UserID");
        
        User user = service.returnUserByID(UserID);
        UserDetails details = service.returnUserDetailsByUser(user);
        
        if(details != null) {
        	// I'm switching to page profile.jsp, but I'm transfering UserDetails as well.
        	request.setAttribute("details", details);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/Profile.jsp");
        	dispatcher.forward(request, response);
        }else {
        	response.sendRedirect("html_stranice/No_User_Details_Found.html");
        }
}
