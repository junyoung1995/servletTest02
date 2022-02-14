package com.json.command;

import javax.servlet.http.HttpServletRequest;

import com.json.dao.JsonDao;

public class ModifyDataCommand implements JsonCommand {

	@Override
	public void execute(HttpServletRequest request  ) {
		String EventID = request.getParameter("EventID");
		System.out.println(String.format("EventID값 = %s", EventID));
		JsonDao jsonDao = new JsonDao();
		jsonDao.modifyJson(EventID);
	}

}
