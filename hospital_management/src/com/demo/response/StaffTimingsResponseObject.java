package com.demo.response;

import java.util.Map;

import com.demo.vo.StaffTimingsVO;

public class StaffTimingsResponseObject {
	
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
	
	public Map<String, StaffTimingsVO> getStaffTimingsMap() {
		return StaffTimingsMap;
	}
	public void setStaffTimingsMap(Map<String, StaffTimingsVO> staffTimingsMap) {
		this.StaffTimingsMap= staffTimingsMap;
	}
	public StaffTimingsVO getStaffInfoVO() {
		return staffInfoVO;
	}
	public void setStaffInfoVO(StaffTimingsVO staffInfoVO) {
		this.staffInfoVO = staffInfoVO;
	}
	String failureMessage;
	Map<String,StaffTimingsVO> StaffTimingsMap;
	StaffTimingsVO staffInfoVO;
	public void StaffTimingsInfoMap(Map<String, StaffTimingsVO> map) {
		// TODO Auto-generated method stub
		
	}
	
		// TODO Auto-generated method stub
		
	}


