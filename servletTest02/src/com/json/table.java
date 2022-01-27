package com.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
 * Servlet implementation class table
 */
@WebServlet("*.do")
public class table extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//commit test
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public table() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet이다.");
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost이다.");
		doAction(request, response);
		
		String reqUrl = request.getRequestURI();
		String ctxPath = request.getContextPath() + "/jsonTest/";
		response.setContentType("text/html; charset=utf-8");
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jsondata";
			conn = DriverManager.getConnection(url, "root", "0000");
			String query = "create table JsonData.testJson\r\n" + 
					"(\r\n" + 
					"	EventID	VARCHAR(30) Not Null primary key,\r\n" + 
					"	EventType VARCHAR(30) not null,\r\n" + 
					"	CamID smallint not null,\r\n" + 
					"	PlaneID VARCHAR(20) not null,\r\n" + 
					"	PeriodEnd int not null,\r\n" + 
					"	PeriodStart int not null,\r\n" + 
					"	Amount smallint not null,\r\n" + 
					"	Reg_DT DateTime not null\r\n" + 
					")";
			pstmt = conn.prepareStatement(query);
		    int n = pstmt.executeUpdate();
		    System.out.println(n);
		    response.setContentType("text/html; charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.println("<head></head>");
			pw.println("<body>");
			if(n == -1) {
				pw.println("테이블 생성에 성공하였습니다.<br/>");
			}
			else {
				pw.println("테이블 생성에 실패하였습니다.<br/>");
			}
			pw.println("</body>");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("patchTable");
		response.setContentType("text/html; charset=utf-8");
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jsondata";
			conn = DriverManager.getConnection(url, "root", "0000");
			String query = "Alter table testJson add jbColumn int after Reg_DT";
			pstmt = conn.prepareStatement(query);
		    int n = pstmt.executeUpdate();
		    System.out.println(n);
		    response.setContentType("text/html; charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.println("<head></head>");
			pw.println("<body>");
			if(n == 1) {
				pw.println("테이블 수정에 성공하였습니다.<br/>");
			}
			else {
				pw.println("테이블 수정에 실패하였습니다.<br/>");
			}
			pw.println("</body>");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("deleteTable");
		response.setContentType("text/html; charset=utf-8");
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jsondata";
			conn = DriverManager.getConnection(url, "root", "0000");
			String query = "Drop table testJson";
			pstmt = conn.prepareStatement(query);
		    int n = pstmt.executeUpdate();
		    System.out.println(n);
		    response.setContentType("text/html; charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.println("<head></head>");
			pw.println("<body>");
			if(n == -1) {
				pw.println("테이블 삭제에 성공하였습니다.<br/>");
			}
			else {
				pw.println("테이블 삭제에 실패하였습니다.<br/>");
			}
			pw.println("</body>");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	private void doAction(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("doAction으로 넘어왔다.");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
		
		String viewPage = null;
		String searchUri = request.getRequestURI(); //찾아가는 url
		String contextPath = request.getContextPath();
		String command = searchUri.substring(contextPath.length());
	}
}
