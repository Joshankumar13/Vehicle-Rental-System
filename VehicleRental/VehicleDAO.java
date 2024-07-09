package com.vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
	private Connection con;

	public VehicleDAO() {
		try {
			con = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean addVehicle(Vehicle vehicle) {
		String sql = "INSERT INTO vehicles (id, brand, model, vehicle_condition, price_per_hour, available) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, vehicle.getId());
			pstmt.setString(2, vehicle.getBrand());
			pstmt.setString(3, vehicle.getModel());
			pstmt.setString(4, vehicle.getCondition());
			pstmt.setDouble(5, vehicle.getPricePerHour());
			pstmt.setBoolean(6, vehicle.isAvailable());
			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeVehicle(int vehicleId) {
		String sql = "DELETE FROM vehicles WHERE id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, vehicleId);
			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateVehicleAvailability(int vehicleId, boolean available) {
		String sql = "UPDATE vehicles SET available = ? WHERE id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setBoolean(1, available);
			pstmt.setInt(2, vehicleId);
			int rowsAffected = pstmt.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehicles = new ArrayList<>();
		String sql = "SELECT * FROM vehicles";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String brand = rs.getString("brand");
				String model = rs.getString("model");
				String condition = rs.getString("vehicle_condition");
				double pricePerHour = rs.getDouble("price_per_hour");
				boolean available = rs.getBoolean("available");
				Vehicle vehicle = new Vehicle(id, brand, model, condition, pricePerHour, available);
				vehicles.add(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicles;
	}

	public Vehicle getVehicleById(int vehicleId) {
		String sql = "SELECT * FROM vehicles WHERE id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, vehicleId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String brand = rs.getString("brand");
				String model = rs.getString("model");
				String condition = rs.getString("vehicle_condition");
				double pricePerHour = rs.getDouble("price_per_hour");
				boolean available = rs.getBoolean("available");
				return new Vehicle(id, brand, model, condition, pricePerHour, available);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Vehicle> getAvailableVehicles() {
		List<Vehicle> vehicles = new ArrayList<>();
		String sql = "SELECT * FROM vehicles WHERE available = true";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String brand = rs.getString("brand");
				String model = rs.getString("model");
				String condition = rs.getString("vehicle_condition");
				double pricePerHour = rs.getDouble("price_per_hour");
				boolean available = rs.getBoolean("available");
				Vehicle vehicle = new Vehicle(id, brand, model, condition, pricePerHour, available);
				vehicles.add(vehicle);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicles;
	}
}
