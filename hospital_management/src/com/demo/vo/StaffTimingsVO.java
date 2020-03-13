package com.demo.vo;

import java.sql.Date;

public class StaffTimingsVO {
	private int Time_id;
	public int getTime_id() {
		return Time_id;
	}
	public void setTime_id(int time_id) {
		Time_id = time_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime_in() {
		return Time_in;
	}
	public void setTime_in(String time_in) {
		Time_in = time_in;
	}
	public String getTime_out() {
		return Time_out;
	}
	public void setTime_out(String time_out) {
		Time_out = time_out;
	}
	public int getStaff_id() {
		return Staff_id;
	}
	public void setStaff_id(int staff_id) {
		Staff_id = staff_id;
	}
	private Date  date;
	private String Time_in ;
	private String Time_out;
	private int Staff_id;
	@Override
	public String toString() {
		return "Staff_timingsVO [Time_id=" + Time_id + ", date=" + date + ", Time_in=" + Time_in + ", Time_out="
				+ Time_out + ", Staff_id=" + Staff_id + ", getTime_id()=" + getTime_id() + ", getDate()=" + getDate()
				+ ", getTime_in()=" + getTime_in() + ", getTime_out()=" + getTime_out() + ", getStaff_id()="
				+ getStaff_id() + "]";
	}
	
	
	

}
