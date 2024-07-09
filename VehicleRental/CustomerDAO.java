package com.vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAO {
	private Connection con;

	public CustomerDAO() {
		try {
			con = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean addCustomer(Customer customer) {
		String sql = "INSERT INTO customers (name, phone_number, license_number) VALUES (?, ?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getPhoneNumber());
			pstmt.setString(3, customer.getLicenseNumber());
			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeCustomerBooking(String customerName) {
		String sql = "DELETE FROM rentals WHERE customer_name = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, customerName);
			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
