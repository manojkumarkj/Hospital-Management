package com.demo.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.demo.exception.PatientMedicineManagementException;
import com.demo.exception.PatientMedicineNotFoundException;
import com.demo.response.PatientMedicineResponseObject;
import com.demo.response.RadiologyDepartmentResponseObject;
import com.demo.service.PatientMedicineService;
import com.demo.service.RadiologyDepartmentService;
import com.demo.vo.PatientMedicineVO;
import com.demo.vo.RadiologyDepartmentVO;

public class PatientMedicineMain {

	public static void main(String[] args) throws PatientMedicineManagementException, PatientMedicineNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Please select one of the below options");
		System.out.println("1. Add PatientMedicine Details");
		System.out.println("2. Fetch PatientMedicine Details by Bill Id");
		System.out.println("3. Fetch PatientMedicine Details by Medicine Id");
		System.out.println("4. Update PatientMedicine details");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addPatientMedicineDetails();
			break;
		case 2:
			fetchPatientMedicineDetailsByBillId();
			break;
		case 3:
			fetchPatientMedicineDetailsByMedicineId();
			break;
		case 4:
			updatePatientMedicineDetails();
			break;
		default:
			System.exit(0);

	}

	}
	private static void addPatientMedicineDetails() throws PatientMedicineManagementException {
		// TODO Auto-generated method stub
		PatientMedicineService patientMedicineService = new PatientMedicineService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Bill Id:");
		Integer bill_id=Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Medicine Id:");
		Integer medicine_id=Integer.parseInt(s.nextLine());
		PatientMedicineVO vo = new PatientMedicineVO();

		vo.setBill_id(bill_id);
		vo.setMedicine_id(medicine_id);
		PatientMedicineResponseObject obj = null;
		obj = patientMedicineService.addPatientMedicineDetails(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}
	private static void fetchPatientMedicineDetailsByBillId() throws PatientMedicineNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Bill ID:");
		Integer bill_id = Integer.parseInt(s.nextLine());

		PatientMedicineService patientMedicineService = new PatientMedicineService();
		PatientMedicineResponseObject obj = null;
		obj = patientMedicineService.fetchbybillid(bill_id);
		Map<Integer,PatientMedicineVO> map=new HashMap<Integer,PatientMedicineVO>();
		map = obj.getPatientMedicineVO();
		if (map != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("Patient Medicine Id" + '\t' + "Bill ID" + '\t' + "Medicine ID");
			System.out.println(
					"================================================================================================");
			for(Map.Entry<Integer,PatientMedicineVO> entry:map.entrySet())
			{
				System.out.println(entry.getValue());
			}

		} else {
			System.out.println(obj.getFailureMessage());
		}
	}
	private static void fetchPatientMedicineDetailsByMedicineId() throws PatientMedicineNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Medicine ID:");
		Integer medicine_id = Integer.parseInt(s.nextLine());

		PatientMedicineService patientMedicineService = new PatientMedicineService();
		PatientMedicineResponseObject obj = null;
		obj = patientMedicineService.fetchbybillid(medicine_id);
		Map<Integer,PatientMedicineVO> map=new HashMap<Integer,PatientMedicineVO>();
		map = obj.getPatientMedicineVO();
		if (map != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("Patient Medicine Id" + '\t' + "Bill ID" + '\t' + "Medicine ID");
			System.out.println(
					"================================================================================================");
			for(Map.Entry<Integer,PatientMedicineVO> entry:map.entrySet())
			{
				System.out.println(entry.getValue());
			}

		} else {
			System.out.println(obj.getFailureMessage());
		}
	}
	private static void updatePatientMedicineDetails() throws PatientMedicineManagementException {
		// TODO Auto-generated method stub
		PatientMedicineService patientMedicineService = new PatientMedicineService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Patient Medicine Id:");
		Integer patient_medicine_id=Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Bill Id:");
		Integer bill_id=Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Medicine Id:");
		Integer medicine_id=Integer.parseInt(s.nextLine());
		PatientMedicineVO vo = new PatientMedicineVO();
		vo.setPatient_medicine_id(patient_medicine_id);
		vo.setBill_id(bill_id);
		vo.setMedicine_id(medicine_id);
		PatientMedicineResponseObject obj = null;
		obj = patientMedicineService.updatePatientMedicineDetails(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}

}
