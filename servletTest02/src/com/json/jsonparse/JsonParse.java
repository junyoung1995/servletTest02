package com.json.jsonparse;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.json.command.JsonCommand;
import com.json.dao.JsonDao;

public class JsonParse implements JsonCommand {

	@Override
	public void execute(HttpServletRequest request) {
		System.out.println("jsonData 파싱 uri");
    	
		String jsonStr = request.getParameter("jsonParameter");
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = null;
		
		try {
			jsonObj = (JSONObject)parser.parse(jsonStr);
			System.out.println(jsonObj);
			
		}catch(ParseException e) {
			System.out.println(e.getMessage() + ", " + jsonStr);
		}
		
		JSONObject data = (JSONObject)jsonObj.get("data");
		JSONObject object = (JSONObject)data.get("object");
		JSONObject lines = (JSONObject)object.get("lines");
		JSONArray linesData = (JSONArray)lines.get("data");
		JSONObject arrData = (JSONObject)linesData.get(0);
		
		JSONObject plan = (JSONObject)arrData.get("plan");
		JSONObject metadata = (JSONObject)arrData.get("metadata");
		JSONObject period = (JSONObject)arrData.get("period");
		JSONObject jsonOutput = new JSONObject();
		
		jsonOutput.put("event_id", jsonObj.get("id"));
		jsonOutput.put("cam_id", metadata.get("cam_id"));
		jsonOutput.put("plane_id", plan.get("id"));
		jsonOutput.put("amount", arrData.get("amount"));
		jsonOutput.put("period_start", period.get("start"));
		jsonOutput.put("period_end", period.get("end"));
		jsonOutput.put("event_type", jsonObj.get("type"));
		
		request.setAttribute("EventID", jsonObj.get("id"));
		request.setAttribute("EventType", jsonObj.get("type"));
		request.setAttribute("CamID", metadata.get("cam_id"));
		request.setAttribute("PlaneID", plan.get("id"));
		request.setAttribute("PeriodEnd", period.get("end"));
		request.setAttribute("PeriodStart", period.get("start"));
		request.setAttribute("Amount", arrData.get("amount"));
		
		
	}
}
