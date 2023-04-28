package com.entlogics.hotelbookingsystem.entity;

import java.util.ArrayList;
import java.util.List;

//Entity class for Service - defining the fields, setters & getters and returning toString()

public class Service {
	// Defining the fields
	private int service_id;

	private String service_name;

	List<Hotel> hotels = new ArrayList<>();

	List<Booking> bookings = new ArrayList<>();

	// no-arg constructor

	public Service() {
		super();
	}

	// Constructor for Customer class

	public Service(String service_name) {
		super();
		this.service_name = service_name;
	}

	// Generated Setters and getters

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	// Generate toString()

	@Override
	public String toString() {
		return "Service [service_id=" + service_id + ", service_name=" + service_name + "]";
	}
}
