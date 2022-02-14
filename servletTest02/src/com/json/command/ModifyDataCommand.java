package com.json.command;

import javax.servlet.http.HttpServletRequest;

import com.json.dao.JsonDao;

public class ModifyDataCommand implements JsonCommand {

	@Override
	public void execute(HttpServletRequest request  ) {
		String EventID = request.getParameter("EventID");
		System.out.println(String.format("EventID값 = %s", EventID));
		String EventType = request.getParameter("EventType");
		String CamID = request.getParameter("CamID");
		String PlandID = request.getParameter("PlaneID");
		String PeriodEnd = request.getParameter("PeriodEnd");
		String PeriodStart = request.getParameter("PeriodStart");
		String Amount = request.getParameter("Amount");
		String Reg_DT = request.getParameter("Reg_DT");
		JsonDao jsonDao = new JsonDao();
		jsonDao.modifyJson(EventID, EventType, PlandID, CamID, PeriodEnd, PeriodStart, Amount, Reg_DT);
	}

}
