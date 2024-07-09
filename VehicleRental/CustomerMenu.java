package com.vehicle;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
	private VehicleDAO vehicleDAO;
	private RentalDAO rentalDAO;
	private CustomerDAO customerDAO;

	public CustomerMenu() {
		vehicleDAO = new VehicleDAO();
		rentalDAO = new RentalDAO();
		customerDAO = new CustomerDAO();
	}

	public void displayMenu(Scanner scanner) {
		boolean exit = false;

		while (!exit) {
			System.out.println("\nCustomer Menu:");
			System.out.println("1. View Available Vehicles");
			System.out.println("2. Book a Vehicle");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline left-over

			switch (choice) {
			case 1:
				viewAvailableVehicles();
				break;
			case 2:
				bookVehicle(scanner);
				break;
			case 3:
				exit = true;
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 3.");
				break;
			}
		}
	}

	private void viewAvailableVehicles() {
		List<Vehicle> vehicles = vehicleDAO.getAvailableVehicles();
		if (vehicles.isEmpty()) {
			System.out.println("No vehicles available.");
		} else {
			System.out.println("Available Vehicles:");
			for (Vehicle vehicle : vehicles) {
				System.out.println(vehicle);
			}
		}
	}

	private void bookVehicle(Scanner scanner) {
		System.out.println("Enter vehicle ID to book:");
		int vehicleId = scanner.nextInt();
		scanner.nextLine(); // Consume newline left-over

		Vehicle vehicle = vehicleDAO.getVehicleById(vehicleId);
		if (vehicle == null || !vehicle.isAvailable()) {
			System.out.println("Vehicle not available for booking.");
			return;
		}

		System.out.println("Enter your name:");
		String customerName = scanner.nextLine().trim();
		System.out.println("Enter your phone number:");
		String phoneNumber = scanner.nextLine().trim();
		System.out.println("Enter your license number:");
		String licenseNumber = scanner.nextLine().trim();

		Customer customer = new Customer(customerName, phoneNumber, licenseNumber);
		if (!customerDAO.addCustomer(customer)) {
			System.out.println("Failed to add customer.");
			return;
		}

		Rental rental = new Rental(0, customerName, vehicleId, LocalDate.now());
		if (rentalDAO.addRental(rental)) {
			vehicleDAO.updateVehicleAvailability(vehicleId, false);
			System.out.println(
					"Vehicle booked successfully. Please bring your Licence and original proof when collecting the vehicle. Thank you!");
		} else {
			System.out.println("Failed to book vehicle.");
		}
	}
}
