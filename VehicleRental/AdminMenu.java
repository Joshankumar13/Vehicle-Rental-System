package com.vehicle;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
	private VehicleDAO vehicleDAO;
	private RentalDAO rentalDAO;

	public AdminMenu() {
		vehicleDAO = new VehicleDAO();
		rentalDAO = new RentalDAO();
	}

	public void displayMenu(Scanner scanner) {
		boolean loggedIn = true;

		while (loggedIn) {
			System.out.println("\nAdmin Menu:");
			System.out.println("1. Add Vehicle");
			System.out.println("2. Remove Vehicle");
			System.out.println("3. View All Vehicles");
			System.out.println("4. View Booked Vehicles");
			System.out.println("5. Update Booked Vehicles");
			System.out.println("6. Logout");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline left-over

			switch (choice) {
			case 1:
				addVehicle(scanner);
				break;
			case 2:
				removeVehicle(scanner);
				break;
			case 3:
				viewAllVehicles();
				break;
			case 4:
				viewBookedVehicles();
				break;
			case 5:
				updateBookedVehicles(scanner);
				break;
			case 6:
				loggedIn = false;
				System.out.println("Logged out successfully...");
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 6.");
				break;
			}
		}
	}

	private void addVehicle(Scanner scanner) {
		System.out.println("Enter vehicle ID:");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume newline left-over
		System.out.println("Enter brand:");
		String brand = scanner.nextLine().trim();
		System.out.println("Enter model:");
		String model = scanner.nextLine().trim();
		System.out.println("Enter condition:");
		String condition = scanner.nextLine().trim();
		System.out.println("Enter price per hour:");
		double pricePerHour = scanner.nextDouble();

		Vehicle vehicle = new Vehicle(id, brand, model, condition, pricePerHour, true);
		if (vehicleDAO.addVehicle(vehicle)) {
			System.out.println("Vehicle added successfully.");
		} else {
			System.out.println("Failed to add vehicle.");
		}
	}

	private void removeVehicle(Scanner scanner) {
		System.out.println("Enter vehicle ID:");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume newline left-over

		if (vehicleDAO.removeVehicle(id)) {
			System.out.println("Vehicle removed successfully.");
		} else {
			System.out.println("Failed to remove vehicle.");
		}
	}

	private void viewAllVehicles() {
		List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
		if (vehicles.isEmpty()) {
			System.out.println("No vehicles available.");
		} else {
			System.out.println("All Vehicles:");
			for (Vehicle vehicle : vehicles) {
				System.out.println(vehicle);
			}
		}
	}

	private void viewBookedVehicles() {
		List<Rental> rentals = rentalDAO.getAllRentals();
		if (rentals.isEmpty()) {
			System.out.println("No vehicles booked.");
		} else {
			System.out.println("Booked Vehicles:");
			for (Rental rental : rentals) {
				Vehicle vehicle = vehicleDAO.getVehicleById(rental.getVehicleId());
				if (vehicle != null) {
					System.out.println("Vehicle ID: " + vehicle.getId() + ", Brand: " + vehicle.getBrand() + ", Model: "
							+ vehicle.getModel() + ", Booked by: " + rental.getCustomerName() + ", Booking Date: "
							+ rental.getBookingDate());
				}
			}
		}
	}

	private void updateBookedVehicles(Scanner scanner) {
		try {
			List<Rental> rentals = rentalDAO.getAllRentals();
			if (rentals.isEmpty()) {
				System.out.println("No vehicles booked.");
				return;
			}

			System.out.println("Booked Customers:");
			for (Rental rental : rentals) {
				System.out.println("Customer: " + rental.getCustomerName());
			}

			System.out.print("Enter the customer name to remove booking: ");
			String customerName = scanner.nextLine();

			boolean removed = rentalDAO.removeRentalByCustomerName(customerName);
			if (removed) {
				System.out.println("Booking removed successfully.");
			} else {
				System.out.println("Booking not found for customer: " + customerName);
			}
		} catch (SQLException e) {
			System.out.println("Error updating booked vehicles: " + e.getMessage());
		}
	}
}