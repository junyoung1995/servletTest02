package com.json.command;

import javax.servlet.http.HttpServletRequest;

public interface JsonCommand {
	void execute(HttpServletRequest request);
}
