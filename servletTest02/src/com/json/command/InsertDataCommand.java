package com.json.command;

import javax.servlet.http.HttpServletRequest;
import com.json.dao.JsonDao;
import com.json.dto.JsonDto;
import com.json.jsonparse.JsonParse;

public class InsertDataCommand implements JsonCommand {

	@Override
	public void execute(HttpServletRequest request ) {
		// get JsonString from reqeust
		JsonParse jsonParse = new JsonParse();
		// call Function(JsonString);
		// return DTO
		JsonDto jsonDto = jsonParse.execute(request);
		
		// throw DTO to insertJson();
		JsonDao jsonDao = new JsonDao();
		jsonDao.insertJson(jsonDto);
	}

}