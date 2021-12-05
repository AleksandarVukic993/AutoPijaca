package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.User;
import model.UserDetails;
import service.AddCarService;

/**
 * Servlet implementation class AddCarController
 */
@WebServlet(description = "add car", urlPatterns = { "/AddCarController" })
public class AddCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AddCarService service = new AddCarService();
		
		String UserID = request.getParameter("UserID");
		String Manufacturer = request.getParameter("manufacturer");
		String Model = request.getParameter("model");
		String PriceFromForm = request.getParameter("price");
		double Price = Double.parseDouble(PriceFromForm);
		String Year = request.getParameter("year");
		String[] isRegisterFromForm = request.getParameterValues("isRegister");
		Boolean isRegister = service.isItRegistered(isRegisterFromForm);
		
		User user = service.returnUser(UserID);
		UserDetails details = service.returnUserDetails(user);
		Car car = service.fillCar(Manufacturer, Model, Price, Year, isRegister, details);
		
		boolean putCarIntoTable = service.putCar(car);
		
		if(putCarIntoTable) {
			
			boolean joinUserDetailsAndCar = service.joinUserDetialsAndCar(details, car);
			if(joinUserDetailsAndCar) {
				response.sendRedirect("jsp/Seller.jsp");
			}else {
				response.sendRedirect("jsp/Seller.jsp");
			}
			
		}else {
			response.sendRedirect("jsp/Seller.jsp");
		}
		
	}

}
