package com.entlogics.hotelbookingsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entlogics.hotelbookingsystem.dao.HotelDAO;
import com.entlogics.hotelbookingsystem.entity.Customer;

// this servlet gets information of all customers of a hotel, links customers to a hotel - It will handle the  /hotels/{hotel-id}/customers endpoint

public class ManageHotelCustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// creating request dispatcher globally and assigning it null value
	RequestDispatcher dispatcher = null;

	// Instantiating and initializing HotelDAO object
	HotelDAO hotelDao = new HotelDAO();

	// no-arg constructor of ManageHotelCustomersController
	public ManageHotelCustomersController() {
		super();
	}

	// this method gets the list of customers
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getCustomersofOneHotel(request, response);
	}

	// this method performs the post request by adding a customer to a hotel
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		linkCustomersToOneHotel(request, response);
	}

	// this method gets all customers of a single hotel - GET
	// /hotels/{hotel-id}/customers
	public void getCustomersofOneHotel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside controller method getCustomersofOneHotel()");

		// accept id using request object and store it in a variable
		String[] hotelId = request.getPathInfo().split("/");

		// call DAO method to get list of customers
		List<Customer> customerList = hotelDao.getCustomersOfAHotel(Integer.parseInt(hotelId[1]));

		// adding the list of customers to request object
		request.setAttribute("customerList", customerList);

		// getting the request dispatcher object
		dispatcher = request.getRequestDispatcher("/views/list-hotel-customers.jsp");

		// using the dispatcher obj forward the request from
		// ManageHotelCustomersController to
		// list-hotel-customers jsp page & generate response
		dispatcher.forward(request, response);
	}

	// this method links customers to a hotel - POST /hotels/{hotel-id}/customers
	public void linkCustomersToOneHotel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside controller method linkCustomersToOneHotel()");

		// accept id using request object and store it in a variable - getting the path parameter using getPathInfo & splitting the url 
		String[] hotelId = request.getPathInfo().split("/");
		String[] customerId = request.getPathInfo().split("/");

		// call DAO method to add customers
		boolean isLinked = hotelDao.linkCustomersToAHotel(Integer.parseInt(hotelId[1]),Integer.parseInt(customerId[2]));
		String linkedCustomers = String.valueOf(isLinked);

		// send success message back to the client
		request.setAttribute("Success", linkedCustomers);
		
		// get the request dispatcher obj and forward it
		dispatcher = request.getRequestDispatcher("/views/link-customers-hotel.jsp");
		dispatcher.forward(request, response);
	}
}
