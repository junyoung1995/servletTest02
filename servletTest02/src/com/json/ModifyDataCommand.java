package com.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyDataCommand implements JsonCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String EventID = request.getParameter("EventID");
		String EventType = request.getParameter("EventType");
		String CamID = request.getParameter("CamID");
		String PlaneID = request.getParameter("PlaneID");
		String PeriodEnd = request.getParameter("PeriodEnd");
		String PeriodStart = request.getParameter("PeriodStart");
		String Amount = request.getParameter("Amount");
		
		JsonDao jsonDao = new JsonDao();
		jsonDao.modifyJson(EventID, EventType, CamID, PlaneID, PeriodEnd, PeriodStart, Amount);
	}

}
