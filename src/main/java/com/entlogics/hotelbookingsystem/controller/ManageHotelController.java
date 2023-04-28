package com.entlogics.hotelbookingsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entlogics.hotelbookingsystem.dao.HotelDAO;
import com.entlogics.hotelbookingsystem.entity.Hotel;

// This servlet gets the list of hotels and adds a new hotel - this servlet will handle the /hotels EndPoint

public class ManageHotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// creating request dispatcher globally and assigning it null value
	RequestDispatcher dispatcher = null;

	// Instantiating and initializing HotelDAO object
	HotelDAO hotelDao = new HotelDAO();

	// no-arg constructor of ManageHotelController
	public ManageHotelController() {
		super();
	}

	// this method gets the list of hotels
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getListofHotels(request, response);
	}

	// this method performs the post request by adding a new hotel
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// passing request, response object to addNewHotel()
		addNewHotel(request, response);
	}

	// this method gets a list of hotel
	public void getListofHotels(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside controller method getListofHotels()");

		// call DAO method to get list of hotels
		List<Hotel> hotelList = hotelDao.getAllHotels();

		// adding the list of hotel to request object
		request.setAttribute("hotelList", hotelList);

		// getting the request dispatcher object
		dispatcher = request.getRequestDispatcher("/views/hotels-list.jsp");

		// using the dispatcher obj forward the request from ManageHotelController to
		// hotels-list jsp page & generate response
		dispatcher.forward(request, response);
	}

	// this method adds a new hotel
	public void addNewHotel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Inside controller method addNewHotel()");

		// get the hotel details from request object
		String hotelName = request.getParameter("hotel-name");
		String hotelLocation = request.getParameter("hotel-location");
		String hotelPhone = request.getParameter("hotel-phone");
		String hotelEmail = request.getParameter("hotel-email");
		String hotelRating = request.getParameter("hotel-rating");
		String hotelPetFriendly = request.getParameter("pet-friendly");

		// create a hotel object
		Hotel hotel = new Hotel(hotelName, hotelLocation);
		hotel.setHotel_phone(Long.parseLong(hotelPhone));
		hotel.setHotel_email(hotelEmail);
		hotel.setHotel_rating(hotelRating);
		hotel.setPet_friendly(Boolean.parseBoolean(hotelPetFriendly));

		System.out.println("Printing hotel object in the ManagehotelController " + hotel);

		// call DAO method addNewHotel()
		boolean isAdded = hotelDao.addNewHotel(hotel);
		String added = String.valueOf(isAdded);

		// send success message back to the client
		request.setAttribute("Success", added);

		// forward to success jsp (hotel-add-success) page
		dispatcher = request.getRequestDispatcher("/views/add-hotel-success.jsp");
		dispatcher.forward(request, response);
	}
}
