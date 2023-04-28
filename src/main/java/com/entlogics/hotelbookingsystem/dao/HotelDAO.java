package com.entlogics.hotelbookingsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entlogics.hotelbookingsystem.entity.Bill;
import com.entlogics.hotelbookingsystem.entity.Booking;
import com.entlogics.hotelbookingsystem.entity.Customer;
import com.entlogics.hotelbookingsystem.entity.Employee;
import com.entlogics.hotelbookingsystem.entity.Hotel;
import com.entlogics.hotelbookingsystem.entity.Room;
import com.entlogics.hotelbookingsystem.entity.Service;
import com.entlogics.hotelbookingsystem.util.DBConnectionUtil;

// this class performs all the CRUD operations and transfers data from controller to db
public class HotelDAO {

	// Defining properties

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;

	// returns a list of Hotel objects from the db
	public List<Hotel> getAllHotels() {

		System.out.println("Inside HotelDAO getAllHotels()");

		// creating empty list
		List<Hotel> listHotel = new ArrayList<>();

		// Hotel object
		Hotel hotel = null;

		// SQL query
		String sql = "SELECT hotel_id, hotel_name, hotel_location, hotel_phone, hotel_email, hotel_rating, pet_friendly FROM hotel";

		System.out.println("SQL Query in getAllHotels() : " + sql);

		try {
			// Connect to DB
			connection = DBConnectionUtil.openConnection();

			// Fetch all hotel records - Create a statement & Execute the sql query
			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			// iterate through resultSet using while loop
			while (resultSet.next()) {

				// initializing the hotel object
				hotel = new Hotel();

				// setting data from database to hotel object
				hotel.setHotel_id(resultSet.getInt("hotel_id"));
				hotel.setHotel_name(resultSet.getString("hotel_name"));
				hotel.setHotel_location(resultSet.getString("hotel_location"));
				hotel.setHotel_phone(resultSet.getLong("hotel_phone"));
				hotel.setHotel_email(resultSet.getString("hotel_email"));
				hotel.setHotel_rating(resultSet.getString("hotel_rating"));
				hotel.setPet_friendly(resultSet.getBoolean("pet_friendly"));

				// add them to a List
				listHotel.add(hotel);
				System.out.println("Hotel object in getAllHotels() : " + hotel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return the List
		return listHotel;
	}

	// returns a single Hotel object from the db
	public Hotel getHotelInformation(int hotelId) {

		// creating Hotel Object
		Hotel h1 = new Hotel("Taj", "Bangalore");

		// SQL query for getting one hotel
		String sql = "SELECT hotel_id, hotel_name, hotel_location, hotel_phone, hotel_email, hotel_rating, pet_friendly FROM hotel WHERE hotel_id = "
				+ hotelId;

		// Connect to DB

		// Fetch a hotel record

		// add the record to the object

		System.out.println("Inside HotelDAO getHotelInformation()");

		// return the object
		return h1;
	}

	// adds a new hotel record to the db
	public boolean addNewHotel(Hotel h) {

		System.out.println("Inside HotelDAO addNewHotel()");

		boolean isSuccess = false;

		// Get the Hotel object from Controller
		String hotelName = h.getHotel_name();
		String hotelLocation = h.getHotel_location();
		long hotelPhone = h.getHotel_phone();
		String hotelRating = h.getHotel_rating();
		String hotelEmail = h.getHotel_email();
		boolean hotelPetFriendly = h.isPet_friendly();

		System.out.println("Printing hotel object in the HotelDAO " + h);

		try {
			// Get the database connection from openConnection() of DBConnectionUtil class
			connection = DBConnectionUtil.openConnection();

			// using connection object create preparedStatement , passing sql query for
			// inserting data as an arg
			preparedStatement = connection.prepareStatement(
					"INSERT INTO hotel(hotel_name, hotel_location, hotel_phone, hotel_email, hotel_rating, pet_friendly) VALUES (?,?,?,?,?,?)");

			// setting the values for variables using preparedStatement object
			preparedStatement.setString(1, hotelName);
			preparedStatement.setString(2, hotelLocation);
			preparedStatement.setLong(3, hotelPhone);
			preparedStatement.setString(4, hotelEmail);
			preparedStatement.setString(5, hotelRating);
			preparedStatement.setBoolean(6, hotelPetFriendly);

			// executing the preparedStatement object
			preparedStatement.executeUpdate();

			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Send a success message back to Controller
		return isSuccess;
	}

	// edits an existing hotel record from the db
	public boolean editAHotel(int hotelId) {
		boolean isSuccess = false;

		// Get the Hotel object from Controller

		// Connect to the DB

		// preparedStatement = connection.prepareStatement("UPDATE hotel SET
		// pet_friendly = ? WHERE hotel_id = " + hotelId);

		// setting the values for variables using preparedStatement object
		// preparedStatement.setBoolean(1, hotelPetFriendly);

		// Update the Hotel object into hotel table using JDBC update statement

		System.out.println("Inside HotelDAO editAHotel()");

		// Send a success message back to Controller
		return isSuccess;
	}

	// returns a list of Customer of a hotel objects from the db
	public List<Customer> getCustomersOfAHotel(int hotelId) {

		List<Customer> customer = new ArrayList<>();

		// sql query
		String sql = "SELECT customer.customer_id, customer.customer_name, customer.customer_address,customer.customer_phone,customer.customer_email,customer.preferences,"
				+ "customer.special_needs FROM customer JOIN hotel_customer on customer.customer_id = hotel_customer.customer_id WHERE hotel_id = "
				+ hotelId;
		// Connect to DB

		// Fetch all customer records

		// add them to a List

		System.out.println("Inside HotelDAO getCustomersOfAHotel()");

		// return the List
		return customer;
	}

	// links a customer record to a hotel record in the db
	public boolean linkCustomersToAHotel(int hotelId, int customerId) {
		boolean isSuccess = false;

		// Get the Customer object from Controller and link it to Hotel object

		// Connect to the DB

		// preparedStatement = connection.prepareStatement("INSERT INTO hotel_customer
		// (hotel_id, customer_id) VALUES (?,?)");

		// Insert the Customer object into hotel_customer table using JDBC insert
		// statement

		System.out.println("Inside HotelDAO linkCustomersToAHotel()");

		// Send a success message back to Controller
		return isSuccess;
	}

	// returns a single Customer object from the db
	public Customer getCustomerInformation(int hotelId, int customerId) {

		System.out.println("Inside HotelDAO getCustomerInformation()");

		// SQL Query
		String sql = "SELECT c.customer_id, c.customer_name, c.customer_address,c.customer_phone,c.customer_email,c.preferences,c.special_needs,b.booking_id,b.bill_id "
				+ "FROM customer c " + "JOIN hotel_customer hc " + "USING (customer_id) " + "JOIN booking b "
				+ "USING (customer_id) " + "WHERE c.customer_id =" + customerId + " AND hc.hotel_id = " + hotelId;

		System.out.println("SQL Query in getCustomerInformation() : " + sql);

		// customer object
		Customer customer = null;

		// initializing the customer object
		customer = new Customer();

		// Initializing lists
		List<Booking> listBooking = new ArrayList<>();
		List<Bill> listBill = new ArrayList<>();

		try {
			// Connect to DB
			connection = DBConnectionUtil.openConnection();

			// Fetch a customer record - Create a statement & Execute the sql query
			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			System.out.println("Size of resultSet: " + resultSet.getFetchSize());

			int rowCtr = 0;

			// Iterate over the resultSet
			while (resultSet.next()) {

				System.out.println("Inside while loop");

				int id = customer.getCustomer_id();

				System.out.println("ID outside if : " + id);

				rowCtr++;
				if (id == 0) {
					System.out.println("ID inside if : " + id);
					// For each record in the resultSet
					customer.setCustomer_id(resultSet.getInt("customer_id"));
					customer.setCustomer_name(resultSet.getString("customer_name"));
					customer.setCustomer_address(resultSet.getString("customer_address"));
					customer.setCustomer_phone(resultSet.getLong("customer_phone"));
					customer.setCustomer_email(resultSet.getString("customer_email"));
					customer.setPreferences(resultSet.getString("preferences"));
					customer.setSpecial_needs(resultSet.getString("special_needs"));
				}

				// create booking object and set id , add booking obj in the list
				Booking booking = new Booking();
				booking.setBooking_id(resultSet.getInt("booking_id"));
				listBooking.add(booking);

				System.out.println("Booking object in getCustomerInformation(): " + booking);

				// create bill object and set id , add bill obj in the list
				Bill bill = new Bill();
				bill.setBill_id(resultSet.getInt("bill_id"));
				listBill.add(bill);

				System.out.println("Bill object in getCustomerInformation(): " + bill);
			}

			// setting the list of booking & bill in customer object
			customer.setBookings(listBooking);
			customer.setBills(listBill);

			System.out.println("Customer object in getCustomerInformation(): " + customer);
			System.out.println("Total number of rows in ResultSet object: " + rowCtr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return the object
		return customer;
	}

	// returns a list of Employee objects from the db
	public List<Employee> getEmployeesOfAHotel(int hotelId) {

		List<Employee> employee = new ArrayList<>();

		// SQL Query
		String sql = "SELECT emp_id, emp_name, emp_salary, emp_phone, emp_address, emp_email, joining_date, hotel_id FROM employee WHERE hotel_id = "
				+ hotelId;

		// Connect to DB

		// Fetch all employee records

		// add them to a List

		System.out.println("Inside HotelDAO getEmployeesOfAHotel()");

		// return the List
		return employee;
	}

	// returns a list of Service objects from the db
	public List<Service> getServicesOfAHotel(int hotelId) {

		List<Service> service = new ArrayList<>();

		// SQL Query
		String sql = "SELECT s.service_id, s.service_name FROM service s JOIN hotel_service hs ON s.service_id = hs.service_id WHERE hs.hotel_id = "
				+ hotelId;

		// Connect to DB

		// Fetch all service records

		// add them to a List

		System.out.println("Inside HotelDAO getServicesOfAHotel()");

		// return the List
		return service;
	}

	// returns a list of Booking objects from the db
	public List<Booking> getBookingsOfAHotel(int hotelId) {

		List<Booking> booking = new ArrayList<>();

		// SQL Query
		String sql = "SELECT b.booking_id, b.booking_dateTime, b.booking_amt, b.check_in_DateTime, b.check_out_DateTime, b.no_of_adults, b.no_of_child, "
				+ "b.booking_status, b.hotel_id, b.customer_id, b.bill_id, b.room_id, b.emp_id, bs.service_id FROM booking b JOIN booking_service bs ON "
				+ "b.booking_id = bs.booking_id WHERE b.hotel_id = " + hotelId;

		// Connect to DB

		// Fetch all booking records

		// add them to a List

		System.out.println("Inside HotelDAO getBookingsOfAHotel()");

		// return the List
		return booking;
	}

	// links a service record to a hotel record in the db
	public boolean linkServicesToAHotel(int hotelId, int serviceId) {
		boolean isSuccess = false;

		// Get the Service object from Controller and link it to Hotel object

		// Connect to the DB

		// preparedStatement = connection.prepareStatement("INSERT INTO hotel_service
		// (hotel_id, service_id) VALUES (?,?)");

		// Insert the Service object into hotel_service table using JDBC insert
		// statement

		System.out.println("Inside HotelDAO linkServicesToAHotel()");

		// Send a success message back to Controller
		return isSuccess;
	}

	// returns a list of Room objects from the db
	public List<Room> getRoomsOfAHotel(int hotelId) {

		List<Room> room = new ArrayList<>();

		// SQL Query
		String sql = "SELECT room_id, room_no, room_type, room_price, floor_no, area_of_room, occupancy_details, hotel_id FROM room WHERE hotel_id = "
				+ hotelId;

		// Connect to DB

		// Fetch all room records

		// add them to a List

		System.out.println("Inside HotelDAO getRoomsOfAHotel()");

		// return the List
		return room;
	}

	// returns a single Room object from the db
	public Room getRoomInformation(int hotelId, int roomId) {

		// SQL Query
		String sql = "SELECT r.room_id, r.room_no, r.room_type, r.room_price, r.floor_no, r.area_of_room, r.occupancy_details, r.hotel_id, b.booking_id "
				+ "FROM room r JOIN booking b ON r.room_id = b.room_id WHERE r.hotel_id = " + hotelId
				+ " AND r.room_id = " + roomId;

		// Connect to DB

		// Fetch a room record

		// add the record to the object

		System.out.println("Inside HotelDAO getRoomInformation()");

		// return the object
		return new Room();
	}

	// adds a new room record in the Hotel to the db
	public boolean addNewRoomToAHotel(int hotelId, Room r) {
		boolean isSuccess = false;

		// Get the Room object from Controller

		// Connect to the DB

		/*
		 * preparedStatement = connection.prepareStatement(
		 * "INSERT INTO room (room_no, room_type, room_price, floor_no, area_of_room, occupancy_details, hotel_id) VALUES (?,?,?,?,?,?,?)"
		 * );
		 */

		// Insert the Room object into room table using JDBC insert statement

		System.out.println("Inside HotelDAO addNewRoomToAHotel()");

		// Send a success message back to Controller
		return isSuccess;
	}

	// edits an existing room record from the db
	public boolean editARoomOfAHotel(int hotelId, int roomId) {
		boolean isSuccess = false;

		// Get the Room object from Controller

		// Connect to the DB

		// preparedStatement = connection.prepareStatement("UPDATE room SET room_price =
		// ? WHERE room_id = " + roomId + " AND hotel_id = " + hotelId);

		// setting the values for variables using preparedStatement object
		// preparedStatement.setBoolean(1, room_price);

		// Update the Room object into room table using JDBC update statement

		System.out.println("Inside HotelDAO editARoomOfAHotel()");

		// Send a success message back to Controller
		return isSuccess;
	}

	// deletes a room record from the db
	public boolean deleteARoomOfAHotel(int hotelId, int roomId) {
		boolean isSuccess = false;

		// SQL Query
		String sql = "DELETE FROM room WHERE hotel_id = " + hotelId + "AND room_id = " + roomId;

		// Get the Room object from Controller

		// Connect to the DB

		// Delete the Room object from room table using JDBC delete statement

		System.out.println("Inside HotelDAO deleteARoomOfAHotel()");

		// Send a success message back to Controller
		return isSuccess;
	}

	// deletes a hotel record from the db
	public boolean deleteAHotel(int hotelId) {
		boolean isSuccess = false;

		// SQL Query
		String sql = "DELETE FROM hotel WHERE hotel_id = " + hotelId;

		// Get the Hotel object from Controller

		// Connect to the DB

		// Delete the Hotel object from hotel table using JDBC delete statement

		System.out.println("Inside HotelDAO deleteAHotel()");

		// Send a success message back to Controller
		return isSuccess;
	}
}
