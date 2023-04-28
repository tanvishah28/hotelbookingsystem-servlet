package com.entlogics.hotelbookingsystem.entity;

import java.util.ArrayList;
import java.util.List;

//Entity class for Booking - defining the fields, setters & getters and returning toString()

public class Booking {

	// Defining the fields
	private int booking_id;

	private String booking_dateTime;

	private long booking_amt;

	private String check_in_DateTime;

	private String check_out_DateTime;

	private boolean no_of_adults;

	private boolean no_of_child;

	enum booking_status {
		CANCELLED, POSTPONED, NO_SHOW, COMPLTED;
	}

	private Hotel hotel;

	private Customer customer;

	private Room room;

	private Employee employee;

	private Bill bill;

	List<Service> services = new ArrayList<>();

	// no-arg constructor

	public Booking() {
		super();
	}

	// Constructor for Booking entity

	public Booking(String booking_dateTime, long booking_amt) {
		super();
		this.booking_dateTime = booking_dateTime;
		this.booking_amt = booking_amt;
	}

	// Generated getters and setters

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getBooking_dateTime() {
		return booking_dateTime;
	}

	public void setBooking_dateTime(String booking_dateTime) {
		this.booking_dateTime = booking_dateTime;
	}

	public long getBooking_amt() {
		return booking_amt;
	}

	public void setBooking_amt(long booking_amt) {
		this.booking_amt = booking_amt;
	}

	public String getCheck_in_DateTime() {
		return check_in_DateTime;
	}

	public void setCheck_in_DateTime(String check_in_DateTime) {
		this.check_in_DateTime = check_in_DateTime;
	}

	public String getCheck_out_DateTime() {
		return check_out_DateTime;
	}

	public void setCheck_out_DateTime(String check_out_DateTime) {
		this.check_out_DateTime = check_out_DateTime;
	}

	public boolean isNo_of_adults() {
		return no_of_adults;
	}

	public void setNo_of_adults(boolean no_of_adults) {
		this.no_of_adults = no_of_adults;
	}

	public boolean isNo_of_child() {
		return no_of_child;
	}

	public void setNo_of_child(boolean no_of_child) {
		this.no_of_child = no_of_child;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
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
		return "Booking [booking_id=" + booking_id + ", booking_dateTime=" + booking_dateTime + ", booking_amt="
				+ booking_amt + ", check_in_DateTime=" + check_in_DateTime + ", check_out_DateTime="
				+ check_out_DateTime + ", no_of_adults=" + no_of_adults + ", no_of_child=" + no_of_child + ", hotel="
				+ hotel + ", customer=" + customer + ", room=" + room + ", employee=" + employee + ", bill=" + bill
				+ "]";
	}
}
