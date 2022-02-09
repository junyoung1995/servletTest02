package com.json.jsonparse;

import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.json.dto.JsonDto;

public class JsonParse {

	public static JsonDto execute(HttpServletRequest request) {
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
		
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		System.out.println(String.format("period=%s", period.get("end")));
		
		
		long temp = (long) period.get("end");
		int PeriodEndTemp = 2147483647;
	
		String EventID = (String) jsonObj.get("id");
		String EventType = (String) jsonObj.get("type");
		String CamID = (String) metadata.get("cam_id");
		String PlaneID = (String) plan.get("id");
		long PeriodEnd = (long) period.get("end");
		long PeriodStart = (long) period.get("start");
		long Amount = (long) arrData.get("amount");
		Timestamp Reg_DT = currentTime; 
		
		JsonDto jsonDto = new JsonDto(EventID, EventType, CamID, PlaneID, PeriodEnd, PeriodStart, Amount, Reg_DT);
		return jsonDto;

	}
}
