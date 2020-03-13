package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.exception.DoctorManagementException;
import com.demo.exception.DoctorNotFoundException;
import com.demo.vo.DoctorInfoVO;
import com.demo.vo.DoctorTimingsVO;

public class DoctorInfoDAO {
	public boolean addDoctorDetails(DoctorInfoVO vo) throws DoctorManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO doctor_info (doctor_name,specialist,doctor_salary)VALUES(?,?,?)";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, vo.getDoctor_name());
			stmt.setString(2, vo.getSpecialist());
			stmt.setFloat(3, vo.getDoctor_salary());
			stmt.executeUpdate();
			flag = true;
		}

		catch (SQLException e) {
			throw new DoctorManagementException("Error while adding doctor" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new DoctorManagementException("Error while adding doctor" + e.getMessage());
			}
		}
		return flag;

	}

	public DoctorInfoVO fetchDoctorById(int doctor_id) throws DoctorNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DoctorInfoVO vo = new DoctorInfoVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from doctor_info where doctor_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, doctor_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				vo.setDoctor_id(rs.getInt("doctor_id"));
				vo.setDoctor_name(rs.getString("doctor_name"));
				vo.setSpecialist(rs.getString("specialist"));
				vo.setDoctor_salary(rs.getFloat("doctor_salary"));

			}
		} catch (SQLException e) {
			throw new DoctorNotFoundException("Error while fetching " + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new DoctorNotFoundException("Error while fetching " + e.getMessage());
			}
		}
		return vo;
	}

	public Map<Integer, DoctorInfoVO> fetchDoctorByName(String doctor_name) throws DoctorNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Map<Integer, DoctorInfoVO> map = new HashMap<Integer, DoctorInfoVO>();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from doctor_info where doctor_name=?";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, doctor_name);
			rs = stmt.executeQuery();
			while (rs.next()) {
				DoctorInfoVO vo = new DoctorInfoVO();

				vo.setDoctor_id(rs.getInt("doctor_id"));
				vo.setDoctor_name(rs.getString("doctor_name"));
				vo.setSpecialist(rs.getString("specialist"));
				vo.setDoctor_salary(rs.getFloat("doctor_salary"));
				Integer doctor_id=vo.getDoctor_id();
				map.put(doctor_id, vo);
			}
		} catch (SQLException e) {
			throw new DoctorNotFoundException("Error while fetching" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new DoctorNotFoundException("Error while fetching" + e.getMessage());
			}
		}
		return map;
	}

	public DoctorInfoVO fetchDoctorByIdJoins(int doctor_id) throws DoctorNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DoctorInfoVO vo = new DoctorInfoVO();
		DoctorTimingsVO vo1 = new DoctorTimingsVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select a.doctor_id,a.doctor_name,a.specialist,b.date,b.time_in,b.time_out from doctor_info as a left join doctor_timings as b on a.doctor_id=b.doctor_id where a.doctor_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, doctor_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				vo.setDoctor_id(rs.getInt("doctor_id"));
				vo.setDoctor_name(rs.getString("doctor_name"));
				vo.setSpecialist(rs.getString("specialist"));
				vo1.setDate(rs.getDate("date"));
				vo1.setTime_in(rs.getString("time_in"));
				vo1.setTime_out(rs.getString("time_out"));
				/*System.out.println(
						"================================================================================================");
				System.out.println("DoctorId" + '\t' + "DoctorName" + '\t' + "Specialist" + '\t' + "Date" + '\t'
						+ "TimeIn" + '\t' + "TimeOut");
				System.out.println(
						"================================================================================================");
				System.out.println(vo.getDoctor_id() + "\t\t" + vo.getDoctor_name() + "\t\t" + vo.getSpecialist()
						+ "\t\t" + vo1.getDate() + "\t\t" + vo1.getTime_in() + "\t\t" + vo1.getTime_out());
*/
			}
		} catch (SQLException e) {
			throw new DoctorNotFoundException("Error while fetching" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new DoctorNotFoundException("Error while fetching" + e.getMessage());
			}
		}
		return vo;
	}
	public List<DoctorInfoVO> fetchDoctorMatchesByName(String doctor_name) throws DoctorNotFoundException
	{
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<DoctorInfoVO> list=new ArrayList<DoctorInfoVO>();
		try{
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from doctor_info where doctor_name like?";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, doctor_name);
			rs = stmt.executeQuery();
			while (rs.next()) {
				DoctorInfoVO vo = new DoctorInfoVO();
				vo.setDoctor_id(rs.getInt("doctor_id"));
				vo.setDoctor_name(rs.getString("doctor_name"));
				vo.setSpecialist(rs.getString("specialist"));
				vo.setDoctor_salary(rs.getFloat("doctor_salary"));
				list.add(vo);
				
		} 
		}catch (SQLException e) {
			throw new DoctorNotFoundException("Error while fetching" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new DoctorNotFoundException("Error while fetching" + e.getMessage());
			}
		}
		return list;
		
	}

	public boolean updateDoctorDetails(DoctorInfoVO vo) throws DoctorManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "UPDATE doctor_info SET doctor_name=?,specialist=?,doctor_salary=? WHERE doctor_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, vo.getDoctor_name());
			stmt.setString(2, vo.getSpecialist());
			stmt.setFloat(3, vo.getDoctor_salary());
			stmt.setInt(4, vo.getDoctor_id());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new DoctorManagementException("Error while updating the doctor" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new DoctorManagementException("Error while updating the doctor" + e.getMessage());
			}
		}
		return flag;

	}

}
