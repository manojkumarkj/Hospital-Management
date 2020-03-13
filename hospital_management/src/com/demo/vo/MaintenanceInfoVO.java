package com.demo.vo;

public class MaintenanceInfoVO {
	private int  maintenance_id;
	public int getMaintenance_id() {
		return maintenance_id;
	}
	public void setMaintenance_id(int maintenance_id) {
		this.maintenance_id = maintenance_id;
	}
	public String getMaintenance_details() {
		return maintenance_details;
	}
	public void setMaintenance_details(String maintenance_details) {
		this.maintenance_details = maintenance_details;
	}
	public Float getMaintenance_amount() {
		return maintenance_amount;
	}
	public void setMaintenance_amount(Float maintenance_amount) {
		this.maintenance_amount = maintenance_amount;
	}
	@Override
	public String toString() {
		return "maintenance_infoVO [maintenance_id=" + maintenance_id + ", maintenance_details=" + maintenance_details
				+ ", maintenance_amount=" + maintenance_amount + ", getMaintenance_id()=" + getMaintenance_id()
				+ ", getMaintenance_details()=" + getMaintenance_details() + ", getMaintenance_amount()="
				+ getMaintenance_amount() + "]";
	}
	private String maintenance_details ;
	private Float maintenance_amount;
	

}
