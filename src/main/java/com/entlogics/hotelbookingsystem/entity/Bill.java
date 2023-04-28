package com.entlogics.hotelbookingsystem.entity;

import java.util.Date;

//Entity class for Bill - defining the fields, setters & getters and returning toString()

public class Bill {

	// Defining the fields
	private int bill_id;

	private int bill_number;

	private float bill_amt;

	private Date bill_dateTime;

	private float discount;

	private int bill_reward_points;

	enum bill_status {
		PAID, NOT_PAID, PARTIALLY_PAID;
	}

	enum payment_method {
		CASH, DEBIT, CREDIT;
	}

	// no-arg constructor
	
	public Bill() {
		super();
	}

	// Constructor for Bill entity
	public Bill(int bill_number, float bill_amt) {
		super();
		this.bill_number = bill_number;
		this.bill_amt = bill_amt;
	}

	// Generated getters and setters

	public int getBill_id() {
		return bill_id;
	}

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	public int getBill_number() {
		return bill_number;
	}

	public void setBill_number(int bill_number) {
		this.bill_number = bill_number;
	}

	public float getBill_amt() {
		return bill_amt;
	}

	public void setBill_amt(float bill_amt) {
		this.bill_amt = bill_amt;
	}

	public Date getBill_dateTime() {
		return bill_dateTime;
	}

	public void setBill_dateTime(Date bill_dateTime) {
		this.bill_dateTime = bill_dateTime;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public int getBill_reward_points() {
		return bill_reward_points;
	}

	public void setBill_reward_points(int bill_reward_points) {
		this.bill_reward_points = bill_reward_points;
	}

	// Generate toString()

	@Override
	public String toString() {
		return "Bill [bill_id=" + bill_id + ", bill_number=" + bill_number + ", bill_amt=" + bill_amt
				+ ", bill_dateTime=" + bill_dateTime + ", discount=" + discount + ", bill_reward_points="
				+ bill_reward_points + "]";
	}
}
