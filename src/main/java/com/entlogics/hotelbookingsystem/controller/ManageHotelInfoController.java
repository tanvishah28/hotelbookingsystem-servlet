package com.entlogics.hotelbookingsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entlogics.hotelbookingsystem.dao.HotelDAO;
import com.entlogics.hotelbookingsystem.entity.Hotel;

// this servlet gets information of one hotel , edits a hotel and deletes a hotel
public class ManageHotelInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// creating request dispatcher globally and assigning it null value
	RequestDispatcher dispatcher = null;

	// Instantiating and initializing HotelDAO object
	HotelDAO hotelDao = new HotelDAO();

	// no-arg constructor of ManageHotelInfoController
	public ManageHotelInfoController() {
		super();
	}

	// this method gets a hotel
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getOneHotel(request, response);
	}

	// this method performs the put request by editing a new hotel
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		editHotel(req, resp);
	}

	// this method performs the delete request by deleting a new hotel
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		deleteOneHotel(req, resp);
	}

	// this method gets details of one Hotel - GET /hotels/{hotel-id}
	public void getOneHotel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside controller method getOneHotel()");
		
		// accept id using request object and store it in a variable
		String[] hotelId = request.getPathInfo().split("/");
		
		// using DAO object get all details of a room
		Hotel hotel = hotelDao.getHotelInformation(Integer.parseInt(hotelId[1]));
		
		System.out.println("hotelId value in getOneHotel() -" + hotelId[1]);
		
		// add a room to request obj
		request.setAttribute("hotel", hotel);

		// get the request dispatcher obj and forward it
		dispatcher = request.getRequestDispatcher("/views/view-hotel.jsp");
		dispatcher.forward(request, response);
	}

	// this method edits a hotel record - PUT /hotels/{hotel-id}
	public void editHotel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Inside controller method editHotel()");
		
		// accept id using request object and store it in a variable
		String hotelId = request.getParameter("hotel-id");
		
		// using DAO object get all details of a hotel
		boolean isEdited = hotelDao.editAHotel(Integer.parseInt(hotelId));
		String editedHotel = String.valueOf(isEdited);

		// add a hotel to request obj
		request.setAttribute("Success", editedHotel);

		// get the request dispatcher obj and forward it
		dispatcher = request.getRequestDispatcher("/views/edit-hotel-success.jsp");
		dispatcher.forward(request, response);

	}

	// this method deletes a hotel record - DELETE /hotels/{hotel-id}
	public void deleteOneHotel(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("Inside controller method deleteOneHotel()");
		
		// accept id using request object and store it in a variable
		String hotelId = request.getParameter("hotel-id");

		// call DAO method
		boolean isDeleted = hotelDao.deleteAHotel(Integer.parseInt(hotelId));
		String deletedHotel = String.valueOf(isDeleted);
		
		// using request obj set attribute message
		request.setAttribute("Success", deletedHotel);
	}
}
