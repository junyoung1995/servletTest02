package com.json.dto;

import java.sql.Timestamp;

public class JsonDto {
	//json데이터
	private String EventID;
	private String EventType;
	private String CamID;
	private String PlaneID;
	private long PeriodEnd;
	private long PeriodStart;
	private long Amount;
	private Timestamp Reg_DT;
	
	public JsonDto() {	}
	
	public JsonDto(String EventID, String EventType, String CamID,
			String PlaneID, long PeriodEnd, long PeriodStart, 
			long Amount, Timestamp Reg_DT) {
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
	public String getCamID() {
		return CamID;
	}
	public void setCamID(String camID) {
		CamID = camID;
	}
	public String getPlaneID() {
		return PlaneID;
	}
	public void setPlaneID(String planeID) {
		PlaneID = planeID;
	}
	public long getPeriodEnd() {
		return PeriodEnd;
	}
	public void setPeriodEnd(long periodEnd) {
		PeriodEnd = periodEnd;
	}
	public long getPeriodStart() {
		return PeriodStart;
	}
	public void setPeriodStart(int periodStart) {
		PeriodStart = periodStart;
	}
	public long getAmount() {
		return Amount;
	}
	public void setAmount(long amount) {
		Amount = amount;
	}
	public Timestamp getReg_DT() {
		return Reg_DT;
	}
	public void setReg_DT(Timestamp reg_DT) {
		Reg_DT = reg_DT;
	}
}
