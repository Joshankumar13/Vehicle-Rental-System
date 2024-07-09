package com.vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalDAO {
	private Connection connection;

	public RentalDAO() {
		try {
			connection = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean addRental(Rental rental) {
		String sql = "INSERT INTO rentals (customer_name, vehicle_id, booking_date) VALUES (?, ?, ?)";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, rental.getCustomerName());
			pstmt.setInt(2, rental.getVehicleId());
			pstmt.setDate(3, java.sql.Date.valueOf(rental.getBookingDate()));
			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeRentalByCustomerName(String customerName) throws SQLException {
		String sql = "DELETE FROM rentals WHERE customer_name = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, customerName);
			int affectedRows = stmt.executeUpdate();
			return affectedRows > 0;
		}
	}

	public List<Rental> getAllRentals() {
		List<Rental> rentals = new ArrayList<>();
		String sql = "SELECT * FROM rentals";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int rentalId = rs.getInt("rental_id");
				String customerName = rs.getString("customer_name");
				int vehicleId = rs.getInt("vehicle_id");
				LocalDate bookingDate = rs.getDate("booking_date").toLocalDate();
				Rental rental = new Rental(rentalId, customerName, vehicleId, bookingDate);
				rentals.add(rental);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rentals;
	}

	public List<Rental> getAllRentalsByCustomer(String customerName) {
		List<Rental> rentals = new ArrayList<>();
		String sql = "SELECT * FROM rentals WHERE customer_name = ?";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, customerName);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int rentalId = rs.getInt("rental_id");
				String customerNameFetched = rs.getString("customer_name");
				int vehicleId = rs.getInt("vehicle_id");
				LocalDate bookingDate = rs.getDate("booking_date").toLocalDate();
				Rental rental = new Rental(rentalId, customerNameFetched, vehicleId, bookingDate);
				rentals.add(rental);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rentals;
	}
}
