package com.vehicle;

public class Vehicle {
	private int id;
	private String brand;
	private String model;
	private String condition;
	private double pricePerHour;
	private boolean available;

	public Vehicle(int id, String brand, String model, String condition, double pricePerHour, boolean available) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.condition = condition;
		this.pricePerHour = pricePerHour;
		this.available = available;
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Vehicle{" + "id=" + id + ", brand='" + brand + '\'' + ", model='" + model + '\'' + ", condition='"
				+ condition + '\'' + ", pricePerHour=" + pricePerHour + ", available=" + available + '}';
	}
}
