package com.json.dto;

import java.sql.Timestamp;

public class JsonDto {
	//json데이터
	private String EventID;
	private String EventType;
	private int CamID;
	private String PlaneID;
	private int PeriodEnd;
	private int PeriodStart;
	private int Amount;
	private Timestamp Reg_DT;
	
	public JsonDto() {	}
	
	public JsonDto(String EventID, String EventType, int CamID,
			String PlaneID, int PeriodEnd, int PeriodStart, 
			int Amount, Timestamp Reg_DT) {
		this.EventID = EventID;
		this.EventType = EventType;
		this.CamID = CamID;
		this.PlaneID = PlaneID;
		this.PeriodEnd = PeriodEnd;
		this.PeriodStart = PeriodStart;
		this.Amount = Amount;
		this.Reg_DT = Reg_DT;
	}
	
	public String getEventID() {
		return EventID;
	}
	public void setEventID(String eventID) {
		EventID = eventID;
	}
	public String getEventType() {
		return EventType;
	}
	public void setEventType(String eventType) {
		EventType = eventType;
	}
	public int getCamID() {
		return CamID;
	}
	public void setCamID(int camID) {
		CamID = camID;
	}
	public String getPlaneID() {
		return PlaneID;
	}
	public void setPlaneID(String planeID) {
		PlaneID = planeID;
	}
	public int getPeriodEnd() {
		return PeriodEnd;
	}
	public void setPeriodEnd(int periodEnd) {
		PeriodEnd = periodEnd;
	}
	public int getPeriodStart() {
		return PeriodStart;
	}
	public void setPeriodStart(int periodStart) {
		PeriodStart = periodStart;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public Timestamp getReg_DT() {
		return Reg_DT;
	}
	public void setReg_DT(Timestamp reg_DT) {
		Reg_DT = reg_DT;
	}
}
