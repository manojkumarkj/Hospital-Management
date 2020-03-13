package com.demo.vo;

public class RadiologyDepartmentVO {
	private int scan_id;
	public int getScan_id() {
		return scan_id;
	}
	public void setScan_id(int scan_id) {
		this.scan_id = scan_id;
	}
	public String getScan_details() {
		return scan_details;
	}
	public void setScan_details(String scan_details) {
		this.scan_details = scan_details;
	}
	public float getScan_charges() {
		return scan_charges;
	}
	public void setScan_charges(float scan_charges) {
		this.scan_charges = scan_charges;
	}
	private String scan_details;
	private float scan_charges;
	@Override
	public String toString() {
		return "radiology_departmentVO [scan_id=" + scan_id + ", scan_details=" + scan_details + ", scan_charges="
				+ scan_charges + ", getScan_id()=" + getScan_id() + ", getScan_details()=" + getScan_details()
				+ ", getScan_charges()=" + getScan_charges() + "]";
	}
	

}
