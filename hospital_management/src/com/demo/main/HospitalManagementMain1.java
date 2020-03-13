package com.demo.main;


import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.demo.exception.MaintenanceInfoManagementException;
import com.demo.exception.MaintenanceInfoNotFoundException;
import com.demo.exception.StaffManagementException;
import com.demo.exception.StaffNotFoundException;
import com.demo.exception.StaffTimingsManagementException;
import com.demo.exception.StaffTimingsNotFoundException;
import com.demo.response.MaintenanceInfoResponseObject;
import com.demo.response.StaffInfoResponseObject;
import com.demo.response.StaffTimingsResponseObject;
import com.demo.service.StaffInfoService;
import com.demo.vo.MaintenanceInfoVO;
import com.demo.vo.StaffInfoVO;
import com.demo.vo.StaffTimingsVO;

public class HospitalManagementMain {

	/* public static void main(String[] args) throws StaffManagementException, StaffNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Please select one of the below options");
		System.out.println("1. Add staff");
		System.out.println("2. Fetch staff by Designation");
		System.out.println("3. Fetch staff by ID");
		System.out.println("4. Update staff Details");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addStaff();
			break;
		case 2:
			fetchstaffByDesignation();
			break;
		case 3:
			fetchStaffById();
			break;
		case 4:
			updateStaffDetails();
			break;
		default:
			System.exit(0);
		}

	}

	private static void updateStaffDetails() throws StaffManagementException {
		// TODO Auto-generated method stub
		StaffInfoService staffService = new StaffInfoService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Staff ID:");
		Integer staff_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The  Staff name:");
		String staff_name = s.nextLine();
		System.out.println("Please Enter The designation:");
		String designation = s.nextLine();
		System.out.println("Please Enter The Doctorid:");
		Integer doctor_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Staff salary:");
		Float staff_salary = Float.parseFloat(s.nextLine());

		StaffInfoVO vo = new StaffInfoVO();

		vo.setStaff_id(staff_id);

		vo.setStaff_name(staff_name);
		vo.setDesignation(designation);
		vo.setDoctor_id(doctor_id);
		vo.setStaff_salary(staff_salary);
		StaffInfoResponseObject obj = null;

		obj = staffService.updateStaffDetails(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchstaffByDesignation()throws StaffNotFoundException { {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Staff Desination:");
		String designation = s.nextLine();

		StaffInfoService staffService = new StaffInfoService();
		StaffInfoResponseObject  obj = null;
		obj=staffService.fetchStaffbyDesignation(designation);
		StaffInfoVO vo = new StaffInfoVO();
		Map<String, StaffInfoVO> map = new HashMap<String, StaffInfoVO>();
		map=obj.getStaffInfoMap();
		if (map != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("Staff_id" + '\t' + "Staff_name" + '\t' + "designation" + '\t' + " doctor_id" + '\t' + " Staff_Salary" );    
			System.out.println(
					"================================================================================================");
			System.out.println(map.get(designation));

		} else {
			System.out.println(obj.getFailureMessage());
		}
	}

	}

	private static void fetchStaffById() throws StaffNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The staff ID:");
		Integer staff_id = Integer.parseInt(s.nextLine());

		StaffInfoService staffService = new StaffInfoService();
		StaffInfoResponseObject obj = null;
		obj = staffService.fetchStaffById(staff_id);
		StaffInfoVO vo = new StaffInfoVO();
		vo = obj.getStaffInfoVO();
		if (vo != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("Staff_Id" + '\t' + "Staff_Name" + '\t' + "Designation" + '\t' + " Doctor_Id" +'\t'+"Staff Salary");
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getStaff_id() + "\t\t" + vo.getStaff_name() + "\t\t" + vo.getDesignation() + "\t\t"
					+ vo.getDoctor_id()+"\t\t"+vo.getStaff_salary());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}


	

	
	// TODO Auto-generated method stub

	private static void addStaff() throws StaffManagementException {
		// TODO Auto-generated method stub
		StaffInfoService staffService = new StaffInfoService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Staff ID:");
		Integer staff_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The  Staff name:");
		String staff_name = s.nextLine();
		System.out.println("Please Enter The designation:");
		String designation = s.nextLine();
		System.out.println("Please Enter The Doctorid:");
		Integer doctor_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Staff salary:");
		Float staff_salary = Float.parseFloat(s.nextLine());

		StaffInfoVO vo = new StaffInfoVO();

		vo.setStaff_id(staff_id);
		;
		vo.setStaff_name(staff_name);
		vo.setDesignation(designation);
		vo.setDoctor_id(doctor_id);
		vo.setStaff_salary(staff_salary);

		StaffInfoResponseObject obj = null;
		obj = staffService.addStaff(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
}
*/
	public static void main(String[] args) throws StaffTimingsManagementException, StaffTimingsNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Please select one of the below options");
		System.out.println("1. add Staff Timings");
		System.out.println("2. Fetch staff by Time_in");
		System.out.println("3. Fetch staff by ID");
		System.out.println("4. Update Staff Timings ");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addStaffTimings();
			break;
		case 2:
			fetchstaffByTime_in();
			break;
		case 3:
			 fetchStaffById();
			break;
		case 4:
			updateStaff();
			break;
		default:
			System.exit(0);
		}

	}

	

	private static void updateStaff() throws StaffTimingsManagementException {
		// TODO Auto-generated method stub
		StaffInfoService staffService = new StaffInfoService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Time_id:");
		Integer Time_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The  date:");
		Date date =  Date.valueOf(s.nextLine());
		System.out.println("Please Enter The Time_in:");
		String Time_in = s.nextLine();
		System.out.println("Please Enter The Time_out:");
		String Time_out = s.nextLine();
		System.out.println("Please Enter The Staff_id:");
		Integer Staff_id = Integer.parseInt(s.nextLine());

		StaffTimingsVO vo = new StaffTimingsVO();

		vo.setTime_id(Time_id);

		vo.setDate(date);
		vo.setTime_in(Time_in);
		vo.setTime_out(Time_out);
		vo.setStaff_id(Staff_id);;
		StaffTimingsResponseObject obj = null;

		obj = staffService.updateStaff(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
		// TODO Auto-generated method stub
		
	

	private static void fetchstaffByTime_in()throws StaffTimingsNotFoundException {
		// TODO Auto-generated method stub
		
			Scanner s = new Scanner(System.in);
			System.out.println("Please Enter The Staff Time_in:");
			String time_in = s.nextLine();

			StaffInfoService staffService = new StaffInfoService();
			StaffTimingsResponseObject obj = null;
			obj=staffService.fetchstaffByTime_in(time_in);
			StaffTimingsVO vo = new StaffTimingsVO();
			Map<String, StaffTimingsVO> map = new HashMap<String,  StaffTimingsVO>();
			map=obj.getStaffTimingsMap();
			if (map!= null) {
				System.out.println(
						"================================================================================================");
				System.out.println("Time_id" + '\t' + "date" + '\t' + " Time_in" + '\t' + " Time_out" + '\t' + " Staff_id" );    
				System.out.println(
						"================================================================================================");
				System.out.println(map);

			} else {
				System.out.println(obj.getFailureMessage());
			}
		}

		
		
	


		private static void fetchStaffById() throws StaffTimingsNotFoundException, StaffTimingsManagementException {
			// TODO Auto-generated method stub
			Scanner s = new Scanner(System.in);
			System.out.println("Please Enter The staff ID:");
			Integer staff_id = Integer.parseInt(s.nextLine());

			StaffInfoService staffService = new StaffInfoService();
			StaffTimingsResponseObject obj = null;
			obj = staffService.fetchStaffById(staff_id);
			StaffTimingsVO vo = new StaffTimingsVO();
			vo = obj.getStaffInfoVO();
			if (vo != null) {
				System.out.println(
						"================================================================================================");
				System.out.println("Time_id" + "\t\t" + "Date" + "\t\t" + "Time_in" + "\t\t" + " Time_out" +"\t\t"+"Staff_id");
				System.out.println(
						"================================================================================================");
				System.out.println(vo.getTime_id() + "\t\t" + vo.getDate() + "\t\t" + vo.getTime_in() + "\t\t"
						+ vo.getTime_out()+"\t\t"+vo.getStaff_id());
			} else {
				System.out.println(obj.getFailureMessage());
			}
		}
		// TODO Auto-generated method stub
		
	

	private static void addStaffTimings()throws StaffTimingsManagementException {
	
			// TODO Auto-generated method stub
			StaffInfoService staffService = new StaffInfoService();
			Scanner s = new Scanner(System.in);
			boolean flag;
			System.out.println("Please Enter The Time_id:");
			Integer time_id = Integer.parseInt(s.nextLine());
			System.out.println("Please Enter The   Date:");
			Date date=Date.valueOf(s.nextLine());
			System.out.println("Please Enter The Time_in:");
			String time_in = s.nextLine();
			System.out.println("Please Enter The Time_out:");
			String time_out = s.nextLine();
			System.out.println("Please Enter The Staff_id:");
			Integer staff_id = Integer.parseInt(s.nextLine());

			StaffTimingsVO vo = new StaffTimingsVO();

			vo.setTime_id(time_id);
			
			vo.setDate(date);
			vo.setTime_in(time_in);
			vo.setTime_out(time_out);
			vo.setTime_out(time_out);

			StaffTimingsResponseObject obj = null;
			obj = staffService.addStaffdetails(vo);
			if (obj.getSuccessMessage() != null) {
				System.out.println(obj.getSuccessMessage());
			} else {
				System.out.println(obj.getFailureMessage());
			}

	}
		// TODO Auto-generated method stub
		
	}

/*	private static void updateStaffDetails() throws StaffManagementException {
		// TODO Auto-generated method stub
		StaffInfoService staffService = new StaffInfoService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Staff ID:");
		Integer staff_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The  Staff name:");
		String staff_name = s.nextLine();
		System.out.println("Please Enter The designation:");
		String designation = s.nextLine();
		System.out.println("Please Enter The Doctorid:");
		Integer doctor_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Staff salary:");
		Float staff_salary = Float.parseFloat(s.nextLine());

		StaffTimingsVO vo = new StaffTimingsVO();

		vo.setStaff_id(staff_id);

		vo.setStaff_name(staff_name);
		vo.setDesignation(designation);
		vo.setDoctor_id(doctor_id);
		vo.setStaff_salary(staff_salary);
		StaffInfoResponseObject obj = null;

		obj = staffService.updateStaff(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}
	} 
	public static void main(String[] args) throws MaintenanceInfoManagementException, MaintenanceInfoNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Please select one of the below options");
		System.out.println("1. addmaintenance_details");
		System.out.println("2. fetchbymaintenance_details");
		System.out.println("3. fetchmaintenanceById");
		System.out.println("4. updatemaintenance_details");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addmaintenance_details();
			break;
		case 2:
			fetchbymaintenance_details();
			break;
		case 3:
			fetchmaintenanceById();
			break;
		case 4:
			updatemaintenance_details();
			break;
		default:
			System.exit(0);
		}

	}

	private static void updatemaintenance_details()throws MaintenanceInfoManagementException  {
		// TODO Auto-generated method stub
		StaffInfoService staffService = new StaffInfoService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Maintenance_id:");
		Integer maintenance_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Maintenance_details:");
		String maintenance_details = s.nextLine();
		System.out.println("Please Enter The maintenance_amount:");
		Float maintenance_amount = Float.parseFloat(s.nextLine());
		
		MaintenanceInfoVO vo = new MaintenanceInfoVO();

		vo.setMaintenance_id(maintenance_id);

		vo.setMaintenance_details(maintenance_details);
		vo.setMaintenance_amount(maintenance_amount);
		MaintenanceInfoResponseObject obj = null;

		obj = staffService.updatemaintenance_details(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
	

	private static void fetchmaintenanceById()throws MaintenanceInfoNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Maintenance_id:");
		Integer maintenance_id = Integer.parseInt(s.nextLine());

		StaffInfoService staffService = new StaffInfoService();
		MaintenanceInfoResponseObject obj = null;
		obj = staffService.fetchMaintenanceById(maintenance_id);
		MaintenanceInfoVO vo = new MaintenanceInfoVO();
		vo = obj.getMaintenanceInfoVO();
		if (vo != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("Maintenance_id" + '\t' + "Maintenance_details" + '\t' + "Maintenance_amount");
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getMaintenance_id() + "\t\t" + vo.getMaintenance_details() + "\t\t" + vo.getMaintenance_amount());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}
	

	private static void fetchbymaintenance_details()throws MaintenanceInfoNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Maintenance_details:");
		String Maintenance_details= s.nextLine();

		StaffInfoService staffService = new StaffInfoService();
		MaintenanceInfoResponseObject  obj = null;
		obj=staffService.fetchStaffbymaintenance_details(Maintenance_details);
		MaintenanceInfoVO vo = new MaintenanceInfoVO();
		Map<String, MaintenanceInfoVO> map = new HashMap<String, MaintenanceInfoVO>();
		map=obj.getMaintenanceIinfomap();
		if (map != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("Maintenance_id" + '\t' + "Maintenance_details" + '\t' + "Maintenance_amount");    
			System.out.println(
					"================================================================================================");
			System.out.println(map.get(Maintenance_details));

		} else {
			System.out.println(obj.getFailureMessage());
		}
	}

		
	

	private static void addmaintenance_details() throws MaintenanceInfoManagementException {
		// TODO Auto-generated method stub
		StaffInfoService staffService = new StaffInfoService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Maintenance_details:");
		String maintenance_details = s.nextLine();
		System.out.println("Please Enter The maintenance_amount:");
		Float maintenance_amount = Float.parseFloat(s.nextLine());

		MaintenanceInfoVO vo = new MaintenanceInfoVO();

		vo.setMaintenance_details(maintenance_details);
		vo.setMaintenance_amount(maintenance_amount);
		MaintenanceInfoResponseObject obj = null;

		obj = staffService.addmaintenance_details(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
}
		
	

		
		
	

/*	private static void updateStaffDetails() throws StaffManagementException {
		// TODO Auto-generated method stub
		StaffInfoService staffService = new StaffInfoService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Staff ID:");
		Integer staff_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The  Staff name:");
		String staff_name = s.nextLine();
		System.out.println("Please Enter The designation:");
		String designation = s.nextLine();
		System.out.println("Please Enter The Doctorid:");
		Integer doctor_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Staff salary:");
		Float staff_salary = Float.parseFloat(s.nextLine());

		StaffInfoVO vo = new StaffInfoVO();

		vo.setStaff_id(staff_id);

		vo.setStaff_name(staff_name);
		vo.setDesignation(designation);
		vo.setDoctor_id(doctor_id);
		vo.setStaff_salary(staff_salary);
		StaffInfoResponseObject obj = null;

		obj = staffService.updateStaffDetails(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchstaffByDesignation()throws StaffNotFoundException { {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Staff Desination:");
		String designation = s.nextLine();

		StaffInfoService staffService = new StaffInfoService();
		StaffInfoResponseObject  obj = null;
		obj=staffService.fetchStaffbyDesignation(designation);
		StaffInfoVO vo = new StaffInfoVO();
		Map<String, StaffInfoVO> map = new HashMap<String, StaffInfoVO>();
		map=obj.getStaffInfoMap();
		if (map != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("Staff_id" + '\t' + "Staff_name" + '\t' + "designation" + '\t' + " doctor_id" + '\t' + " Staff_Salary" );    
			System.out.println(
					"================================================================================================");
			System.out.println(map.get(designation));

		} else {
			System.out.println(obj.getFailureMessage());
		}
	}

	}

	private static void fetchStaffById() throws StaffNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The staff ID:");
		Integer staff_id = Integer.parseInt(s.nextLine());

		StaffInfoService staffService = new StaffInfoService();
		StaffInfoResponseObject obj = null;
		obj = staffService.fetchStaffById(staff_id);
		StaffInfoVO vo = new StaffInfoVO();
		vo = obj.getStaffInfoVO();
		if (vo != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("Staff_Id" + '\t' + "Staff_Name" + '\t' + "Designation" + '\t' + " Doctor_Id" +'\t'+"Staff Salary");
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getStaff_id() + "\t\t" + vo.getStaff_name() + "\t\t" + vo.getDesignation() + "\t\t"
					+ vo.getDoctor_id()+"\t\t"+vo.getStaff_salary());
		} else {
			System.out.println(obj.getFailureMessage());
		}
	}


	

	
	// TODO Auto-generated method stub

	private static void addStaff() throws StaffManagementException {
		// TODO Auto-generated method stub
		StaffInfoService staffService = new StaffInfoService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Staff ID:");
		Integer staff_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The  Staff name:");
		String staff_name = s.nextLine();
		System.out.println("Please Enter The designation:");
		String designation = s.nextLine();
		System.out.println("Please Enter The Doctorid:");
		Integer doctor_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Staff salary:");
		Float staff_salary = Float.parseFloat(s.nextLine());

		StaffInfoVO vo = new StaffInfoVO();

		vo.setStaff_id(staff_id);
		;
		vo.setStaff_name(staff_name);
		vo.setDesignation(designation);
		vo.setDoctor_id(doctor_id);
		vo.setStaff_salary(staff_salary);

		StaffInfoResponseObject obj = null;
		obj = staffService.addStaff(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
}*/