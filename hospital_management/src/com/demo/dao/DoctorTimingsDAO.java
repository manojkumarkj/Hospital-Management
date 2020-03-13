package com.demo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.demo.exception.TimingsManagementException;
import com.demo.exception.TimingsNotFoundException;
import com.demo.vo.DoctorTimingsVO;

public class DoctorTimingsDAO {
	public boolean addTimingsDetails(DoctorTimingsVO vo) throws TimingsManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO doctor_timings(date,time_in,time_out,doctor_id)VALUES(?,?,?,?)";
			stmt = connection.prepareStatement(query);
			stmt.setDate(1, vo.getDate());
			stmt.setString(2, vo.getTime_in());
			stmt.setString(3, vo.getTime_out());
			stmt.setInt(4, vo.getDoctor_id());
			stmt.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			throw new TimingsManagementException("Error while adding timings" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();

			} catch (SQLException e) {
				throw new TimingsManagementException("Error while adding timings" + e.getMessage());
			}
		}
		return flag;
	}

	public Map<Date, DoctorTimingsVO> fetchByDate(Date date) throws TimingsNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DoctorTimingsVO vo = new DoctorTimingsVO();
		Map<Date, DoctorTimingsVO> map = new HashMap<Date, DoctorTimingsVO>();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from doctor_Timings where date=?";
			stmt = connection.prepareStatement(query);
			stmt.setDate(1, date);
			rs = stmt.executeQuery();
			while (rs.next()) {
				vo.setTime_id(rs.getInt("time_id"));
				vo.setDate(rs.getDate("date"));
				vo.setTime_in(rs.getString("time_in"));
				vo.setTime_out(rs.getString("time_out"));
				vo.setDoctor_id(rs.getInt("doctor_id"));
				map.put(date, vo);
			}
		} catch (SQLException e) {
			throw new TimingsNotFoundException("Error while fetching" + e.getMessage());

		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new TimingsNotFoundException("Error while fetching" + e.getMessage());
			}
		}
		return map;
	}

	public Map<Integer, DoctorTimingsVO> fetchByDoctorid(int doctor_id) throws TimingsNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DoctorTimingsVO vo = new DoctorTimingsVO();
		Map<Integer, DoctorTimingsVO> map = new HashMap<Integer, DoctorTimingsVO>();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from doctor_timings where doctor_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, doctor_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				vo.setTime_id(rs.getInt("time_id"));
				vo.setDate(rs.getDate("date"));
				vo.setTime_in(rs.getString("time_in"));
				vo.setTime_out(rs.getString("time_out"));
				vo.setDoctor_id(rs.getInt("doctor_id"));
				map.put(doctor_id, vo);
			}
		} catch (SQLException e) {
			throw new TimingsNotFoundException("Error while fetching" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new TimingsNotFoundException("Error while fetching" + e.getMessage());
			}
		}
		return map;
	}

	public boolean updateTimingsDetails(DoctorTimingsVO vo) throws TimingsManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "UPDATE doctor_timings SET time_id=?,date=?,time_in=?,time_out=?,doctor_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, vo.getTime_id());
			stmt.setDate(2, vo.getDate());
			stmt.setString(3, vo.getTime_in());
			stmt.setString(4, vo.getTime_out());
			stmt.setInt(5, vo.getDoctor_id());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new TimingsManagementException("Error while updating timings" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {

				throw new TimingsManagementException("Error while updating timings" + e.getMessage());
			}
		}
		return flag;
	}
}
