package com.entlogics.hotelbookingsystem.entity;

import java.util.ArrayList;
import java.util.List;

//Entity class for Customer - defining the fields, setters & getters and returning toString()

public class Customer {

	// Defining the fields
	private int customer_id;

	private String customer_name;

	private String customer_address;

	private long customer_phone;

	private String customer_email;

	private String preferences;

	private String special_needs;

	List<Booking> bookings = new ArrayList<>();

	List<Bill> bills = new ArrayList<>();

	List<Hotel> hotels = new ArrayList<>();

	// no-arg constructor

	public Customer() {
		super();
	}

	// Parameterized Constructor for Customer class

	public Customer(String customer_name, String customer_address) {
		super();
		this.customer_name = customer_name;
		this.customer_address = customer_address;
	}

	// Generated Setters and getters

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public long getCustomer_phone() {
		return customer_phone;
	}

	public void setCustomer_phone(long customer_phone) {
		this.customer_phone = customer_phone;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public String getSpecial_needs() {
		return special_needs;
	}

	public void setSpecial_needs(String special_needs) {
		this.special_needs = special_needs;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	// Generate toString()

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_address="
				+ customer_address + ", customer_phone=" + customer_phone + ", customer_email=" + customer_email
				+ ", preferences=" + preferences + ", special_needs=" + special_needs + "]";
	}
}
