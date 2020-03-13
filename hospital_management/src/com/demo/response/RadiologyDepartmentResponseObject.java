package com.demo.response;

import java.util.Map;

import com.demo.vo.RadiologyDepartmentVO;

public class RadiologyDepartmentResponseObject {
	String successMessage;
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
	
	public Map<Integer, RadiologyDepartmentVO> getRadiologyDepartmentMap() {
		return RadiologyDepartmentMap;
	}
	public void setRadiologyDepartmentMap(Map<Integer, RadiologyDepartmentVO> radiologyDepartmentMap) {
		RadiologyDepartmentMap = radiologyDepartmentMap;
	}
	public RadiologyDepartmentVO getRadiology_departmentVO() {
		return Radiology_departmentVO;
	}
	public void setRadiology_departmentVO(RadiologyDepartmentVO radiology_departmentVO) {
		Radiology_departmentVO = radiology_departmentVO;
	}
	String failureMessage;
	Map<Integer, RadiologyDepartmentVO> RadiologyDepartmentMap;
	RadiologyDepartmentVO Radiology_departmentVO;
}
