package com.entlogics.hotelbookingsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entlogics.hotelbookingsystem.dao.HotelDAO;
import com.entlogics.hotelbookingsystem.entity.Room;

//This servlet gets the list of rooms and adds a new room to a hotel - this servlet will handle the /hotels/{hotel-id}/rooms EndPoint

public class ManageHotelRoomsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// creating request dispatcher globally and assigning it null value
	RequestDispatcher dispatcher = null;

	// Instantiating and initializing HotelDAO object
	HotelDAO hotelDao = new HotelDAO();

	// no-arg constructor of ManageHotelRoomsController
	public ManageHotelRoomsController() {
		super();
	}

	// this method performs get request by getting list of rooms

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getRoomsOfOneHotel(request, response);
	}

	// this method performs post request by adding room

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		addNewRoomToOneHotel(request, response);
	}

	// this method gets list of rooms of a hotel

	public void getRoomsOfOneHotel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside controller method getRoomsOfOneHotel()");

		// accept id using request object and store it in a variable
		String[] hotelId = request.getPathInfo().split("/");

		// call DAO method to get list of rooms
		List<Room> roomList = hotelDao.getRoomsOfAHotel(Integer.parseInt(hotelId[1]));

		// adding the list of rooms to request object
		request.setAttribute("roomList", roomList);

		// get the request dispatcher obj and forward it
		dispatcher = request.getRequestDispatcher("/views/list-hotel-rooms.jsp");
		dispatcher.forward(request, response);
	}

	// this method adds a new room to a Hotel

	public void addNewRoomToOneHotel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside controller method addNewRoomToOneHotel()");

		// get the room details from request object
		String roomType = request.getParameter("room-type");
		String roomPrice = request.getParameter("room-price");

		// accept id using request object and store it in a variable
		String[] hotelId = request.getPathInfo().split("/");

		// creating Room object
		Room room = new Room(roomType, Float.parseFloat(roomPrice));

		// call DAO method to add room
		boolean isRoomAdded = hotelDao.addNewRoomToAHotel(Integer.parseInt(hotelId[1]), room);
		String roomAdded = String.valueOf(isRoomAdded);

		// send success message back to the client
		request.setAttribute("Success", roomAdded);

		// get the request dispatcher obj and forward it
		dispatcher = request.getRequestDispatcher("/views/add-hotel-room-success.jsp");
		dispatcher.forward(request, response);
	}
}
