package com.demo.vo;

import java.sql.Date;

public class DoctorTimingsVO {
	@Override
	public String toString() {
		return "Doctor_TimingsVO [time_id=" + time_id + ", date=" + date + ", time_in=" + time_in + ", time_out="
				+ time_out + ", doctor_id=" + doctor_id + ", getTime_id()=" + getTime_id() + ", getDate()=" + getDate()
				+ ", getTime_in()=" + getTime_in() + ", getTime_out()=" + getTime_out() + ", getDoctor_id()="
				+ getDoctor_id() + "]";
	}

	private int time_id;
	private Date date;
	private String time_in;
	private String time_out;
	private int doctor_id;

	public int getTime_id() {
		return time_id;
	}

	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime_in() {
		return time_in;
	}

	public void setTime_in(String time_in) {
		this.time_in = time_in;
	}

	public String getTime_out() {
		return time_out;
	}

	public void setTime_out(String time_out) {
		this.time_out = time_out;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

}
