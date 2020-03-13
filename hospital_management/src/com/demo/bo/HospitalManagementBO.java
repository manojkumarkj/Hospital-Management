package com.demo.bo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.dao.DoctorInfoDAO;
import com.demo.dao.DoctorTimingsDAO;
import com.demo.dao.PharmacyAdministrationDAO;
import com.demo.dao.RoomManagementDAO;
import com.demo.exception.DoctorManagementException;
import com.demo.exception.DoctorNotFoundException;
import com.demo.exception.MedicineManagementException;
import com.demo.exception.MedicineNotFoundException;
import com.demo.exception.RoomManagementException;
import com.demo.exception.RoomNotFoundException;
import com.demo.exception.TimingsManagementException;
import com.demo.exception.TimingsNotFoundException;
import com.demo.vo.DoctorInfoVO;
import com.demo.vo.DoctorTimingsVO;
import com.demo.vo.PharmacyAdministrationVO;
import com.demo.vo.RoomManagementVO;

public class HospitalManagementBO {
	DoctorInfoDAO dao1 = new DoctorInfoDAO();
	DoctorTimingsDAO dao2 = new DoctorTimingsDAO();
	PharmacyAdministrationDAO dao3 = new PharmacyAdministrationDAO();
	RoomManagementDAO dao4 = new RoomManagementDAO();

	// Doctor_InfoBO starting
	public boolean addDoctor(DoctorInfoVO vo) throws DoctorManagementException {
		try {
			boolean flag;
			flag = dao1.addDoctorDetails(vo);
			return flag;
		} catch (DoctorManagementException e) {
			throw new DoctorManagementException("Error When Adding The Doctor Details" + e.getMessage());

		}

	}

	public DoctorInfoVO fetchDoctorById(int doctor_id) throws DoctorNotFoundException {
		try {
			DoctorInfoVO vo = new DoctorInfoVO();
			vo = dao1.fetchDoctorById(doctor_id);
			return vo;
		} catch (DoctorNotFoundException e) {
			throw new DoctorNotFoundException("Error while fetching " + e.getMessage());
		}
	}

	public Map<Integer, DoctorInfoVO> fetchDoctorByName(String doctor_name) throws DoctorNotFoundException {
		try {
			Map<Integer, DoctorInfoVO> map = new HashMap<Integer, DoctorInfoVO>();
			map = dao1.fetchDoctorByName(doctor_name);
			return map;
		} catch (DoctorNotFoundException e) {
			throw new DoctorNotFoundException("Error while fetching " + e.getMessage());
		}
	}

	public DoctorInfoVO fetchDoctorByIdJoins(int doctor_id) throws DoctorNotFoundException {
		try {
			DoctorInfoVO vo = new DoctorInfoVO();
			vo = dao1.fetchDoctorByIdJoins(doctor_id);
			return vo;
		} catch (DoctorNotFoundException e) {
			throw new DoctorNotFoundException("Error while fetching " + e.getMessage());
		}
	}
	public List<DoctorInfoVO> fetchDoctorMatchesByName(String doctor_name) throws DoctorNotFoundException
	{
		try{
			List<DoctorInfoVO> list=new ArrayList<DoctorInfoVO>();
			list=dao1.fetchDoctorMatchesByName(doctor_name);
			return list;
		}catch (DoctorNotFoundException e) {
			throw new DoctorNotFoundException("Error while fetching " + e.getMessage());
		}
	}


	public boolean updateDoctor(DoctorInfoVO vo) throws DoctorManagementException {
		try {
			boolean flag;
			flag = dao1.updateDoctorDetails(vo);
			return flag;
		} catch (DoctorManagementException e) {
			throw new DoctorManagementException("Error When Updating The Doctor Details" + e.getMessage());

		}

	}
	// Doctor_InfoBO ending

	// Doctor_TimingsBO starting
	public boolean addTimings(DoctorTimingsVO vo) throws TimingsManagementException {
		try {
			boolean flag;
			flag = dao2.addTimingsDetails(vo);
			return flag;
		} catch (TimingsManagementException e) {
			throw new TimingsManagementException("Error while adding timings" + e.getMessage());
		}
	}

	public Map<Date, DoctorTimingsVO> fetchByDate(Date date) throws TimingsNotFoundException {
		try {
			Map<Date, DoctorTimingsVO> map = new HashMap<Date, DoctorTimingsVO>();
			map = dao2.fetchByDate(date);
			return map;
		} catch (TimingsNotFoundException e) {
			throw new TimingsNotFoundException("Error while fetching" + e.getMessage());
		}
	}

	public Map<Integer, DoctorTimingsVO> fetchByDoctorid(int doctor_id) throws TimingsNotFoundException {
		try {
			Map<Integer, DoctorTimingsVO> map = new HashMap<Integer, DoctorTimingsVO>();
			map = dao2.fetchByDoctorid(doctor_id);
			return map;
		} catch (TimingsNotFoundException e) {
			throw new TimingsNotFoundException("Error while fetching" + e.getMessage());
		}
	}

	public boolean updateTimings(DoctorTimingsVO vo) throws TimingsManagementException {
		try {
			boolean flag;
			flag = dao2.updateTimingsDetails(vo);
			return flag;
		} catch (TimingsManagementException e) {
			throw new TimingsManagementException("Error while Updating timings" + e.getMessage());
		}
	}
	// Doctor_TimingsBO ending

	// Pharmacy_AdministrationBO starting

	public boolean addMedicine(PharmacyAdministrationVO vo) throws MedicineManagementException {
		try {
			boolean flag;
			flag = dao3.addMedicineDetails(vo);
			return flag;
		} catch (MedicineManagementException e) {
			throw new MedicineManagementException("Error while adding medicine details" + e.getMessage());
		}
	}

	public Map<Integer, PharmacyAdministrationVO> fetchByMedicineId(int medicine_id) throws MedicineNotFoundException {
		try {
			Map<Integer, PharmacyAdministrationVO> map = new HashMap<Integer, PharmacyAdministrationVO>();
			map = dao3.fetchByMedicineId(medicine_id);
			return map;
		} catch (MedicineNotFoundException e) {
			throw new MedicineNotFoundException("Error while fetching" + e.getMessage());
		}
	}

	public Map<String, PharmacyAdministrationVO> fetchByMedicineName(String medicine_name)
			throws MedicineNotFoundException {
		try {
			Map<String, PharmacyAdministrationVO> map = new HashMap<String, PharmacyAdministrationVO>();
			map = dao3.fetchByMedicineName(medicine_name);
			return map;
		} catch (MedicineNotFoundException e) {
			throw new MedicineNotFoundException("Error while fetching" + e.getMessage());
		}

	}

	public boolean updateMedicine(PharmacyAdministrationVO vo) throws MedicineManagementException {
		try {
			boolean flag;
			flag = dao3.updateMedicineDetails(vo);
			return flag;
		} catch (MedicineManagementException e) {
			throw new MedicineManagementException("Error while updating medicine details" + e.getMessage());
		}
	}
	// Pharmacy_AdministrationBO ending

	// Room_ManagementBO starting

	public boolean addRoom(RoomManagementVO vo) throws RoomManagementException {
		try {
			boolean flag;
			flag = dao4.addRoomDetails(vo);
			return flag;
		} catch (RoomManagementException e) {
			throw new RoomManagementException("Error while adding room details" + e.getMessage());
		}
	}

	public RoomManagementVO fetchRoomByRoomNumber(int room_number) throws RoomNotFoundException {
		try {
			RoomManagementVO vo = new RoomManagementVO();
			vo = dao4.fetchRoomByRoomNumber(room_number);
			return vo;
		} catch (RoomNotFoundException e) {
			throw new RoomNotFoundException("Error while fetching" + e.getMessage());
		}
	}

	public boolean updateRoom(RoomManagementVO vo) throws RoomManagementException {
		try {
			boolean flag;
			flag = dao4.updateRoomDetails(vo);
			return flag;
		} catch (RoomManagementException e) {
			throw new RoomManagementException("Error while updating room details" + e.getMessage());
		}
	}
	// Room_managementBO ending

}
