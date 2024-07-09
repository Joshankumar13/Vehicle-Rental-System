package com.vehicle;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AdminDAO adminDAO = new AdminDAO();

		System.out.println("Welcome to Vehicle Rental System:)");

		while (true) {
			System.out.println();
			System.out.println("1. Admin Login");
			System.out.println("2. Customer Menu");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline left-over

			switch (choice) {
			case 1:
				System.out.print("Enter username: ");
				String username = scanner.nextLine().trim();
				System.out.print("Enter password: ");
				String password = scanner.nextLine().trim();

				if (adminDAO.AdminLoginCheck(username, password)) {
					AdminMenu adminMenu = new AdminMenu();
					System.out.println("Welcome Admin, " + username + "!");
					adminMenu.displayMenu(scanner);
				} else {
					System.out.println("Invalid admin credentials.");
				}
				break;
			case 2:
				CustomerMenu customerMenu = new CustomerMenu();
				customerMenu.displayMenu(scanner);
				break;
			case 3:
				System.out.println("Exiting the Application, Thank you!...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 3.");
				break;
			}
		}
	}
}
