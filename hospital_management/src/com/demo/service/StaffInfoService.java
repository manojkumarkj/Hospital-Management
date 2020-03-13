package com.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.demo.bo.HospitalManagementBO;
import com.demo.exception.MaintenanceInfoManagementException;
import com.demo.exception.MaintenanceInfoNotFoundException;
import com.demo.exception.StaffManagementException;
import com.demo.exception.StaffNotFoundException;
import com.demo.exception.StaffTimingsManagementException;
import com.demo.exception.StaffTimingsNotFoundException;
import com.demo.response.MaintenanceInfoResponseObject;
import com.demo.response.StaffInfoResponseObject;
import com.demo.response.StaffTimingsResponseObject;
import com.demo.vo.MaintenanceInfoVO;
import com.demo.vo.StaffInfoVO;
import com.demo.vo.StaffTimingsVO;

public class StaffInfoService {
	HospitalManagementBO bo = new HospitalManagementBO();
	StaffTimingsResponseObject obj = new 	StaffTimingsResponseObject();
	 MaintenanceInfoResponseObject obj1 = new 	 MaintenanceInfoResponseObject();
	

/*	public 	StaffInfoResponseObject addStaff(StaffInfoVO vo) {
		boolean flag;
		try {
			flag =bo.addStaff(vo);
			if (flag)
				obj.setSuccessMessage("Staff Added Successfully");
			else
				obj.setFailureMessage("Error When Adding Staff Details, Reach out Administrator");

		} catch (StaffManagementException e) {
			obj.setFailureMessage("Error When Adding The Staff Details" + e.getMessage());
		}

		return obj;

	}

	public StaffInfoResponseObject updateStaffDetails(StaffInfoVO vo) {
		boolean flag;
		try {
			flag = bo.updateStaffDetails(vo);
			if (flag)
				obj.setSuccessMessage("Staff Updated Successfully");
			else
				obj.setFailureMessage("Error When Updating Staff Details, Reach out Administrator");

		} catch (StaffManagementException e) {
			obj.setFailureMessage("Error When Updating The Staff Details" + e.getMessage());
		}

		return obj;

	}

	public StaffInfoResponseObject fetchStaffById(int Staff_id) throws StaffNotFoundException {

		try {
			StaffInfoVO vo;
			vo = bo.fetchStaffById(Staff_id);
			obj.setStaffInfoVO(vo);
		} catch (StaffNotFoundException e) {
			obj.setFailureMessage("Fetch Student is not in the List" + e.getMessage());
		}

		return obj;

	}


	
	public  StaffInfoResponseObject fetchStaffbyDesignation(String  Designation) throws StaffNotFoundException {

		try {
			Map<String, StaffInfoVO> map=new HashMap<String, StaffInfoVO>();
			map = bo.fetchstaffByDesignation(Designation);
			obj.setStaffInfoMap(map);

		} catch (StaffNotFoundException e) {
			obj.setFailureMessage("Error When Fetching by designation Details" + e.getMessage());
		}

		return obj;
}
	
}
*/
	/*public 	StaffTimingsResponseObject addStaffdetails(StaffTimingsVO vo) throws StaffTimingsManagementException {
		boolean flag;
		try {
			flag =bo.addStaffdetails(vo);
			if (flag)
				obj.setSuccessMessage("Staff Added Successfully");
			else
				obj.setFailureMessage("Error When Adding Staff Details, Reach out Administrator");

		} catch (StaffTimingsManagementException e) {
			obj.setFailureMessage("Error When Adding The Staff Details" + e.getMessage());
		}

		return obj;

	}

public StaffTimingsResponseObject updateStaff(StaffTimingsVO vo) {
	boolean flag;
	try {
		flag = bo.updateStaff(vo);
		if (flag)
			obj.setSuccessMessage("Staff Updated Successfully");
		else
			obj.setFailureMessage("Error When Updating Staff Details, Reach out Administrator");

	} catch (StaffTimingsManagementException e) {
		obj.setFailureMessage("Error When Updating The Staff Details" + e.getMessage());
	}

	return obj;

}
public StaffTimingsResponseObject fetchStaffById(int Staff_id) throws StaffTimingsNotFoundException, StaffTimingsManagementException {

	try {
		StaffTimingsVO vo;
		vo = bo.fetchStaffById(Staff_id);
		obj.setStaffInfoVO(vo);
	} catch (StaffTimingsNotFoundException  e) {
		obj.setFailureMessage("Fetch Student is not in the List" + e.getMessage());
	}

	return obj;
}
public  StaffTimingsResponseObject fetchstaffByTime_in(String  Time_in) throws StaffTimingsNotFoundException {

	try {
		Map<String, StaffTimingsVO> map=new HashMap<String, StaffTimingsVO>();
		map = bo.fetchstaffByTime_in(Time_in);
		obj.StaffTimingsInfoMap(map);

	} catch ( StaffTimingsNotFoundException e) {
		obj.setFailureMessage("Error When Fetching by Time_in Details" + e.getMessage());
	}

	return obj;
}*/
} 
	/*public 	MaintenanceInfoResponseObject addmaintenance_details(MaintenanceInfoVO vo) throws MaintenanceInfoManagementException {
		boolean flag;
		try {
			flag =bo.addmaintenance_details(vo);
			if (flag)
				obj1.setSuccessMessage("Maintenence details Added Successfully");
			else
				obj1.setFailureMessage("Error When Adding Staff Details, Reach out Administrator");

		} catch (MaintenanceInfoManagementException e) {
			obj.setFailureMessage("Error When Adding The Staff Details" + e.getMessage());
		}

		return obj1;

	}

	public MaintenanceInfoResponseObject updatemaintenance_details(MaintenanceInfoVO vo) throws MaintenanceInfoManagementException {
		boolean flag;
		try {
			flag = bo.updatemaintenance_details(vo);
			if (flag)
				obj1.setSuccessMessage("Staff Updated Successfully");
			else
				obj1.setFailureMessage("Error When Updating maintenance Details, Reach out Administrator");

		} catch (MaintenanceInfoManagementException e) {
			obj1.setFailureMessage("Error When Updating The maintenance Details" + e.getMessage());
		}

		return obj1;

	}

	public MaintenanceInfoResponseObject fetchMaintenanceById(int Maintenance_id) throws MaintenanceInfoNotFoundException {

		try {
		
			MaintenanceInfoVO vo;
			vo= bo.fetchMaintenanceById(Maintenance_id);
			obj1.setMaintenanceInfoVO(vo);
		} catch (MaintenanceInfoNotFoundException e) {
			obj.setFailureMessage("Fetch maintenance id is not in the List" + e.getMessage());
		}

		return obj1;

	}


	
	public  MaintenanceInfoResponseObject fetchStaffbymaintenance_details(String  maintenance_details) throws MaintenanceInfoNotFoundException {

		try {
			Map<String, MaintenanceInfoVO> map=new HashMap<String, MaintenanceInfoVO>();
			map = bo.fetchstaffBymaintenance_details(maintenance_details);
			obj1.setMaintenanceIinfomap(map);

		} catch (MaintenanceInfoNotFoundException e) {
			obj1.setFailureMessage("Error When Fetching by maintenance Details" + e.getMessage());
		}

		return obj1;
}*/
public DoctorInfoResponseObject fetchDoctorByIdJoins(int doctor_id) throws DoctorNotFoundException {
	try {
		DoctorInfoVO vo=new DoctorInfoVO();
		vo = bo1.fetchDoctorByIdJoins(doctor_id);
		obj1.setDoctorInfoVO(vo);
	} catch (DoctorNotFoundException e) {
		obj1.setFailureMessage("Fetch Student is not in the List" + e.getMessage());
	}

	return obj1;
}