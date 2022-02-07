package com.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertDataCommand implements JsonCommand {

	@Override
	public void execute(HttpServletRequest request  ) {
		// TODO Auto-generated method stub
		String EventID = request.getParameter("EventID");
		String EventType = request.getParameter("EventType");
		String CamID = request.getParameter("CamID");
		String PlaneID = request.getParameter("PlaneID");
		String PeriodEnd = request.getParameter("PeriodEnd");
		String PeriodStart = request.getParameter("PeriodStart");
		String Amount = request.getParameter("Amount");
		String Reg_DT = request.getParameter("Reg_DT");
		
		JsonDao jsonDao = new JsonDao();
		jsonDao.insertJson(EventID, EventType, CamID, PlaneID, PeriodEnd, PeriodStart, Amount, Reg_DT);
	}
}
