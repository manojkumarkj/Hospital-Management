package com.demo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.bo.HospitalManagementBO;
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
import com.demo.vo.DoctorInfoVO;
import com.demo.vo.DoctorTimingsVO;
import com.demo.vo.PharmacyAdministrationVO;
import com.demo.vo.RoomManagementVO;

public class HospitalManagementService {
	HospitalManagementBO bo1 = new HospitalManagementBO();
	DoctorInfoResponseObject obj1 = new DoctorInfoResponseObject();
	HospitalManagementBO bo2 = new HospitalManagementBO();
	DoctorTimingsResponseObject obj2 = new DoctorTimingsResponseObject();
	HospitalManagementBO bo3 = new HospitalManagementBO();
	PharmacyAdministrationResponseObject obj3 = new PharmacyAdministrationResponseObject();
	HospitalManagementBO bo4 = new HospitalManagementBO();
	RoomManagementResponseObject obj4 = new RoomManagementResponseObject();

	// Doctor_InfoService starting

	public DoctorInfoResponseObject addDoctor(DoctorInfoVO vo) throws DoctorManagementException {
		boolean flag;
		try {
			flag = bo1.addDoctor(vo);
			if (flag)
				obj1.setSuccessMessage("Doctor Added Successfully");
			else
				obj1.setFailureMessage("Error When Adding Doctor Details, Reach out Administrator");

		} catch (DoctorManagementException e) {
			obj1.setFailureMessage("Error When Adding The Doctor Details" + e.getMessage());
		}

		return obj1;

	}

	public DoctorInfoResponseObject fetchDoctorById(int doctor_id) throws DoctorNotFoundException {

		try {
			DoctorInfoVO vo=new DoctorInfoVO();
			vo = bo1.fetchDoctorById(doctor_id);
			obj1.setDoctorInfoVO(vo);
		} catch (DoctorNotFoundException e) {
			obj1.setFailureMessage("Fetch Doctor is not in the List" + e.getMessage());
		}

		return obj1;

	}

	public DoctorInfoResponseObject fetchDoctorByName(String doctor_name) throws DoctorNotFoundException {

		try {
			Map<Integer, DoctorInfoVO> map =new HashMap<Integer, DoctorInfoVO>();
			map =bo1.fetchDoctorByName(doctor_name);
			obj1.setDoctorInfoMap(map);

		} catch (DoctorNotFoundException e) {
			obj1.setFailureMessage("Error When Fetching The Doctor Details" + e.getMessage());
		}

		return obj1;

	}

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
	public DoctorInfoResponseObject fetchDoctorMatchesByName(String doctor_name) throws DoctorNotFoundException
	{
		try{
			List<DoctorInfoVO> list =new ArrayList<DoctorInfoVO>();
			list=bo1.fetchDoctorMatchesByName(doctor_name);
			obj1.setDoctorInfoList(list);
		}catch (DoctorNotFoundException e) {
			obj1.setFailureMessage("Fetch Doctor is not in the List" + e.getMessage());
		}
		return obj1;
	}


	public DoctorInfoResponseObject updateDoctor(DoctorInfoVO vo) throws DoctorManagementException {
		boolean flag;
		try {
			flag = bo1.updateDoctor(vo);
			if (flag)
				obj1.setSuccessMessage("Doctor Updated Successfully");
			else
				obj1.setFailureMessage("Error When Updating Doctor Details, Reach out Administrator");

		} catch (DoctorManagementException e) {
			obj1.setFailureMessage("Error When Updating The Doctor Details" + e.getMessage());
		}

		return obj1;

	}
	// Doctor_InfoService ending

	// Doctor_TimingsService starting

	public DoctorTimingsResponseObject addTimings(DoctorTimingsVO vo) throws TimingsManagementException {
		boolean flag;
		try {
			flag = bo2.addTimings(vo);
			if (flag)
				obj2.setSuccessMessage("Doctor Added Successfully");
			else
				obj2.setFailureMessage("Error When Adding Doctor Details, Reach out Administrator");

		} catch (TimingsManagementException e) {
			obj2.setFailureMessage("Error When Adding The Doctor Details" + e.getMessage());
		}

		return obj2;

	}

	public DoctorTimingsResponseObject fetchByDate(Date date) throws TimingsNotFoundException {
		try {
			Map<Date, DoctorTimingsVO> map = new HashMap<Date, DoctorTimingsVO>();
			map = bo2.fetchByDate(date);
			obj2.setDoctorTimingsMap1(map);
		} catch (TimingsNotFoundException e) {
			obj2.setFailureMessage("Fetch Timings is not in the List" + e.getMessage());
		}
		return obj2;
	}

	public DoctorTimingsResponseObject fetchByDoctorid(int doctor_id) throws TimingsNotFoundException {
		try {
			Map<Integer, DoctorTimingsVO> map = new HashMap<Integer, DoctorTimingsVO>();
			map = bo2.fetchByDoctorid(doctor_id);
			obj2.setDoctorTimingsMap2(map);
		} catch (TimingsNotFoundException e) {
			obj2.setFailureMessage("Fetch Timings is not in the List" + e.getMessage());
		}
		return obj2;
	}

	public DoctorTimingsResponseObject updateTimings(DoctorTimingsVO vo) throws TimingsManagementException {
		boolean flag;
		try {
			flag = bo2.updateTimings(vo);
			if (flag)
				obj2.setSuccessMessage("Doctor Updated Successfully");
			else
				obj2.setFailureMessage("Error When Updating Doctor Details, Reach out Administrator");

		} catch (TimingsManagementException e) {
			obj2.setFailureMessage("Error When Updating The Doctor Details" + e.getMessage());
		}

		return obj2;

	}
	// Doctor_TimingsService ending

	// Pharmacy_AdministrationService starting

	public PharmacyAdministrationResponseObject addMedicine(PharmacyAdministrationVO vo)
			throws MedicineManagementException {
		boolean flag;
		try {
			flag = bo3.addMedicine(vo);
			if (flag)
				obj3.setSuccessMessage("Medicine Added Successfully");
			else
				obj3.setFailureMessage("Error When Adding Medicine Details, Reach out Administrator");

		} catch (MedicineManagementException e) {
			obj3.setFailureMessage("Error When Adding The Medicine Details" + e.getMessage());
		}

		return obj3;

	}

	public PharmacyAdministrationResponseObject fetchByMedicineId(int medicine_id) throws MedicineNotFoundException {
		try {
			Map<Integer, PharmacyAdministrationVO> map = new HashMap<Integer, PharmacyAdministrationVO>();
			map = bo3.fetchByMedicineId(medicine_id);
			obj3.setPharmacyAdministrationMap2(map);
		} catch (MedicineNotFoundException e) {
			throw new MedicineNotFoundException("Error while fetching" + e.getMessage());
		}
		return obj3;
	}

	public PharmacyAdministrationResponseObject fetchByMedicineName(String medicine_name)
			throws MedicineNotFoundException {
		try {
			Map<String, PharmacyAdministrationVO> map = new HashMap<String, PharmacyAdministrationVO>();
			map = bo3.fetchByMedicineName(medicine_name);
			obj3.setPharmacyAdministrationMap1(map);
		} catch (MedicineNotFoundException e) {
			throw new MedicineNotFoundException("Error while fetching" + e.getMessage());
		}
		return obj3;
	}

	public PharmacyAdministrationResponseObject updateMedicine(PharmacyAdministrationVO vo)
			throws MedicineManagementException {
		boolean flag;
		try {
			flag = bo3.updateMedicine(vo);
			if (flag)
				obj3.setSuccessMessage("Medicine Updated Successfully");
			else
				obj3.setFailureMessage("Error When Updating Medicine Details, Reach out Administrator");

		} catch (MedicineManagementException e) {
			obj3.setFailureMessage("Error When Updating The Medicine Details" + e.getMessage());
		}

		return obj3;

	}
	// Pharmacy_AdministrationService ending

	// Room_ManagementService starting

	public RoomManagementResponseObject addRoom(RoomManagementVO vo) throws RoomManagementException {
		boolean flag;
		try {
			flag = bo4.addRoom(vo);
			if (flag)
				obj4.setSuccessMessage("Room Added Successfully");
			else
				obj4.setFailureMessage("Error When Adding The Room Details, Reach out Administrator");

		} catch (RoomManagementException e) {
			obj4.setFailureMessage("Error When Adding The Room Details" + e.getMessage());
		}

		return obj4;

	}

	public RoomManagementResponseObject fetchRoomByRoomNumber(int room_number) throws RoomNotFoundException {
		try {
			RoomManagementVO vo;
			vo = bo4.fetchRoomByRoomNumber(room_number);
			obj4.setRoomManagementVO(vo);
		} catch (RoomNotFoundException e) {
			throw new RoomNotFoundException("Error while fetching" + e.getMessage());
		}
		return obj4;
	}

	public RoomManagementResponseObject updateRoom(RoomManagementVO vo) throws RoomManagementException {
		boolean flag;
		try {
			flag = bo4.updateRoom(vo);
			if (flag)
				obj4.setSuccessMessage("Room Updated Successfully");
			else
				obj4.setFailureMessage("Error When Updating The Room Details, Reach out Administrator");

		} catch (RoomManagementException e) {
			obj4.setFailureMessage("Error When updating The Room Details" + e.getMessage());
		}

		return obj4;

	}
	// Room_ManagementService ending

}
