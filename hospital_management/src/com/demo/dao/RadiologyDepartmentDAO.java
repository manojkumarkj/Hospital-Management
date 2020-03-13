package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.demo.exception.RadiologyDepartmentManagementException;
import com.demo.exception.ScanNotFoundException;
import com.demo.vo.RadiologyDepartmentVO;

public class RadiologyDepartmentDAO {

	public boolean addscan_details(RadiologyDepartmentVO vo)throws RadiologyDepartmentManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";

		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO radiology_department(scan_details,scan_charges) VALUES(?,?)";
			stmt = connection.prepareStatement(query);

			
			stmt.setString(1, vo.getScan_details());
			stmt.setFloat(2, vo.getScan_charges());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new RadiologyDepartmentManagementException("Error when Adding Scan Details"+e.getMessage());
		}
			 finally {
					try {
						stmt.close();
						connection.close();
					} catch (SQLException e) {
						throw new RadiologyDepartmentManagementException("Error when Adding Scan Details"+e.getMessage());
					}
				}
		return flag;
	}

	public RadiologyDepartmentVO fetchscan_details(int scan_id) throws ScanNotFoundException {
		
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		RadiologyDepartmentVO vo =new RadiologyDepartmentVO();

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from radiology_department where scan_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, scan_id);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				vo.setScan_id(rs.getInt("scan_id"));
				vo.setScan_details(rs.getString("scan_details"));
				vo.setScan_charges(rs.getFloat("scan_charges"));
			}
		}

		catch (SQLException e) {
			throw new ScanNotFoundException("Error when Fetching Scan Details"+e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new ScanNotFoundException("Error when Fetching Scan Details"+e.getMessage());

			}
		}
		return vo;
		
	}

	public Map<Integer, RadiologyDepartmentVO> fetchscan_details(String scan_details) throws ScanNotFoundException {

		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Map<Integer, RadiologyDepartmentVO> map = new HashMap<Integer, RadiologyDepartmentVO>();

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from radiology_department where scan_details=?";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, scan_details);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				RadiologyDepartmentVO vo = new RadiologyDepartmentVO();
				vo.setScan_id(rs.getInt("scan_id"));
				vo.setScan_details(rs.getString("scan_details"));
				vo.setScan_charges(rs.getFloat("scan_charges"));
				Integer scan_id=vo.getScan_id();
				map.put(scan_id, vo);

			}
		}

		catch (SQLException e) {
			throw new ScanNotFoundException("Error when Fetching Scan Details"+e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new ScanNotFoundException("Error when Fetching Scan Details"+e.getMessage());

			}
		}
		return map;
	}

	public boolean updatescan_details(RadiologyDepartmentVO vo) throws RadiologyDepartmentManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "UPDATE radiology_department SET scan_details=?,scan_charges=? WHERE scan_id=?";
			stmt=connection.prepareStatement(query);
			stmt.setString(1,vo.getScan_details() );
			stmt.setFloat(2, vo.getScan_charges());
			stmt.setInt(3, vo.getScan_id());
			stmt.executeUpdate();
			flag=true;
		} catch (SQLException e) {
			throw new RadiologyDepartmentManagementException("Error when Updating Scan Details"+e.getMessage());
		}

		try {
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			throw new RadiologyDepartmentManagementException("Error when Updating Scan Details"+e.getMessage());

		}

		return flag;
	}

}
