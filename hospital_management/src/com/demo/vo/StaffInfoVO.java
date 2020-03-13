package com.demo.vo;

public class StaffInfoVO {
	private int staff_id;
	private String Staff_name; 
	private String Designation;
	@Override
	public String toString() {
		return "StaffInfoVO [staff_id=" + staff_id + ", Staff_name=" + Staff_name + ", Designation=" + Designation
				+ ", Doctor_id=" + Doctor_id + ", Staff_salary=" + Staff_salary + ", getStaff_id()=" + getStaff_id()
				+ ", getStaff_name()=" + getStaff_name() + ", getDesignation()=" + getDesignation()
				+ ", getDoctor_id()=" + getDoctor_id() + ", getStaff_salary()=" + getStaff_salary() + "]";
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return Staff_name;
	}
	public void setStaff_name(String staff_name) {
		Staff_name = staff_name;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public int getDoctor_id() {
		return Doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		Doctor_id = doctor_id;
	}
	public float getStaff_salary() {
		return Staff_salary;
	}
	public void setStaff_salary(float staff_salary) {
		Staff_salary = staff_salary;
	}
	private int Doctor_id;
	private float Staff_salary;
}