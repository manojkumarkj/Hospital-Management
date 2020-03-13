package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.exception.StaffNotFoundException;
import com.demo.vo.StaffInfoVO;
import com.demo.vo.StaffTimingsVO;

public class StaffInfoJoinsDAO {
	public StaffInfoVO fetchStaffByIdJoins(int staff_id) throws StaffNotFoundException {
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		StaffInfoVO vo = new StaffInfoVO();
		StaffTimingsVO vo1 = new StaffTimingsVO();
		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query ="select a.staff_id,a.staff_name,a.designation from StaffInfo as a left join StaffTimings as b on a.staff_id=b.staff_id where a.staff_id=?";  
			
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, staff_id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				vo.setStaff_id(rs.getInt("staff_id"));
				vo.setStaff_name(rs.getString("staff_name"));
				vo.setDesignation(rs.getString("designation"));
				
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
			throw new StaffNotFoundException("Error while fetching" + e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new StaffNotFoundException("Error while fetching" + e.getMessage());
			}
		}
		return vo;
	}


}
