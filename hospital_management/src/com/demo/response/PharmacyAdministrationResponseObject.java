package com.demo.response;

import java.util.Map;

import com.demo.vo.PharmacyAdministrationVO;

public class PharmacyAdministrationResponseObject {
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

	public Map<String, PharmacyAdministrationVO> getPharmacyAdministrationMap1() {
		return pharmacyAdministrationMap1;
	}

	public void setPharmacyAdministrationMap1(Map<String, PharmacyAdministrationVO> pharmacyAdministrationMap1) {
		this.pharmacyAdministrationMap1 = pharmacyAdministrationMap1;
	}

	public Map<Integer, PharmacyAdministrationVO> getPharmacyAdministrationMap2() {
		return pharmacyAdministrationMap2;
	}

	public void setPharmacyAdministrationMap2(Map<Integer, PharmacyAdministrationVO> pharmacyAdministrationMap2) {
		this.pharmacyAdministrationMap2 = pharmacyAdministrationMap2;
	}

	String failureMessage;
	Map<String, PharmacyAdministrationVO> pharmacyAdministrationMap1;
	Map<Integer, PharmacyAdministrationVO> pharmacyAdministrationMap2;
}
