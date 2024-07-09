package com.vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
	private Connection con;

	public AdminDAO() {
		try {
			con = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean AdminLoginCheck(String username, String password) {
		String sql = "SELECT * FROM admins WHERE username = ? AND password = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
