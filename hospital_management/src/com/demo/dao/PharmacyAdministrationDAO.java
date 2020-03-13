package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.demo.exception.MedicineManagementException;
import com.demo.exception.MedicineNotFoundException;
import com.demo.vo.PharmacyAdministrationVO;

public class PharmacyAdministrationDAO {
	public boolean addMedicineDetails(PharmacyAdministrationVO vo) throws MedicineManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO pharmacy_administration (medicine_name,medicine_mrp,stock_purchased,stock_sold,stock_left) VALUES(?,?,?,?,?)";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, vo.getMedicine_name());
			stmt.setFloat(2, vo.getMedicine_mrp());
			stmt.setInt(3, vo.getStock_purchased());
			stmt.setInt(4, vo.getStock_sold());
			stmt.setInt(5, vo.getStock_left());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new MedicineManagementException("Error while adding medicine details" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new MedicineManagementException("Error while adding medicine details" + e.getMessage());
			}
		}
		return flag;
	}

	public Map<Integer, PharmacyAdministrationVO> fetchByMedicineId(int medicine_id) throws MedicineNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PharmacyAdministrationVO vo = new PharmacyAdministrationVO();
		Map<Integer, PharmacyAdministrationVO> map = new HashMap<Integer, PharmacyAdministrationVO>();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from pharmacy_administration where medicine_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, medicine_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				vo.setMedicine_id(rs.getInt("medicine_id"));
				vo.setMedicine_name(rs.getString("medicine_name"));
				vo.setMedicine_mrp(rs.getFloat("medicine_mrp"));
				vo.setStock_purchased(rs.getInt("stock_purchased"));
				vo.setStock_sold(rs.getInt("stock_sold"));
				vo.setStock_left(rs.getInt("stock_left"));
				map.put(medicine_id, vo);

			}

		} catch (SQLException e) {
			throw new MedicineNotFoundException("Error while fetching" + e.getMessage());

		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new MedicineNotFoundException("Error while fetching" + e.getMessage());
			}
		}
		return map;
	}

	public Map<String, PharmacyAdministrationVO> fetchByMedicineName(String medicine_name)
			throws MedicineNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PharmacyAdministrationVO vo = new PharmacyAdministrationVO();
		Map<String, PharmacyAdministrationVO> map = new HashMap<String, PharmacyAdministrationVO>();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from pharmacy_administration where medicine_name=?";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, medicine_name);
			rs = stmt.executeQuery();
			while (rs.next()) {
				vo.setMedicine_id(rs.getInt("medicine_id"));
				vo.setMedicine_name(rs.getString("medicine_name"));
				vo.setMedicine_mrp(rs.getFloat("medicine_mrp"));
				vo.setStock_purchased(rs.getInt("stock_purchased"));
				vo.setStock_sold(rs.getInt("stock_sold"));
				vo.setStock_left(rs.getInt("stock_left"));
				map.put(medicine_name, vo);

			}
		} catch (SQLException e) {
			throw new MedicineNotFoundException("Error while fetching" + e.getMessage());

		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new MedicineNotFoundException("Error while fetching" + e.getMessage());
			}
		}
		return map;
	}

	public boolean updateMedicineDetails(PharmacyAdministrationVO vo) throws MedicineManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "UPDATE pharmacy_administration SET medicine_id=?,medicine_name=?,medicine_mrp=?,stock_purchased=?,stock_sold=?,stock_left=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, vo.getMedicine_id());
			stmt.setString(2, vo.getMedicine_name());
			stmt.setFloat(3, vo.getMedicine_mrp());
			stmt.setInt(4, vo.getStock_purchased());
			stmt.setInt(5, vo.getStock_sold());
			stmt.setInt(6, vo.getStock_left());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new MedicineManagementException("Error while updating medicine details" + e.getMessage());

		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new MedicineManagementException("Error while updating medicine details" + e.getMessage());
			}
		}
		return flag;
	}

}
