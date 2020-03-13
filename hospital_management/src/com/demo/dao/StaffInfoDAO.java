package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.demo.exception.StaffManagementException;
import com.demo.exception.StaffNotFoundException;
import com.demo.main.HospitalManagementMain;
import com.demo.vo.StaffInfoVO;
import com.demo.vo.StaffTimingsVO;

public class StaffInfoDAO {
	private static final String Staff_id = null;

	public boolean addStaff(StaffInfoVO vo)throws StaffManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";

		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO Staff_info(Staff_name,Designation,Doctor_id,Staff_salary) VALUES(?,?,?,?)";
			stmt = connection.prepareStatement(query);

			stmt.setString(1, vo.getStaff_name());
			stmt.setString(2, vo.getDesignation());
			stmt.setInt(3, vo.getDoctor_id());
			stmt.setFloat(4, vo.getStaff_salary());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new StaffManagementException("Error when Adding Staff"+e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new StaffManagementException("Error when Adding Staff"+e.getMessage());
			}
		}
		return flag;
	}

	public StaffInfoVO fetchStaffById(int staff_id) throws StaffNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StaffInfoVO vo = new StaffInfoVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from Staff_info where Staff_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, staff_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				vo.setStaff_id(rs.getInt("Staff_id"));
				vo.setStaff_name(rs.getString("Staff_name"));
				vo.setDesignation(rs.getString("Designation"));
			vo.setDoctor_id(rs.getInt("Doctor_id"));
			vo.setStaff_salary(rs.getFloat("Staff_salary"));
				

			}
		} catch (SQLException e) {
			throw new StaffNotFoundException("Error while fetching " + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new StaffNotFoundException("Error while fetching " + e.getMessage());
			}
		}
		return vo;
	}

	

	public Map<String, StaffInfoVO> fetchstaffByDesignation(String designation)throws StaffNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StaffInfoVO vo = new StaffInfoVO();
		Map<String, StaffInfoVO> map = new HashMap<String, StaffInfoVO>();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from Staff_info where Designation=?";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, designation);
			rs=stmt.executeQuery();
			while (rs.next()) {
				vo.setStaff_id(rs.getInt("Staff_id"));
				vo.setStaff_name(rs.getString("Staff_name"));
				vo.setDesignation (rs.getString("Designation"));
				vo.setDoctor_id(rs.getInt("Doctor_id"));
				vo.setStaff_salary(rs.getFloat("Staff_salary"));
				map.put(designation, vo);
				
				
			}
		} catch (SQLException e) {
			throw new StaffNotFoundException("Error while fetching");
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new StaffNotFoundException("Error while fetching");

			}
		}
		return map;
	}

	public boolean updateStaffDetails(StaffInfoVO vo) throws StaffManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "UPDATE Staff_info SET Staff_name=?,Designation=?,Doctor_id=?,Staff_salary=? WHERE Staff_id=?";
			stmt=connection.prepareStatement(query);
			stmt.setString(1, vo.getStaff_name());
			stmt.setString(2, vo.getDesignation());
			stmt.setInt(3,vo.getDoctor_id());
			stmt.setFloat(4,vo.getStaff_salary());
			stmt.setInt(5, vo.getStaff_id());
			stmt.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			throw new StaffManagementException("Error when updating Staff"+e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new StaffManagementException("Error when updating Staff"+e.getMessage());
			}
		}

		return flag;
	}
}
