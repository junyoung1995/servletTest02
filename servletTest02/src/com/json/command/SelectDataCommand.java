package com.json.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.dao.JsonDao;
import com.json.dto.JsonDto;

public class SelectDataCommand implements JsonCommand {

	@Override
	public void execute(HttpServletRequest request  ) {
		// TODO Auto-generated method stub
		JsonDao jsonDao = new JsonDao();
		ArrayList<JsonDto> jsonDto = jsonDao.jsonSelect();
		request.setAttribute("jsonSelect", jsonDto);
	}

}
