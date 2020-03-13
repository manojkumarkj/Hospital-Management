package com.demo.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.demo.exception.RadiologyDepartmentManagementException;
import com.demo.exception.ScanNotFoundException;
import com.demo.response.RadiologyDepartmentResponseObject;
import com.demo.service.RadiologyDepartmentService;
import com.demo.vo.RadiologyDepartmentVO;

public class RadiologyDepartmentMain {

	public static void main(String[] args) throws RadiologyDepartmentManagementException, ScanNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Please select one of the below options");
		System.out.println("1. Add Scan Details");
		System.out.println("2. Fetch Scan Details by Scan id");
		System.out.println("3. Fetch Scan by Scan Details");
		System.out.println("4. Update Scan details");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addscandetails();
			break;
		case 2:
			fetchscanDetailsById();
			break;
		case 3:
			fetchscanDetails();
			break;
		case 4:
			updatescandetails();
			break;
		default:
			System.exit(0);

	}
	
}
	private static void addscandetails() throws RadiologyDepartmentManagementException {
		// TODO Auto-generated method stub
		RadiologyDepartmentService radiologydepartmentService = new RadiologyDepartmentService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Scan Details:");
		String scan_details = s.nextLine();
		System.out.println("Please Enter The Scan Charges:");
		Float scan_charges = Float.parseFloat(s.nextLine());
		RadiologyDepartmentVO vo = new RadiologyDepartmentVO();

		vo.setScan_details(scan_details);
		vo.setScan_charges(scan_charges);
		RadiologyDepartmentResponseObject obj = null;
		obj = radiologydepartmentService.addscandetails(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}
		
	private static void fetchscanDetailsById() throws ScanNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Scan ID:");
		Integer scan_id = Integer.parseInt(s.nextLine());

		RadiologyDepartmentService radiologyDepartmentService = new RadiologyDepartmentService();
		RadiologyDepartmentResponseObject obj = null;
		obj = radiologyDepartmentService.fetchscanDetailsById(scan_id);
		RadiologyDepartmentVO vo = new RadiologyDepartmentVO();
		vo = obj.getRadiology_departmentVO();
		if (vo != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("Scan Id" + '\t' + "Scan Details" + '\t' + "Scan Charges");
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getScan_id() + "\t\t" + vo.getScan_details() + "\t\t" + vo.getScan_charges());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}
	private static void fetchscanDetails() throws ScanNotFoundException {
		// TODO Auto-generated method stubScanner s = new Scanner(System.in);
		
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Scan Details:");
		String scan_details =s.nextLine();

		RadiologyDepartmentService radiologyDepartmentService = new RadiologyDepartmentService();
		RadiologyDepartmentResponseObject obj = null;
		obj = radiologyDepartmentService.fetchscanDetails(scan_details);
		Map<Integer,RadiologyDepartmentVO> map=new HashMap<Integer,RadiologyDepartmentVO>();
		map = obj.getRadiologyDepartmentMap();
		if (map != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("Scan Id" + '\t' + "Scan Details" + '\t' + "Scan Charges");
			System.out.println(
					"================================================================================================");
			for(Map.Entry<Integer,RadiologyDepartmentVO> entry: map.entrySet())
			{
				System.out.println(entry.getValue());
				//System.out.println(entry.getKey());

			}
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}
	private static void updatescandetails() throws RadiologyDepartmentManagementException {
		// TODO Auto-generated method stub
		RadiologyDepartmentService radiologydepartmentService = new RadiologyDepartmentService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Scan Id:");
		Integer scan_id=Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Scan Details:");
		String scan_details = s.nextLine();
		System.out.println("Please Enter The Scan Charges:");
		Float scan_charges = Float.parseFloat(s.nextLine());
		RadiologyDepartmentVO vo = new RadiologyDepartmentVO();
		vo.setScan_id(scan_id);
		vo.setScan_details(scan_details);
		vo.setScan_charges(scan_charges);
		RadiologyDepartmentResponseObject obj = null;
		obj = radiologydepartmentService.updatescandetails(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}
}
