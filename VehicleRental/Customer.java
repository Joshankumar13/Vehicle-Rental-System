package com.vehicle;

public class Customer {
	private String name;
	private String phoneNumber;
	private String licenseNumber;

	public Customer(String name, String phoneNumber, String licenseNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.licenseNumber = licenseNumber;
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
}
