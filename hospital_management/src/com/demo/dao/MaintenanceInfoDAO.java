package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.demo.exception.MaintenanceInfoManagementException;
import com.demo.exception.MaintenanceInfoNotFoundException;
import com.demo.vo.MaintenanceInfoVO;

public class MaintenanceInfoDAO {

	public boolean addmaintenance_details(MaintenanceInfoVO vo) throws MaintenanceInfoManagementException {
		{
			boolean flag = false;
			String userName = "root";
			String password = "root123";
			String url = "jdbc:mysql://localhost:3306/hospital_management";

			Connection connection = null;
			PreparedStatement stmt = null;

			try {
				connection = DriverManager.getConnection(url, userName, password);
				String query = "INSERT INTO maintenance_info(maintenance_details,maintenance_amount) VALUES(?,?)";
				stmt = connection.prepareStatement(query);

				stmt.setString(1, vo.getMaintenance_details());
				stmt.setFloat(2, vo.getMaintenance_amount());
				stmt.executeUpdate();
				flag = true;
			} catch (SQLException e) {
				throw new MaintenanceInfoManagementException("Error when Adding details" + e.getMessage());
			} finally {
				try {
					stmt.close();
					connection.close();
				} catch (SQLException e) {
					throw new MaintenanceInfoManagementException("Error when Adding details" + e.getMessage());

				}
			}
			return flag;
		}
	}

	public MaintenanceInfoVO fetchMaintenanceById(int maintenance_id) throws MaintenanceInfoNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MaintenanceInfoVO vo = new MaintenanceInfoVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from maintenance_info where maintenance_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, maintenance_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				vo.setMaintenance_id(rs.getInt("maintenance_id"));
				vo.setMaintenance_details(rs.getString("maintenance_details"));
				vo.setMaintenance_amount(rs.getFloat("maintenance_amount"));
				

			}
		} catch (SQLException e) {
			throw new MaintenanceInfoNotFoundException("Error while fetching " + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new MaintenanceInfoNotFoundException("Error while fetching " + e.getMessage());
			}
		}
		return vo;
	}

	public Map<String, MaintenanceInfoVO> fetchbymaintenance_details(String maintenance_details)
			throws MaintenanceInfoNotFoundException {

		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		MaintenanceInfoVO vo = new MaintenanceInfoVO();
		Map<String, MaintenanceInfoVO> map = new HashMap<String, MaintenanceInfoVO>();

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from Maintenance_info where maintenance_details=?";

			stmt = connection.prepareStatement(query);
			stmt.setString(1, maintenance_details);
			rs = stmt.executeQuery();
			while (rs.next()) {
				vo.setMaintenance_id(rs.getInt("Maintenance_id"));
				vo.setMaintenance_details(rs.getString("Maintenance_details"));
				;
				vo.setMaintenance_amount(rs.getFloat("Maintenance_amount"));
				;

				map.put(maintenance_details, vo);

			}
		}

		catch (SQLException e) {
			throw new MaintenanceInfoNotFoundException("Error while fetching");
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new MaintenanceInfoNotFoundException("Error while fetching");
			}
		}
		return map;
	}

	public boolean updatemaintenance_details(MaintenanceInfoVO vo) throws MaintenanceInfoManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "UPDATE maintenance_info set maintenance_details=?,maintenance_amount=? WHERE maintenance_id =?";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, vo.getMaintenance_details());
			stmt.setFloat(2, vo.getMaintenance_amount());
			stmt.setInt(3, vo.getMaintenance_id());

			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new MaintenanceInfoManagementException("Error when updating Staff" + e.getMessage());
		} finally {

			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new MaintenanceInfoManagementException("Error when updating Staff" + e.getMessage());

			}
		}

			return flag;
		
	}
}
