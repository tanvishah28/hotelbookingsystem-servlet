package com.entlogics.hotelbookingsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entlogics.hotelbookingsystem.dao.HotelDAO;
import com.entlogics.hotelbookingsystem.entity.Booking;

//this servlet gets information of all employees of a hotel - it will handle the /hotels/{hotel-id}/bookings EndPoint

public class GetHotelBookingsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// creating request dispatcher globally and assigning it null value
	RequestDispatcher dispatcher = null;

	// Instantiating and initializing HotelDAO object
	HotelDAO hotelDao = new HotelDAO();

	// no-arg constructor of GetHotelBookingsController
	public GetHotelBookingsController() {
		super();
	}

	// this method performs get request by getting list of bookings of a hotel
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getBookingsOfOneHotel(request, response);
	}

	// this method gets the list of bookings of a hotel
	
	public void getBookingsOfOneHotel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Inside controller method getBookingsOfOneHotel()");
		
		// accept id using request object and store it in a variable
		String[] hotelId = request.getPathInfo().split("/");

		// using DAO object get details of all bookings
		List<Booking> bookingList = hotelDao.getBookingsOfAHotel(Integer.parseInt(hotelId[1]));

		// add booking to request obj
		request.setAttribute("bookingList", bookingList);

		// get the request dispatcher obj and forward it
		dispatcher = request.getRequestDispatcher("/views/list-hotel-bookings.jsp");
		dispatcher.forward(request, response);
	}
}
