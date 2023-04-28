package com.entlogics.hotelbookingsystem.entity;

import java.util.ArrayList;
import java.util.List;

//Entity class for Room - defining the fields, setters & getters and returning toString()

public class Room {

	// Defining the fields
	private int room_id;

	private String room_type;

	private float room_price;

	private int room_no;

	private int floor_no;

	private float area_of_room;

	private int occupancy_details;

	private Hotel hotel;

	List<Booking> bookings = new ArrayList<>();
	
	// no-arg constructor
	
	public Room() {
		super();
	}

	// Constructor for Customer class

	public Room(String room_type, float room_price) {
		super();
		this.room_type = room_type;
		this.room_price = room_price;
	}

	// Generated Setters and getters

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public float getRoom_price() {
		return room_price;
	}

	public void setRoom_price(float room_price) {
		this.room_price = room_price;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public int getFloor_no() {
		return floor_no;
	}

	public void setFloor_no(int floor_no) {
		this.floor_no = floor_no;
	}

	public float getArea_of_room() {
		return area_of_room;
	}

	public void setArea_of_room(float area_of_room) {
		this.area_of_room = area_of_room;
	}

	public int getOccupancy_details() {
		return occupancy_details;
	}

	public void setOccupancy_details(int occupancy_details) {
		this.occupancy_details = occupancy_details;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
		return "Room [room_id=" + room_id + ", room_type=" + room_type + ", room_price=" + room_price + ", room_no="
				+ room_no + ", floor_no=" + floor_no + ", area_of_room=" + area_of_room + ", occupancy_details="
				+ occupancy_details + ", hotel=" + hotel + "]";
	}
}
