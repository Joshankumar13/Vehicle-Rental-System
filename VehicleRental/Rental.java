package com.vehicle;

import java.time.LocalDate;

public class Rental {
	private int rentalId;
	private String customerName;
	private int vehicleId;
	private LocalDate bookingDate;

	public Rental(int rentalId, String customerName, int vehicleId, LocalDate bookingDate) {
		this.rentalId = rentalId;
		this.customerName = customerName;
		this.vehicleId = vehicleId;
		this.bookingDate = bookingDate;
	}

	// Getters and setters
	public int getRentalId() {
		return rentalId;
	}

	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
}
