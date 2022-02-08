package com.json.command;

import javax.servlet.http.HttpServletRequest;

import com.json.dao.JsonDao;

public class AlterTableCommand implements JsonCommand {

	@Override
	public void execute(HttpServletRequest request) {
		JsonDao jsonDao = new JsonDao();
		jsonDao.AlterTable();
	}
}
