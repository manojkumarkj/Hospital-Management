package com.demo.response;

import java.util.List;
import java.util.Map;

import com.demo.vo.DoctorInfoVO;

public class DoctorInfoResponseObject {
	String successMessage;

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getFailureMessage() {
		return FailureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		FailureMessage = failureMessage;
	}
	public Map<Integer, DoctorInfoVO> getDoctorInfoMap() {
		return doctorInfoMap;
	}

	public void setDoctorInfoMap(Map<Integer, DoctorInfoVO> doctorInfoMap) {
		this.doctorInfoMap = doctorInfoMap;
	}

	public DoctorInfoVO getDoctorInfoVO() {
		return doctorInfoVO;
	}

	public void setDoctorInfoVO(DoctorInfoVO doctorInfoVO) {
		this.doctorInfoVO = doctorInfoVO;
	}

	String FailureMessage;
	Map<Integer, DoctorInfoVO> doctorInfoMap;
	DoctorInfoVO doctorInfoVO;
	List<DoctorInfoVO> doctorInfoList;

	public List<DoctorInfoVO> getDoctorInfoList() {
		return doctorInfoList;
	}

	public void setDoctorInfoList(List<DoctorInfoVO> doctorInfoList) {
		this.doctorInfoList = doctorInfoList;
	}

}
