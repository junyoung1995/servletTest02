package com.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/Database/Row")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.getParameter("jsonData");
		System.out.println(request.getParameter("jsonData"));
		String EventID = (String)request.getAttribute("event_id");
		System.out.println(EventID);
		String EventType = (String)request.getAttribute("event_type");
		System.out.println(EventType);
		int CamID = (int)request.getAttribute("cam_id");
		System.out.println(CamID);
		String PlaneID = (String)request.getAttribute("plane_id");
		System.out.println(PlaneID);
		int PeriodEnd = (int)request.getAttribute("period_end");
		System.out.println(PeriodEnd);
		int PeriodStart = (int)request.getAttribute("period_start");
		System.out.println(PeriodStart);
		int Amount = (int)request.getAttribute("amount");
		System.out.println(Amount);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jsondata";
			conn = DriverManager.getConnection(url, "root", "0000");
			String query = "insert into test values(?,?,?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, EventID);
			pstmt.setString(2, EventType);
			pstmt.setInt(3, CamID);
			pstmt.setString(4, PlaneID);
			pstmt.setInt(5, PeriodEnd);
			pstmt.setInt(6, PeriodStart);
			pstmt.setInt(7, Amount);
			n = pstmt.executeUpdate();
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		//결과 응답하기
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head></head>");
		pw.println("<body>");
		if(n>0) {
			pw.println("데이터 입력에 성공하였습니다.<br/>");
		}
		else {
			pw.println("데이터 입력에 실패하였습니다.<br/>");
		}
		pw.println("</body>");
	}

}
