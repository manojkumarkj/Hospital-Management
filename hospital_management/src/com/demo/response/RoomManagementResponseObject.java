package com.demo.response;

import java.util.List;

import com.demo.vo.RoomManagementVO;

public class RoomManagementResponseObject {
	String successMessage;
	String failureMessage;
	List<RoomManagementVO> roomManagementList;
	RoomManagementVO roomManagementVO;

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

	public List<RoomManagementVO> getRoomManagementList() {
		return roomManagementList;
	}

	public void setRoomManagementList(List<RoomManagementVO> roomManagementList) {
		this.roomManagementList = roomManagementList;
	}

	public RoomManagementVO getRoomManagementVO() {
		return roomManagementVO;
	}

	public void setRoomManagementVO(RoomManagementVO roomManagementVO) {
		this.roomManagementVO = roomManagementVO;
	}

}