package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.demo.vo.StaffInfoVO;
import com.demo.vo.StaffTimingsVO;
import com.demo.exception.StaffManagementException;
import com.demo.exception.StaffNotFoundException;
import com.demo.exception.StaffTimingsManagementException;
import com.demo.exception.StaffTimingsNotFoundException;
import com.demo.vo.MaintenanceInfoVO;

public class StaffTimingsDAO {
	private String Staff_id;

	public boolean addStaffdetails(StaffTimingsVO vo)throws StaffTimingsManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";

		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO Staff_timings(Time_id,date,Time_in,Time_out,Staff_id) VALUES(?,?,?,?,?)";
			stmt = connection.prepareStatement(query);

			stmt.setInt(1, vo.getTime_id());
			stmt.setDate(2, vo.getDate());
			stmt.setString(3, vo.getTime_in());
			stmt.setString(4, vo.getTime_out());
			stmt.setInt(5,vo.getStaff_id());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new StaffTimingsManagementException("Error when Adding stafftiming"+e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				
				throw new StaffTimingsManagementException("Error when Adding Stafftiming"+e.getMessage());
			}
		}
		return flag;
	}


	public StaffTimingsVO fetchStaffById(int staff_id) throws  StaffTimingsNotFoundException {
	
	String userName = "root";
	String password = "root123";
	String url = "jdbc:mysql://localhost:3306/hospital_management";
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	 StaffTimingsVO vo = new  StaffTimingsVO();

	try {
		connection = DriverManager.getConnection(url, userName, password);
		String query = "select * from staff_timings where time_id=?";
		stmt = connection.prepareStatement(query);
		stmt.setInt(1, staff_id);
		rs = stmt.executeQuery();
		while (rs.next()) {
			vo.setTime_id(rs.getInt("time_id"));
			
			vo.setDate(rs.getDate("date"));;
			vo.setTime_in(rs.getString("time_in"));
		vo.setTime_out(rs.getString("time_out"));
		vo.setStaff_id(rs.getInt("staff_id"));	
		}
	}

	catch (SQLException e) {
		throw new  StaffTimingsNotFoundException("Error while fetching " + e.getMessage());
	} finally {
		try {
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			throw new StaffTimingsNotFoundException("Error while fetching " + e.getMessage());
		}
	}
	return vo;
}
public Map<String, StaffTimingsVO> fetchstaffByTime_in(String time_in)throws StaffTimingsNotFoundException {

	
	String userName = "root";
	String password = "root123";
	String url = "jdbc:mysql://localhost:3306/hospital_management";
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	StaffTimingsVO vo = new StaffTimingsVO();
	Map<String, StaffTimingsVO> map = new HashMap<String, StaffTimingsVO>();

	try {
		connection = DriverManager.getConnection(url, userName, password);
		String query = "select * from Staff_timings where time_in=?";
		stmt = connection.prepareStatement(query);
		stmt.setString(1, time_in);
		rs=stmt.executeQuery();
		while (rs.next()) {
			vo.setTime_id(rs.getInt("time_id"));
			vo.setDate(rs.getDate("date"));
			vo.setTime_in(rs.getString("time_in"));
			vo.setTime_out(rs.getString("time_out"));
			vo.setStaff_id(rs.getInt("staff_id"));
			map.put(time_in, vo);
			
	}
	}

	catch (SQLException e) {
		throw new StaffTimingsNotFoundException("Error while fetching");
	} finally {
		try {
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			throw new StaffTimingsNotFoundException("Error while fetching");
		}
	}
	return map;
}

public boolean updateStaff(StaffTimingsVO vo) throws StaffTimingsManagementException {
	boolean flag = false;
	String userName = "root";
	String password = "root123";
	String url = "jdbc:mysql://localhost:3306/hospital_management";
	Connection connection = null;
	PreparedStatement stmt = null;

	try {
		connection = DriverManager.getConnection(url, userName, password);
		String query =  "UPDATE Staff_timings SET Time_id=?,date=?,Time_in=?,Time_out=? WHERE time_id=?";
		stmt=connection.prepareStatement(query);
		stmt.setInt(1, vo.getTime_id());
		stmt.setDate(2, vo.getDate());
		stmt.setString(3,vo.getTime_in());
		stmt.setString(4,vo.getTime_out());
		stmt.setInt(5,vo.getStaff_id());
		stmt.executeUpdate();
		flag=true;
	} catch (SQLException e) {
		throw new StaffTimingsManagementException("Error when updating Staff"+e.getMessage());
	}

	try {
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		throw new StaffTimingsManagementException("Error when updating Staff"+e.getMessage());
	}

	return flag;
}
}
