package com.demo.vo;

public class RoomManagementVO {
	private int room_number;

	@Override
	public String toString() {
		return "Room_ManagementVO [room_number=" + room_number + ", suite_room=" + suite_room + ", room_charges="
				+ room_charges + ", getRoom_number()=" + getRoom_number() + ", getSuite_room()=" + getSuite_room()
				+ ", getRoom_charges()=" + getRoom_charges() + "]";
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}

	public String getSuite_room() {
		return suite_room;
	}

	public void setSuite_room(String suite_room) {
		this.suite_room = suite_room;
	}

	public float getRoom_charges() {
		return room_charges;
	}

	public void setRoom_charges(float room_charges) {
		this.room_charges = room_charges;
	}

	private String suite_room;
	private float room_charges;

}
