package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.exception.RoomManagementException;
import com.demo.exception.RoomNotFoundException;
import com.demo.vo.RoomManagementVO;

public class RoomManagementDAO {
	public boolean addRoomDetails(RoomManagementVO vo) throws RoomManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO room_management(room_number,suite_room,room_charges) VALUES (?,?,?)";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, vo.getRoom_number());
			stmt.setString(2, vo.getSuite_room());
			stmt.setFloat(3, vo.getRoom_charges());
			stmt.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			throw new RoomManagementException("Error while adding room details" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();

			} catch (SQLException e) {
				throw new RoomManagementException("Error while adding room details" + e.getMessage());
			}
		}
		return flag;

	}

	public RoomManagementVO fetchRoomByRoomNumber(int room_number) throws RoomNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		RoomManagementVO vo = new RoomManagementVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from room_management where room_number=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, room_number);
			rs = stmt.executeQuery();
			while (rs.next()) {
				vo.setRoom_number(rs.getInt("room_number"));
				vo.setSuite_room(rs.getString("suite_room"));
				vo.setRoom_charges(rs.getFloat("room_charges"));
			}

		} catch (SQLException e) {
			throw new RoomNotFoundException("Error while fetching" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new RoomNotFoundException("Error while fetching" + e.getMessage());

			}
		}
		return vo;

	}

	public boolean updateRoomDetails(RoomManagementVO vo) throws RoomManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "UPDATE room_management SET room_number=?,suite_room=?,room_charges=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, vo.getRoom_number());
			stmt.setString(2, vo.getSuite_room());
			stmt.setFloat(3, vo.getRoom_charges());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new RoomManagementException("Error while updating room details" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new RoomManagementException("Error while updating room details" + e.getMessage());
			}
		}
		return flag;
	}

}
