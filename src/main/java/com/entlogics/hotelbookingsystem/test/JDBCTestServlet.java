package com.entlogics.hotelbookingsystem.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JDBCTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JDBCTestServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.Define the fields
		String username = "hoteldbuser";
		String password = "tanvi";
		String jdbcURL = "jdbc:mysql://localhost:3306/hoteldb";
		String driver = "com.mysql.jdbc.Driver";

		try {
			// 2. Get the PrintWriter Object
			PrintWriter writer = response.getWriter();
			writer.println("Connecting to database- " + jdbcURL);

			// 3. Load the driver
			Class.forName(driver);

			// 4. Get the connection
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			writer.println("Connection successful");

			// 5. Close the connection
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
