package com.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteDataCommand implements JsonCommand {

	@Override
	public void execute(HttpServletRequest request  ) {
		// TODO Auto-generated method stub
		JsonDao jsonDao = new JsonDao();
		jsonDao.deleteJson(request.getParameter("EventID"));
	}

}
