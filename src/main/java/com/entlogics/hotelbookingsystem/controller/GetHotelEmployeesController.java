package com.entlogics.hotelbookingsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entlogics.hotelbookingsystem.dao.HotelDAO;
import com.entlogics.hotelbookingsystem.entity.Employee;

//this servlet gets information of all employees of a hotel - it will handle the /hotels/{hotel-id}/employees EndPoint

public class GetHotelEmployeesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// creating request dispatcher globally and assigning it null value
	RequestDispatcher dispatcher = null;

	// Instantiating and initializing HotelDAO object
	HotelDAO hotelDao = new HotelDAO();

	// no-arg constructor of GetHotelEmployeesController
	public GetHotelEmployeesController() {
		super();
	}

	// this method performs get request by getting employees of a hotel
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		getEmployeesOfOneHotel(request, response);
	}

	// this method gets the list of employees of a hotel
	
	public void getEmployeesOfOneHotel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Inside controller method getEmployeesOfOneHotel()");
		
		// accept id using request object and store it in a variable
		String[] hotelId = request.getPathInfo().split("/");

		// using DAO object get details of all employees
		List<Employee> employeeList = hotelDao.getEmployeesOfAHotel(Integer.parseInt(hotelId[1]));

		// add employee to request obj
		request.setAttribute("employeeList", employeeList);

		// get the request dispatcher obj and forward it
		dispatcher = request.getRequestDispatcher("/views/list-hotel-employees.jsp");
		dispatcher.forward(request, response);
	}
}
