package com.entlogics.hotelbookingsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entlogics.hotelbookingsystem.dao.HotelDAO;
import com.entlogics.hotelbookingsystem.entity.Room;

//this servlet gets information of one room of a hotel , edits a room and deletes a room - this servlet will handle the /hotels/{hotel-id}/rooms/{room-id} EndPoint

public class ManageHotelRoomInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// creating request dispatcher globally and assigning it null value
	RequestDispatcher dispatcher = null;

	// Instantiating and initializing HotelDAO object
	HotelDAO hotelDao = new HotelDAO();

	// no-arg constructor of ManageHotelRoomInfoController
	public ManageHotelRoomInfoController() {
		super();
	}

	// this method performs get request by getting a room

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getOneRoomOfOneHotel(request, response);
	}

	// this method performs put request by editing a room

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		editRoomOfOneHotel(req, resp);
	}

	// this method performs delete request by deleting a room

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		deleteRoomOfOneHotel(req, resp);
	}

	// this method gets information of a single room of a hotel

	public void getOneRoomOfOneHotel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside controller method getOneRoomOfOneHotel()");

		// accept id using request object and store it in a variable - getting the path parameter using getPathInfo & splitting the url 
		String[] hotelId = request.getPathInfo().split("/");
		String[] roomId = request.getPathInfo().split("/");

		// using DAO object get all details of a room
		Room room = hotelDao.getRoomInformation(Integer.parseInt(hotelId[1]), Integer.parseInt(roomId[2]));

		// add a room to request obj
		request.setAttribute("room", room);

		// get the request dispatcher obj and forward it
		dispatcher = request.getRequestDispatcher("/views/view-hotel-room.jsp");
		dispatcher.forward(request, response);
	}

	// this method edits details of a room

	public void editRoomOfOneHotel(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Inside controller method editRoomOfOneHotel()");

		// accept id using request object and store it in a variable
		String hotelId = req.getParameter("hotel-id");
		String roomId = req.getParameter("room-id");

		// using DAO object get all details of a room
		boolean isRoomEdited = hotelDao.editARoomOfAHotel(Integer.parseInt(hotelId), Integer.parseInt(roomId));
		String editedRoom = String.valueOf(isRoomEdited);

		// add a room to request obj
		req.setAttribute("Success", editedRoom);

		// get the request dispatcher obj and forward it
		dispatcher = req.getRequestDispatcher("/views/edit-hotel-room-success.jsp");
		dispatcher.forward(req, resp);
	}

	// this method deletes a room

	public void deleteRoomOfOneHotel(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("Inside controller method deleteRoomOfOneHotel()");

		// accept id using request object and store it in a variable
		String hotelId = req.getParameter("hotel-id");
		String roomId = req.getParameter("room-id");

		// call DAO method
		boolean isRoomDeleted = hotelDao.deleteARoomOfAHotel(Integer.parseInt(hotelId), Integer.parseInt(roomId));
		String deletedRoom = String.valueOf(isRoomDeleted);

		// using request obj set attribute message
		req.setAttribute("Success", deletedRoom);
	}
}
