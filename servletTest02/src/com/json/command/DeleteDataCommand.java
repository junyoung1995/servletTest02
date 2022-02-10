package com.json.command;

import javax.servlet.http.HttpServletRequest;

import com.json.dao.JsonDao;
import com.json.dto.JsonDto;

public class DeleteDataCommand implements JsonCommand {

	@Override
	public void execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		JsonDto jsonDto = new JsonDto();
		System.out.println(String.format("EventID = %s", jsonDto.getEventID()));
		JsonDao jsonDao = new JsonDao(); //마리아DB 연동 객체
		System.out.println(String.format("변수 값 = %s", request.getParameter("EventID")));
		jsonDao.deleteJson(request.getParameter("EventID"));
	}

}
