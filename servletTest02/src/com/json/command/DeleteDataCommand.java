package com.json.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.dao.JsonDao;

public class DeleteDataCommand implements JsonCommand {

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		JsonDao jsonDao = new JsonDao();
		System.out.println(String.format("변수 값 = %s", request.getParameterValues("EventID")));
		jsonDao.deleteJson(request.getParameter("EventID"));
	}

}
