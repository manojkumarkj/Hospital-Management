package com.demo.vo;

public class PatientMedicineVO {
	private int patient_medicine_id;
	private int bill_id;
	private int medicine_id;
	public int getPatient_medicine_id() {
		return patient_medicine_id;
	}
	public void setPatient_medicine_id(int patient_medicine_id) {
		this.patient_medicine_id = patient_medicine_id;
	}
	public int getBill_id() {
		return bill_id;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public int getMedicine_id() {
		return medicine_id;
	}
	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}
	@Override
	public String toString() {
		return "PatientMedicineVO [patient_medicine_id=" + patient_medicine_id + ", bill_id=" + bill_id
				+ ", medicine_id=" + medicine_id + ", getPatient_medicine_id()=" + getPatient_medicine_id()
				+ ", getBill_id()=" + getBill_id() + ", getMedicine_id()=" + getMedicine_id() + "]";
	}

}
