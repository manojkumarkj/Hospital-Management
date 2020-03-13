package com.demo.vo;

public class PharmacyAdministrationVO {
	private int medicine_id;
	private String medicine_name;

	@Override
	public String toString() {
		return "Pharmacy_AdministrationVO [medicine_id=" + medicine_id + ", medicine_name=" + medicine_name
				+ ", medicine_mrp=" + medicine_mrp + ", stock_purchased=" + stock_purchased + ", stock_sold="
				+ stock_sold + ", stock_left=" + stock_left + ", getMedicine_id()=" + getMedicine_id()
				+ ", getMedicine_name()=" + getMedicine_name() + ", getMedicine_mrp()=" + getMedicine_mrp()
				+ ", getStock_purchased()=" + getStock_purchased() + ", getStock_sold()=" + getStock_sold()
				+ ", getStock_left()=" + getStock_left() + "]";
	}

	private float medicine_mrp;
	private int stock_purchased;
	private int stock_sold;
	private int stock_left;

	public int getMedicine_id() {
		return medicine_id;
	}

	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}

	public String getMedicine_name() {
		return medicine_name;
	}

	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}

	public float getMedicine_mrp() {
		return medicine_mrp;
	}

	public void setMedicine_mrp(float medicine_mrp) {
		this.medicine_mrp = medicine_mrp;
	}

	public int getStock_purchased() {
		return stock_purchased;
	}

	public void setStock_purchased(int stock_purchased) {
		this.stock_purchased = stock_purchased;
	}

	public int getStock_sold() {
		return stock_sold;
	}

	public void setStock_sold(int stock_sold) {
		this.stock_sold = stock_sold;
	}

	public int getStock_left() {
		return stock_left;
	}

	public void setStock_left(int stock_left) {
		this.stock_left = stock_left;
	}

}
