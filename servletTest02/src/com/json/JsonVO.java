package com.json;

import java.sql.Timestamp;

public class JsonVO {
	private String EventID;
	private String EventType;
	private int CamID;
	private String PlaneID;
	private int PeriodEnd;
	private int PeriodStart;
	private int Amount;
	private Timestamp Reg_DT;
	
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
