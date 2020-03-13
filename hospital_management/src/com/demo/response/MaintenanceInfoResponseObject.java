package com.demo.response;

import java.util.Map;

import com.demo.vo.MaintenanceInfoVO;

public class MaintenanceInfoResponseObject {
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
	public Map<String, MaintenanceInfoVO> getMaintenanceIinfomap() {
		return MaintenanceIinfomap;
	}
	public void setMaintenanceIinfomap(Map<String, MaintenanceInfoVO> maintenanceIinfomap) {
		MaintenanceIinfomap = maintenanceIinfomap;
	}
	public MaintenanceInfoVO getMaintenanceInfoVO() {
		return maintenanceInfoVO;
	}
	public void setMaintenanceInfoVO(MaintenanceInfoVO maintenanceInfoVO) {
		this.maintenanceInfoVO = maintenanceInfoVO;
	}
	String failureMessage;
	Map<String, MaintenanceInfoVO> MaintenanceIinfomap;
	MaintenanceInfoVO maintenanceInfoVO;
	
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		
	}
	
		// TODO Auto-generated method stub
		
	
	
		// TODO Auto-generated method stub
		
	


