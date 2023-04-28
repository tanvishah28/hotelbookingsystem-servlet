package com.entlogics.hotelbookingsystem.entity;

import java.util.ArrayList;
import java.util.List;

//Entity class for hotel - defining the fields, setters & getters and returning toString()

public class Hotel {

	// Defining the fields
	private int hotel_id;

	private String hotel_name;

	private String hotel_location;

	private long hotel_phone;

	private String hotel_rating;

	private String hotel_email;

	private boolean pet_friendly;

	List<Customer> customers = new ArrayList<>();

	List<Room> rooms = new ArrayList<>();

	List<Employee> employees = new ArrayList<>();

	List<Booking> bookings = new ArrayList<>();

	List<Service> services = new ArrayList<>();
	
	// no-arg constructor
	
	public Hotel() {
		super();
	}

	// Constructor for Hotel class

	public Hotel(String hotel_name, String hotel_location) {
		super();
		this.hotel_name = hotel_name;
		this.hotel_location = hotel_location;
	}

	// Generated Setters and getters

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_location() {
		return hotel_location;
	}

	public void setHotel_location(String hotel_location) {
		this.hotel_location = hotel_location;
	}

	public long getHotel_phone() {
		return hotel_phone;
	}

	public void setHotel_phone(long hotel_phone) {
		this.hotel_phone = hotel_phone;
	}

	public String getHotel_rating() {
		return hotel_rating;
	}

	public void setHotel_rating(String hotel_rating) {
		this.hotel_rating = hotel_rating;
	}

	public String getHotel_email() {
		return hotel_email;
	}

	public void setHotel_email(String hotel_email) {
		this.hotel_email = hotel_email;
	}

	public boolean isPet_friendly() {
		return pet_friendly;
	}

	public void setPet_friendly(boolean pet_friendly) {
		this.pet_friendly = pet_friendly;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	// Generate toString()
	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_location=" + hotel_location
				+ ", hotel_phone=" + hotel_phone + ", hotel_rating=" + hotel_rating + ", hotel_email=" + hotel_email
				+ ", pet_friendly=" + pet_friendly + "]";
	}
}
