package com.demo.response;

import java.util.Map;

import com.demo.vo.PatientMedicineVO;

public class PatientMedicineResponseObject {
	String successMessage;
	String failureMessage;
	Map<Integer,PatientMedicineVO> patientMedicineVO;
	PatientMedicineVO patientMedicineVo;
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
	public Map<Integer, PatientMedicineVO> getPatientMedicineVO() {
		return patientMedicineVO;
	}
	public void setPatientMedicineVO(Map<Integer, PatientMedicineVO> patientMedicineVO) {
		this.patientMedicineVO = patientMedicineVO;
	}
	public PatientMedicineVO getPatientMedicineVo() {
		return patientMedicineVo;
	}
	public void setPatientMedicineVo(PatientMedicineVO patientMedicineVo) {
		this.patientMedicineVo = patientMedicineVo;
	}

}
