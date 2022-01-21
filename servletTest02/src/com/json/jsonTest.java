package com.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class jsonTest
 */
@WebServlet("/jsonTest/customerInvoiceData")
public class jsonTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jsonTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getContextPath();
		System.out.println(request.getMethod());
		String jsonStr = request.getParameter("jsonParameter");
		System.out.println(jsonStr);
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = null;
		try {
			jsonObj = (JSONObject)parser.parse(jsonStr);
			System.out.println(jsonObj);
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
		//{camid, cloud plan, customer, period_end, period_start, description} 찾기

		JSONObject data = (JSONObject)jsonObj.get("data");
		JSONObject object = (JSONObject)data.get("object");
		JSONObject lines = (JSONObject)object.get("lines");
		JSONArray linesData = (JSONArray)lines.get("data");
		JSONObject arrData = (JSONObject)linesData.get(0); //잘못됨
		/*
		 * for(int i = 0; i < linesData.size(); i++) { JSONObject tmp =
		 * (JSONObject)linesData.get(i); }
		 */
		//JSONObject arrData = (JSONObject)tmp;
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

		System.out.println(jsonOutput);
		request.setAttribute("EventID", jsonObj.get("id"));
		request.setAttribute("EventType", jsonObj.get("type"));
		request.setAttribute("CamID", metadata.get("cam_id"));
		request.setAttribute("PlaneID", plan.get("id"));
		request.setAttribute("PeriodEnd", period.get("end"));
		request.setAttribute("PeriodStart", period.get("start"));
		request.setAttribute("Amount", arrData.get("amount"));

		/*
		 * String jsonResult = jsonOutput.toJSONString();
		 * response.setContentType("text/html"); response.setCharacterEncoding("utf-8");
		 * request.setAttribute("jsonResult", jsonResult);
		 */
		request.setAttribute("jsonData", jsonOutput);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/dataDB.jsp");
		dispatcher.forward(request, response);
	}
}
