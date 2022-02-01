package com.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
		// 어떤 View 페이지로 보여줄지를 담는 변수
        // 웹에서 어떤 로직을 수행할지를 결정해주는 Command객체 -> 유지보수 및 관리를 위한 분산 처리
        // 동일한 BCommand 라는 인터페이스를 이용하여 동일한 메소드를 통해 각자 알맞은 로직을 수행하게 만들기위한 객체.
		JsonCommand command = null;
		
		String searchUri = request.getRequestURI(); //찾아가는 url
		String contextPath = request.getContextPath();
		String commandName = searchUri.substring(contextPath.length());
		
		  if(commandName.equals("/insert_view.do")) {
	            viewPage = "insert_view.jsp";
	        }else if(commandName.equals("/insertData.do")) {
	            command = new InsertDataCommand();
	            command.execute(request, response);
	            viewPage = "selectData.do";
	        }else if(commandName.equals("/selectData.do")) {
	            command = new SelectDataCommand();
	            command.execute(request, response);
	            viewPage = "select.jsp";
	        }else if(commandName.equals("/modify_view.do")) {
	            command = new BContentCommand();
	            command.execute(request, response);
	            viewPage = "content_view.jsp";
	        }else if(commandName.equals("/modify.do")) {
	            command = new BModifyCommand();
	            command.execute(request, response);
	            viewPage = "select.do";
	        }else if(commandName.equals("/delete.do")) {
	            command = new DeleteDataCommand();
	            command.execute(request, response);
	            viewPage = "select.do";
	        }else if(commandName.equals("/reply_view.do")) {
	            command = new BReplyViewCommand();
	            command.execute(request, response);
	            viewPage = "reply_view.jsp";
	        }else if(commandName.equals("/reply.do")) {
	            command = new BReplyCommand();
	            command.execute(request, response);
	            viewPage = "list.do";
	        }else {
	            System.out.println("해당 Command 로직이 없습니다.");
	            viewPage = "notCommand.jsp";
	        }
	        
	        // RequestDispatcher 객체에다가 어떤 View 페이지로 보낼지 맵핑할 곳을 담는다.
	        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	        // 해당 페이지로 포워딩해준다. --> *.do로 받으면 다시 BFrontController로 가서 로직 수행.
	        // .jsp 로 받으면 해당 View로 화면을 보여준다.
	        dispatcher.forward(request, response);

	}
}
