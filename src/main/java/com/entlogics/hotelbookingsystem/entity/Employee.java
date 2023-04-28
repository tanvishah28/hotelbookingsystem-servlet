package com.entlogics.hotelbookingsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Entity class for Employee - defining the fields, setters & getters and returning toString()

public class Employee {

	// Defining the fields
	private int emp_id;

	private String emp_name;

	private String emp_salary;

	private long emp_phone;

	private String emp_address;

	private String emp_email;

	private Date joining_date;

	private Hotel hotel_id;

	List<Customer> customers = new ArrayList<>();

	List<Booking> bookings = new ArrayList<>();
	
	// no-arg constructor
	
	public Employee() {
		super();
	}
	
	// Constructor for Customer class

	public Employee(String emp_name, String emp_salary) {
		super();
		this.emp_name = emp_name;
		this.emp_salary = emp_salary;
	}

	// Generated Setters and getters

	public int getEmp_id() {
		return emp_id;
	}
	
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(String emp_salary) {
		this.emp_salary = emp_salary;
	}

	public long getEmp_phone() {
		return emp_phone;
	}

	public void setEmp_phone(long emp_phone) {
		this.emp_phone = emp_phone;
	}

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public Hotel getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(Hotel hotel_id) {
		this.hotel_id = hotel_id;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
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
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_salary=" + emp_salary + ", emp_phone="
				+ emp_phone + ", emp_address=" + emp_address + ", emp_email=" + emp_email + ", joining_date="
				+ joining_date + ", hotel_id=" + hotel_id + "]";
	}
}
