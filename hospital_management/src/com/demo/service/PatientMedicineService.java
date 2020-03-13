package com.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.demo.bo.HospitalManagementBO1;
import com.demo.exception.PatientMedicineManagementException;
import com.demo.exception.PatientMedicineNotFoundException;
import com.demo.response.PatientMedicineResponseObject;
import com.demo.vo.PatientMedicineVO;

public class PatientMedicineService {
	HospitalManagementBO1 bo=new HospitalManagementBO1();
	PatientMedicineResponseObject obj =new PatientMedicineResponseObject();
	
	public PatientMedicineResponseObject addPatientMedicineDetails(PatientMedicineVO vo)throws PatientMedicineManagementException
	{
		boolean flag;
		try {
			flag = bo.addPatientMedicineDetails(vo);
			if (flag)
				obj.setSuccessMessage("patient medicine Details Added Successfully");
			else
				obj.setFailureMessage("Error When Adding patient medicine Details, Reach out Administrator");

		} catch (PatientMedicineManagementException e) {
			obj.setFailureMessage("Error When Adding The patient medicine Details" + e.getMessage());
		}
		return obj;
	}
	public PatientMedicineResponseObject fetchbybillid(int bill_id)throws PatientMedicineNotFoundException 
	{
		 try{
				Map<Integer,PatientMedicineVO> map= new HashMap<Integer,PatientMedicineVO>();
				map=bo.fetchbybillid(bill_id);
				obj.setPatientMedicineVO(map);
		  }catch (PatientMedicineNotFoundException e) {
				obj.setFailureMessage("Error When Fetching The Patient Medicine Details" + e.getMessage());
	  }
		return obj;
	}
	public PatientMedicineResponseObject fetchbyMedicineid(int medicine_id)throws PatientMedicineNotFoundException
	{
		 try{
				Map<Integer,PatientMedicineVO> map= new HashMap<Integer,PatientMedicineVO>();
				map=bo.fetchbyMedicineid(medicine_id);
				obj.setPatientMedicineVO(map);
		  }catch (PatientMedicineNotFoundException e) {
				obj.setFailureMessage("Error When Fetching The Patient Medicine Details" + e.getMessage());
	  }
		return obj;
	}
	public PatientMedicineResponseObject updatePatientMedicineDetails(PatientMedicineVO vo)throws PatientMedicineManagementException
	{
		boolean flag;
		try {
			flag = bo.updatePatientMedicineDetails(vo);
			if (flag)
				obj.setSuccessMessage("patient medicine Details Updated Successfully");
			else
				obj.setFailureMessage("Error When Updating patient medicine Details, Reach out Administrator");

		} catch (PatientMedicineManagementException e) {
			obj.setFailureMessage("Error When Updating The Scan Details" + e.getMessage());
		}
		return obj;
	}




}
