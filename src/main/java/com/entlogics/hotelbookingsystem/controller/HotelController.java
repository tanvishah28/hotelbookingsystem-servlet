package com.entlogics.hotelbookingsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// this servlet will transfer the request to add-hotel jsp 
public class HotelController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HotelController() {
		super();
	}

	// this get request will forward the request to add hotel jsp page
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// creating RequestDispatcher object and forwarding it to add-hotel jsp using forward()

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/add-hotel.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
