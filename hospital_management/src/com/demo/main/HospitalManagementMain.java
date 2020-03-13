package com.demo.main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.demo.exception.DoctorManagementException;
import com.demo.exception.DoctorNotFoundException;
import com.demo.exception.MedicineManagementException;
import com.demo.exception.MedicineNotFoundException;
import com.demo.exception.RoomManagementException;
import com.demo.exception.RoomNotFoundException;
import com.demo.exception.TimingsManagementException;
import com.demo.exception.TimingsNotFoundException;
import com.demo.response.DoctorInfoResponseObject;
import com.demo.response.DoctorTimingsResponseObject;
import com.demo.response.PharmacyAdministrationResponseObject;
import com.demo.response.RoomManagementResponseObject;
import com.demo.service.HospitalManagementService;
import com.demo.vo.DoctorInfoVO;
import com.demo.vo.DoctorTimingsVO;
import com.demo.vo.PharmacyAdministrationVO;
import com.demo.vo.RoomManagementVO;

public class HospitalManagementMain {

	public static void main(String[] args) throws DoctorManagementException, DoctorNotFoundException ,TimingsManagementException, TimingsNotFoundException,MedicineManagementException, MedicineNotFoundException,RoomManagementException, RoomNotFoundException{

		//Doctor_Info_Main starting
		
		System.out.println("Please select one of the below options");
		System.out.println("1. Add Doctors");
		System.out.println("2. Fetch Doctor by Doctor id");
		System.out.println("3. Fetch Doctor by Name");
		System.out.println("4. Fetch Doctor By Doctor id using Joins");
		System.out.println("5. Fetch Doctor By Doctor name using matches");
		System.out.println("6. Update Doctor");
		System.out.println("7. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addDoctor();
			break;
		case 2:
			fetchDoctorById();
			break;
		case 3:
			fetchDoctorName();
			break;
		case 4:
			fetchDoctorByIdJoins();
			break;
		case 5:
			fetchDoctorMatchesByName();
			break;
		case 6:
			updateDoctor();
			break;
		default:
			System.exit(0);
		}
		//Doctor_Info_Main ending 
		
		/*//Doctor_Timings_Main starting
		
		System.out.println("Please select one of the below options");
		System.out.println("1. Add Timings");
		System.out.println("2. Fetch Timings by Date");
		System.out.println("3. Fetch Timings by DoctorID");
		System.out.println("4. Update Timings Details");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addTimings();
			break;
		case 2:
			fetchTimingsByDate();
			break;
		case 3:
			fetchTimingsByDoctorid();
			break;
		case 4:
			updateTimings();
			break;
		default:
			System.exit(0);
		}
		//Doctor_Timings_Main ending*/
		
		/*//Pharmacy_Administration_Main starting
		
		System.out.println("Please select one of the below options");
		System.out.println("1. Add Medicine");
		System.out.println("2. Fetch Medicine by Medicine ID");
		System.out.println("3. Fetch Medicine by Medicine Name");
		System.out.println("4. Update Medicine Details");
		System.out.println("5. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addMedicine();
			break;
		case 2:
			fetchMedicinebyId();
			break;
		case 3:
			fetchMedicineByName();
			break;
		case 4:
			updateMedicine();
			break;
		default:
			System.exit(0);
		}
		//Pharmacy_Administration_Main ending*/
		
		/*//Room_Management_Main starting
		System.out.println("Please select one of the below options");
		System.out.println("1. Add Room");
		System.out.println("2. Fetch Room by Room Number");
		System.out.println("3. Update Room Details");
		System.out.println("4. Exit");
		Scanner s = new Scanner(System.in);
		int menuSelected = s.nextInt();
		switch (menuSelected) {
		case 1:
			addRoom();
			break;
		case 2:
			fetchByRoomNumber();
			break;
		case 3:
			updateRoom();
			break;
		default:
			System.exit(0);
		}
		//Room_Management_Main ending*/
		
		
	}
	
	//Doctor_Info Methods starting
	
	private static void addDoctor() throws DoctorManagementException {
		// TODO Auto-generated method stub
		HospitalManagementService doctorService = new HospitalManagementService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Doctor ID:");
		Integer doctor_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Doctor Name:");
		String doctor_name = s.nextLine();
		System.out.println("Please Enter The Specialist:");
		String specialist = s.nextLine();
		System.out.println("Please Enter The Doctor Salary:");
		Float doctor_salary = Float.parseFloat(s.nextLine());
		DoctorInfoVO vo = new DoctorInfoVO();

		vo.setDoctor_id(doctor_id);
		vo.setDoctor_name(doctor_name);
		vo.setSpecialist(specialist);
		vo.setDoctor_salary(doctor_salary);
		DoctorInfoResponseObject obj = null;
		obj = doctorService.addDoctor(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchDoctorById() throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Doctor ID:");
		Integer doctor_id = Integer.parseInt(s.nextLine());

		HospitalManagementService doctorService = new HospitalManagementService();
		DoctorInfoResponseObject obj = null;
		obj = doctorService.fetchDoctorById(doctor_id);
		DoctorInfoVO vo = new DoctorInfoVO();
		vo = obj.getDoctorInfoVO();
		if (vo != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("DoctorId" + '\t' + "DoctorName" + '\t' + "Specialist" + '\t' + " DoctorSalary");
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getDoctor_id() + "\t\t" + vo.getDoctor_name() + "\t\t" + vo.getSpecialist() + "\t\t"
					+ vo.getDoctor_salary());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchDoctorName() throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Doctor Name:");
		String doctor_name = s.nextLine();

		HospitalManagementService doctorService = new HospitalManagementService();
		DoctorInfoResponseObject obj = null;
		obj = doctorService.fetchDoctorByName(doctor_name);
		Map<Integer, DoctorInfoVO> map = new HashMap<Integer, DoctorInfoVO>();
		map = obj.getDoctorInfoMap();

		if (map != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("DoctorId" + '\t' + "DoctorName" + '\t' + "Specialist" + '\t' + " DoctorSalary");
			System.out.println(
					"================================================================================================");
			for(Map.Entry<Integer, DoctorInfoVO> entry:map.entrySet())
			{
				System.out.println(entry.getKey());
				//System.out.println(entry.getValue());
			}

		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchDoctorByIdJoins() throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Doctor ID:");
		Integer doctor_id = Integer.parseInt(s.nextLine());

		HospitalManagementService doctorService = new HospitalManagementService();
		DoctorInfoResponseObject obj = null;
		obj = doctorService.fetchDoctorByIdJoins(doctor_id);
		DoctorInfoVO vo = new DoctorInfoVO();
		DoctorTimingsVO vo1 = new DoctorTimingsVO();
		vo = obj.getDoctorInfoVO();
		if (vo != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("DoctorId" + '\t' + "DoctorName" + '\t' + "Specialist" + '\t' + "Date" + '\t'
					+ "TimeIn" + '\t' + "TimeOut");
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getDoctor_id() + "\t\t" + vo.getDoctor_name() + "\t\t" + vo.getSpecialist()
					+ "\t\t" + vo1.getDate() + "\t\t" + vo1.getTime_in() + "\t\t" + vo1.getTime_out());


		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
	private static void fetchDoctorMatchesByName() throws DoctorNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Doctor Name:");
		String doctor_name = s.nextLine();

		HospitalManagementService doctorService = new HospitalManagementService();
		DoctorInfoResponseObject obj = null;
		obj = doctorService.fetchDoctorMatchesByName(doctor_name);
		List<DoctorInfoVO> list;
		list = obj.getDoctorInfoList();
		if(!list.isEmpty()&&obj.getFailureMessage()==null)
		{
			for(DoctorInfoVO vo:list)
			{
				System.out.println(vo);
			}
		}else if(list.isEmpty())
		{
			System.out.println(obj.getFailureMessage());

		}
	}

	private static void updateDoctor() throws DoctorManagementException {
		// TODO Auto-generated method stub
		HospitalManagementService doctorService = new HospitalManagementService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Doctor ID:");
		Integer doctor_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Doctor Name:");
		String doctor_name = s.nextLine();
		System.out.println("Please Enter The Specialist:");
		String specialist = s.nextLine();
		System.out.println("Please Enter The Doctor Salary:");
		Float doctor_salary = Float.parseFloat(s.nextLine());
		DoctorInfoVO vo = new DoctorInfoVO();

		vo.setDoctor_id(doctor_id);
		vo.setDoctor_name(doctor_name);
		vo.setSpecialist(specialist);
		vo.setDoctor_salary(doctor_salary);
		DoctorInfoResponseObject obj = null;
		obj = doctorService.updateDoctor(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
	//Doctor_Info_Methods ending
	
	//Doctor_Timings_Methods starting
	
	private static void addTimings() throws TimingsManagementException {
		// TODO Auto-generated method stub
		HospitalManagementService doctorTimingsService = new HospitalManagementService();
		Scanner s = new Scanner(System.in);
		
		System.out.println("Please Enter The Time ID:");
		Integer time_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Date:");
		Date date = Date.valueOf(s.nextLine());
		System.out.println("Please Enter The Time In:");
		String time_in = s.nextLine();
		System.out.println("Please Enter The Time Out:");
		String time_out = s.nextLine();
		System.out.println("Please Enter The Doctor ID:");
		Integer doctor_id = Integer.parseInt(s.nextLine());

		DoctorTimingsVO vo = new DoctorTimingsVO();

		vo.setTime_id(time_id);
		vo.setDate(date);
		vo.setTime_in(time_in);
		vo.setTime_out(time_out);
		vo.setDoctor_id(doctor_id);
		DoctorTimingsResponseObject obj = null;
		obj = doctorTimingsService.addTimings(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchTimingsByDate() throws TimingsNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Date:");
		Date date = Date.valueOf(s.nextLine());

		HospitalManagementService doctorTimingsService = new HospitalManagementService();
		DoctorTimingsResponseObject obj = null;
		obj = doctorTimingsService.fetchByDate(date);
		DoctorTimingsVO vo = new DoctorTimingsVO();
		Map<Date, DoctorTimingsVO> map = new HashMap<Date, DoctorTimingsVO>();
		map = obj.getDoctorTimingsMap1();

		if (map != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("TimeId" + '\t' + "Date" + '\t' + "Time IN" + '\t' + " Time OUT" + '\t' + "Doctor ID");
			System.out.println(
					"================================================================================================");
			System.out.println(map.get(date));

		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchTimingsByDoctorid() throws TimingsNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Doctor ID:");
		Integer doctor_id = Integer.parseInt(s.nextLine());

		HospitalManagementService doctorTimingsService = new HospitalManagementService();
		DoctorTimingsResponseObject obj = null;
		obj = doctorTimingsService.fetchByDoctorid(doctor_id);
		DoctorTimingsVO vo = new DoctorTimingsVO();
		Map<Integer, DoctorTimingsVO> map = new HashMap<Integer, DoctorTimingsVO>();
		map = obj.getDoctorTimingsMap2();

		if (map != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("TimeId" + '\t' + "Date" + '\t' + "Time IN" + '\t' + " Time OUT" + '\t' + "Doctor ID");
			System.out.println(
					"================================================================================================");
			System.out.println(map.get(doctor_id));

		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void updateTimings() throws TimingsManagementException {
		// TODO Auto-generated method stub
		HospitalManagementService doctorTimingsService = new HospitalManagementService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Time ID:");
		Integer time_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Date:");
		Date date = Date.valueOf(s.nextLine());
		System.out.println("Please Enter The Time In:");
		String time_in = s.nextLine();
		System.out.println("Please Enter The Time Out:");
		String time_out = s.nextLine();
		System.out.println("Please Enter The Doctor ID:");
		Integer doctor_id = Integer.parseInt(s.nextLine());

		DoctorTimingsVO vo = new DoctorTimingsVO();

		vo.setTime_id(time_id);
		vo.setDate(date);
		vo.setTime_in(time_in);
		vo.setTime_out(time_out);
		vo.setDoctor_id(doctor_id);
		DoctorTimingsResponseObject obj = null;
		obj = doctorTimingsService.updateTimings(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
	//Doctor_Timings_Methods ending
	
	//Pharmacy_Administration_Methods starting
	
	private static void addMedicine() throws MedicineManagementException {
		// TODO Auto-generated method stub
		HospitalManagementService pharmacyAdiminstrationService = new HospitalManagementService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Medicine ID:");
		Integer medicine_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Medicine Name:");
		String medicine_name = s.nextLine();
		System.out.println("Please Enter The Medicine MRP:");
		Float medicine_mrp = Float.parseFloat(s.nextLine());
		System.out.println("Please Enter The Stock Purchased:");
		Integer stock_purchased = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Stock Sold:");
		Integer stock_sold = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Stock Left:");
		Integer stock_left = Integer.parseInt(s.nextLine());
		PharmacyAdministrationVO vo = new PharmacyAdministrationVO();

		vo.setMedicine_id(medicine_id);
		vo.setMedicine_name(medicine_name);
		vo.setMedicine_mrp(medicine_mrp);
		vo.setStock_purchased(stock_purchased);
		vo.setStock_sold(stock_sold);
		vo.setStock_left(stock_left);
		PharmacyAdministrationResponseObject obj = null;
		obj = pharmacyAdiminstrationService.addMedicine(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchMedicinebyId() throws MedicineNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Medicine ID:");
		Integer medicine_id = Integer.parseInt(s.nextLine());

		HospitalManagementService pharmacyAdministrationService = new HospitalManagementService();
		PharmacyAdministrationResponseObject obj = null;
		obj = pharmacyAdministrationService.fetchByMedicineId(medicine_id);
		PharmacyAdministrationVO vo = new PharmacyAdministrationVO();
		Map<Integer, PharmacyAdministrationVO> map = new HashMap<Integer, PharmacyAdministrationVO>();
		map = obj.getPharmacyAdministrationMap2();

		if (map != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("MedicineId" + '\t' + "Medicine Name" + '\t' + "Medicine MRP" + '\t' + " Stock Purchased"
					+ '\t' + "Stock Sold" + '\t' + "Stock Left");
			System.out.println(
					"================================================================================================");
			System.out.println(map.get(medicine_id));

		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchMedicineByName() throws MedicineNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Medicine Name:");
		String medicine_name = s.nextLine();

		HospitalManagementService pharmacyAdministrationService = new HospitalManagementService();
		PharmacyAdministrationResponseObject obj = null;
		obj = pharmacyAdministrationService.fetchByMedicineName(medicine_name);
		PharmacyAdministrationVO vo = new PharmacyAdministrationVO();
		Map<String, PharmacyAdministrationVO> map = new HashMap<String, PharmacyAdministrationVO>();
		map = obj.getPharmacyAdministrationMap1();

		if (map != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("MedicineId" + '\t' + "Medicine Name" + '\t' + "Medicine MRP" + '\t' + " Stock Purchased"
					+ '\t' + "Stock Sold" + '\t' + "Stock Left");
			System.out.println(
					"================================================================================================");
			System.out.println(map.get(medicine_name));

		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void updateMedicine() throws MedicineManagementException {
		// TODO Auto-generated method stub
		HospitalManagementService pharmacyAdiminstrationService = new HospitalManagementService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Medicine ID:");
		Integer medicine_id = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Medicine Name:");
		String medicine_name = s.nextLine();
		System.out.println("Please Enter The Medicine MRP:");
		Float medicine_mrp = Float.parseFloat(s.nextLine());
		System.out.println("Please Enter The Stock Purchased:");
		Integer stock_purchased = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Stock Sold:");
		Integer stock_sold = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter The Stock Left:");
		Integer stock_left = Integer.parseInt(s.nextLine());
		PharmacyAdministrationVO vo = new PharmacyAdministrationVO();

		vo.setMedicine_id(medicine_id);
		vo.setMedicine_name(medicine_name);
		vo.setMedicine_mrp(medicine_mrp);
		vo.setStock_purchased(stock_purchased);
		vo.setStock_sold(stock_sold);
		vo.setStock_left(stock_left);
		PharmacyAdministrationResponseObject obj = null;
		obj = pharmacyAdiminstrationService.updateMedicine(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
	
	//Pharmacy_Administration_Methods ending
	
	//Room_Management_Methods starting
	
	private static void addRoom() throws RoomManagementException {
		// TODO Auto-generated method stub
		HospitalManagementService roomManagementService = new HospitalManagementService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Room Number:");
		Integer room_number = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter Suite Room:");
		String suite_room = s.nextLine();
		System.out.println("Please Enter The Room Charges:");
		Float room_charges = Float.parseFloat(s.nextLine());
		RoomManagementVO vo = new RoomManagementVO();

		vo.setRoom_number(room_number);
		vo.setSuite_room(suite_room);
		vo.setRoom_charges(room_charges);
		RoomManagementResponseObject obj = null;
		obj = roomManagementService.addRoom(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void fetchByRoomNumber() throws RoomNotFoundException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Please Enter The Room Number:");
		Integer room_number = Integer.parseInt(s.nextLine());

		HospitalManagementService roomManagementService = new HospitalManagementService();
		RoomManagementResponseObject obj = null;
		obj = roomManagementService.fetchRoomByRoomNumber(room_number);
		RoomManagementVO vo = new RoomManagementVO();
		vo = obj.getRoomManagementVO();
		if (vo != null) {
			System.out.println(
					"================================================================================================");
			System.out.println("Room Number" + '\t' + "Suite Room" + '\t' + "Room Charges");
			System.out.println(
					"================================================================================================");
			System.out.println(vo.getRoom_number() + "\t\t" + vo.getSuite_room() + "\t\t" + vo.getRoom_charges());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}

	private static void updateRoom() throws RoomManagementException {
		// TODO Auto-generated method stub
		HospitalManagementService roomManagementService = new HospitalManagementService();
		Scanner s = new Scanner(System.in);
		boolean flag;
		System.out.println("Please Enter The Room Number:");
		Integer room_number = Integer.parseInt(s.nextLine());
		System.out.println("Please Enter Suite Room:");
		String suite_room = s.nextLine();
		System.out.println("Please Enter The Room Charges:");
		Float room_charges = Float.parseFloat(s.nextLine());
		RoomManagementVO vo = new RoomManagementVO();

		vo.setRoom_number(room_number);
		vo.setSuite_room(suite_room);
		vo.setRoom_charges(room_charges);
		RoomManagementResponseObject obj = null;
		obj = roomManagementService.updateRoom(vo);
		if (obj.getSuccessMessage() != null) {
			System.out.println(obj.getSuccessMessage());
		} else {
			System.out.println(obj.getFailureMessage());
		}

	}
	//Room_Management_Methods ending

}
