package com.demo.response;

import java.sql.Date;
import java.util.Map;

import com.demo.vo.DoctorTimingsVO;

public class DoctorTimingsResponseObject {
	String successMessage;
	String failureMessage;

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	public Map<Date, DoctorTimingsVO> getDoctorTimingsMap1() {
		return doctorTimingsMap1;
	}

	public void setDoctorTimingsMap1(Map<Date, DoctorTimingsVO> doctorTimingsMap1) {
		this.doctorTimingsMap1 = doctorTimingsMap1;
	}

	public Map<Integer, DoctorTimingsVO> getDoctorTimingsMap2() {
		return doctorTimingsMap2;
	}

	public void setDoctorTimingsMap2(Map<Integer, DoctorTimingsVO> doctorTimingsMap2) {
		this.doctorTimingsMap2 = doctorTimingsMap2;
	}

	public DoctorTimingsVO getDoctorTimingsVO() {
		return doctorTimingsVO;
	}

	public void setDoctorTimingsVO(DoctorTimingsVO doctorTimingsVO) {
		this.doctorTimingsVO = doctorTimingsVO;
	}

	Map<Date, DoctorTimingsVO> doctorTimingsMap1;
	Map<Integer, DoctorTimingsVO> doctorTimingsMap2;
	DoctorTimingsVO doctorTimingsVO;

}
