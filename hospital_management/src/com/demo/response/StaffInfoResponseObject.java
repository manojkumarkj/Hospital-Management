package com.demo.response;

import java.util.List;
import java.util.Map;

import com.demo.vo.StaffInfoVO;

public class StaffInfoResponseObject {
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
	
	public Map<String, StaffInfoVO> getStaffInfoMap() {
		return staffInfoMap;
	}
	public void setStaffInfoMap(Map<String, StaffInfoVO> staffInfoMap) {
		this.staffInfoMap = staffInfoMap;
	}
	public StaffInfoVO getStaffInfoVO() {
		return staffInfoVO;
	}
	public void setStaffInfoVO(StaffInfoVO staffInfoVO) {
		this.staffInfoVO = staffInfoVO;
	}
	String failureMessage;
	Map<String, StaffInfoVO> staffInfoMap;
	StaffInfoVO staffInfoVO;

}
