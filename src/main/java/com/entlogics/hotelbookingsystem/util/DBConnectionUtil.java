package com.entlogics.hotelbookingsystem.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnectionUtil {
	// Define Database properties
	private static Properties properties;

	private static String URL;

	private static String DRIVER;

	private static String USERNAME;

	private static String PASSWORD;

	private static Connection connection;

	// Define the static method for getting the database connection, it will return
	// connection object
	public static Connection openConnection() throws IOException {

		// instantiating the properties
		properties = new Properties();

		// reading the properties file
		InputStream fileInput = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");

		// loading the file
		properties.load(fileInput);

		// URL of database
		URL = properties.getProperty("url");
		System.out.println("url is : " + URL);

		// MySQL DRIVER
		DRIVER = properties.getProperty("driver");
		System.out.println("driver is : " + DRIVER);

		// UserName of database
		USERNAME = properties.getProperty("username");
		System.out.println("username is : " + USERNAME);

		// password of database user
		PASSWORD = properties.getProperty("password");
		System.out.println("password is : " + PASSWORD);

		try {
			// Load the driver
			Class.forName(DRIVER);

			// Get the connection
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (Exception e) {
			e.printStackTrace();
		}
		// return Connection
		return connection;
	}
}
