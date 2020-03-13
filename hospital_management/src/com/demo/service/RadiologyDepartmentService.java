package com.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.demo.bo.HospitalManagementBO1;
import com.demo.exception.RadiologyDepartmentManagementException;
import com.demo.exception.ScanNotFoundException;
import com.demo.response.RadiologyDepartmentResponseObject;
import com.demo.vo.RadiologyDepartmentVO;

public class RadiologyDepartmentService {
	HospitalManagementBO1 bo=new HospitalManagementBO1();
	RadiologyDepartmentResponseObject obj =new RadiologyDepartmentResponseObject();
	  public RadiologyDepartmentResponseObject addscandetails(RadiologyDepartmentVO vo) throws RadiologyDepartmentManagementException {
		  boolean flag;
			try {
				flag = bo.addscan_details(vo);
				if (flag)
					obj.setSuccessMessage("Scan Details Added Successfully");
				else
					obj.setFailureMessage("Error When Adding Scan Details, Reach out Administrator");

			} catch (RadiologyDepartmentManagementException e) {
				obj.setFailureMessage("Error When Adding The Scan Details" + e.getMessage());
			}
			return obj;	  
	  }
	  public RadiologyDepartmentResponseObject fetchscanDetailsById(int scan_id) throws ScanNotFoundException {
		 try{
			  RadiologyDepartmentVO vo=new RadiologyDepartmentVO();
			  vo=bo.fetchscanDetailsById(scan_id);
			  obj.setRadiology_departmentVO(vo);
		  }catch (ScanNotFoundException e) {
				obj.setFailureMessage("Error When Fetching The Scan Details" + e.getMessage());
	  }
		return obj;
	  }
	  public RadiologyDepartmentResponseObject fetchscanDetails(String scan_details) throws ScanNotFoundException 
	  {
		  try{
			  Map<Integer,RadiologyDepartmentVO> map=new HashMap<Integer,RadiologyDepartmentVO>();
			  map=bo.fetchscanDetails(scan_details);
			  obj.setRadiologyDepartmentMap(map);

		  }catch (ScanNotFoundException e) {
				obj.setFailureMessage("Error When Fetching The Scan Details" + e.getMessage());
	  }
		return obj;
	  }
	  public RadiologyDepartmentResponseObject updatescandetails(RadiologyDepartmentVO vo) throws RadiologyDepartmentManagementException 
	  {
		  boolean flag;
			try {
				flag = bo.updatescan_details(vo);
				if (flag)
					obj.setSuccessMessage("Scan Details Updated Successfully");
				else
					obj.setFailureMessage("Error When updating Scan Details, Reach out Administrator");

			} catch (RadiologyDepartmentManagementException e) {
				obj.setFailureMessage("Error When updating The Scan Details" + e.getMessage());
			}
			return obj;	
	  }





}
