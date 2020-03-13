package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.demo.exception.PatientMedicineManagementException;
import com.demo.exception.PatientMedicineNotFoundException;
import com.demo.vo.PatientMedicineVO;


public class PatientmedicineDAO {
	public boolean addPatientMedicineDetails(PatientMedicineVO vo)throws PatientMedicineManagementException {
		boolean flag = false;
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";

		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "INSERT INTO patient_medicine(patient_medicine_id,bill_id,medicine_id) VALUES(?,?,?)";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, vo.getPatient_medicine_id());
			stmt.setInt(2, vo.getBill_id());
			stmt.setInt(3, vo.getMedicine_id());
			stmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			throw new PatientMedicineManagementException("Error when Adding Patient medicine details"+e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new PatientMedicineManagementException("Error when Adding Patient medicine details"+e.getMessage());
				
			}
		}
		return flag;
	}
	public Map<Integer,PatientMedicineVO> fetchbybillid(int bill_id)throws PatientMedicineNotFoundException {
		
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		Map<Integer,PatientMedicineVO> map= new HashMap<Integer,PatientMedicineVO>();

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from patient_medicine where bill_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, bill_id);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				PatientMedicineVO vo=new PatientMedicineVO();
				vo.setPatient_medicine_id(rs.getInt("patient_medicine_id"));
				vo.setBill_id(rs.getInt("bill_id"));
				vo.setMedicine_id(rs.getInt("medicine_id"));
				map.put(bill_id, vo);

			}
		}

		catch (SQLException e) {
			throw new PatientMedicineNotFoundException("Error when fetching"+e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new PatientMedicineNotFoundException("Error when fetching"+e.getMessage());

			}
		}
		return map;
	}
public Map<Integer,PatientMedicineVO> fetchbyMedicineid(int medicine_id)throws PatientMedicineNotFoundException {
		
		String userName = "root";
		String password = "root123";
		String url = "jdbc:mysql://localhost:3306/hospital_management";
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs=null;
		Map<Integer,PatientMedicineVO> map= new HashMap<Integer,PatientMedicineVO>();

		try {
			connection = DriverManager.getConnection(url, userName, password);
			String query = "select * from patient_medicine where medicine_id=?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, medicine_id);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				PatientMedicineVO vo=new PatientMedicineVO();
				vo.setPatient_medicine_id(rs.getInt("patient_medicine_id"));
				vo.setBill_id(rs.getInt("bill_id"));
				vo.setMedicine_id(rs.getInt("medicine_id"));
				map.put(medicine_id, vo);

			}
		}

		catch (SQLException e) {
			throw new PatientMedicineNotFoundException("Error when fetching"+e.getMessage());
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				throw new PatientMedicineNotFoundException("Error when fetching"+e.getMessage());

			}
		}
		return map;
	}

public boolean updatePatientMedicineDetails(PatientMedicineVO vo)throws  PatientMedicineManagementException {
	boolean flag = false;
	String userName = "root";
	String password = "root123";
	String url = "jdbc:mysql://localhost:3306/hospital_management";
	Connection connection = null;
	PreparedStatement stmt = null;

	try {
		connection = DriverManager.getConnection(url, userName, password);
		String query = "UPDATE patient_medicine SET bill_id=?,medicine_id=? WHERE patient_medicine_id=?";
		stmt=connection.prepareStatement(query);
		stmt.setInt(1,vo.getBill_id());
		stmt.setInt(2, vo.getMedicine_id());
		stmt.setInt(3, vo.getPatient_medicine_id());
		stmt.executeUpdate();
		flag=true;
	} catch (SQLException e) {

		throw new PatientMedicineManagementException("Error when updating patient medicine details"+e.getMessage());
	}

finally {
	try {
		stmt.close();
		connection.close();
	} catch (SQLException e) {
		throw new PatientMedicineManagementException("Error when updating patient medicine details"+e.getMessage());
	}
}
	return flag;
}
}