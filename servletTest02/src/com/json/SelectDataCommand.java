package com.json;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.JsonDao;
import com.json.JsonDto;

public class SelectDataCommand implements JsonCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		JsonDao jsonDao = new JsonDao();
		ArrayList<JsonDto> jsonDto = jsonDao.jsonSelect();
		request.setAttribute("jsonSelect", jsonDto);
	}

}
