package com.entlogics.hotelbookingsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entlogics.hotelbookingsystem.dao.HotelDAO;
import com.entlogics.hotelbookingsystem.entity.Customer;

// this servlet gets information of one customer of a hotel - it will handle the /hotels/{hotel-id}/customers/{customer-id} EndPoint

public class SingleCustomerHotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// creating request dispatcher globally and assigning it null value
	RequestDispatcher dispatcher = null;

	// Instantiating and initializing HotelDAO object
	HotelDAO hotelDao = new HotelDAO();

	// no-arg constructor of SingleCustomerHotelController
	public SingleCustomerHotelController() {
		super();
	}

	// this method performs get request by getting a single customer

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getOneCustomerOfOneHotel(request, response);
	}

	// this method gets one customer of a hotel - write url as "/hotels/*/customers/100/300"

	public void getOneCustomerOfOneHotel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside controller method getOneCustomerOfOneHotel()");

		// accept id using request object and store it in a variable - getting the path parameter using getPathInfo & splitting the url 
		String[] hotelId = request.getPathInfo().split("/");
		String[] customerId = request.getPathInfo().split("/");

		System.out.println("hotelId value -" + hotelId[1] + " customerId value "+ customerId[2] + " in getOneCustomerOfOneHotel()");
		
		// using DAO object get all details of a single customer
		Customer customer = hotelDao.getCustomerInformation(Integer.parseInt(hotelId[1]),Integer.parseInt(customerId[2]));

		// add a customer to request obj
		request.setAttribute("customer", customer);
		
		// get the request dispatcher obj and forward it
		dispatcher = request.getRequestDispatcher("/views/view-hotel-customer.jsp");
		dispatcher.forward(request, response);
	}
}
