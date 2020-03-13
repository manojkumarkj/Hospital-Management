package com.demo.vo;

public class DoctorInfoVO {
	private int doctor_id;
	private String doctor_name;
	private String specialist;

	@Override
	public String toString() {
		return "DoctorInfoVO [doctor_id=" + doctor_id + ", doctor_name=" + doctor_name + ", specialist=" + specialist
				+ ", doctor_salary=" + doctor_salary + ", getDoctor_id()=" + getDoctor_id() + ", getDoctor_name()="
				+ getDoctor_name() + ", getSpecialist()=" + getSpecialist() + ", getDoctor_salary()="
				+ getDoctor_salary() + "]";
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

	public float getDoctor_salary() {
		return doctor_salary;
	}

	public void setDoctor_salary(float doctor_salary) {
		this.doctor_salary = doctor_salary;
	}

	private float doctor_salary;
}
