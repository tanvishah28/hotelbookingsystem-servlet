package com.entlogics.hotelbookingsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entlogics.hotelbookingsystem.dao.HotelDAO;
import com.entlogics.hotelbookingsystem.entity.Service;

//this servlet gets information of all services of a hotel & links services to a hotel- it will handle the /hotels/{hotel-id}/services EndPoint

public class ManageHotelServicesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// creating request dispatcher globally and assigning it null value
	RequestDispatcher dispatcher = null;

	// Instantiating and initializing HotelDAO object
	HotelDAO hotelDao = new HotelDAO();

	// no-arg constructor of ManageHotelServicesController
	public ManageHotelServicesController() {
		super();
	}

	// this method performs get request by getting services of a hotel

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServicesOfOneHotel(request, response);
	}

	// this method performs post request by adding services to a hotel

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		linkServicesToOneHotel(request, response);
	}

	// this method gets the list of services offered by a hotel

	public void getServicesOfOneHotel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside controller method getServicesOfOneHotel()");

		// accept id using request object and store it in a variable
		String[] hotelId = request.getPathInfo().split("/");

		// call DAO method to get list of services
		List<Service> serviceList = hotelDao.getServicesOfAHotel(Integer.parseInt(hotelId[1]));

		// adding the list of services to request object
		request.setAttribute("serviceList", serviceList);

		// get the request dispatcher obj and forward it
		dispatcher = request.getRequestDispatcher("/views/list-hotel-services.jsp");
		dispatcher.forward(request, response);
	}

	// this method links services to a hotel

	public void linkServicesToOneHotel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside controller method linkServicesToOneHotel()");

		// accept id using request object and store it in a variable - getting the path parameter using getPathInfo & splitting the url 
		String[] hotelId = request.getPathInfo().split("/");
		String[] serviceId = request.getPathInfo().split("/");

		// call DAO method to add services
		boolean isLinked = hotelDao.linkServicesToAHotel(Integer.parseInt(hotelId[1]), Integer.parseInt(serviceId[2]));
		String linkedServices = String.valueOf(isLinked);

		// send success message back to the client
		request.setAttribute("Success", linkedServices);

		// get the request dispatcher obj and forward it
		dispatcher = request.getRequestDispatcher("/views/link-services-hotel.jsp");
		dispatcher.forward(request, response);
	}
}
