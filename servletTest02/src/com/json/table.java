package com.json;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("jsonTest/Database/*")
public class table extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement preparedStatement;
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
		System.out.println("doGet입니다.");
		String viewPage = null;
		JsonCommand command = null;
        String contextPath = request.getContextPath();
        String testURI = request.getRequestURI();
        System.out.println(testURI);
		if(testURI.equals("/servletTest02/jsonTest/Database/Row")) {
        	System.out.println("데이터 조회");
            command = new SelectDataCommand();
            command.execute(request);
            viewPage = "selectJson.jsp";
        }else {
            System.out.println("아무것도 안들어옴");
            viewPage = "notCommand.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(String.format("Method : %s / URL : %s / URL2 : %s", request.getMethod(), request.getContextPath(), request.getRequestURI()));
		
		System.out.println(request.getMethod());
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		JsonCommand command = null;
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
		//String commandName = viewPage.substring(contextPath.length());
        String testURI = request.getRequestURI();
        System.out.println(testURI);
		
		if(testURI.equals("/servletTest02/jsonTest/Database/Table")) {
        	System.out.println("테이블 삭제");
        	try {
    			Class.forName("org.mariadb.jdbc.Driver");
    			String url = "jdbc:mariadb://127.0.0.1:3306/jsondata";
    			connection = DriverManager.getConnection(url, "root", "0000");
    			String query = "Drop table testJson";
    			preparedStatement = connection.prepareStatement(query);
    		    int resultDropTable = preparedStatement.executeUpdate();
    		    System.out.println(resultDropTable);
    		    response.setContentType("text/html; charset=utf-8");
    			PrintWriter pw = response.getWriter();
    			pw.println("<html>");
    			pw.println("<head></head>");
    			pw.println("<body>");
    			if(resultDropTable == 0) {
    				pw.println("테이블이 삭제되었습니다.<br/>");
    			}
    			else {
    				pw.println("테이블이 삭제되지 않았습니다.<br/>");
    			}
    			pw.println("</body>");
    		}catch(ClassNotFoundException e) {
    			System.out.println(e.getMessage());
    		}
    		catch(SQLException e) {
    			System.out.println(e.getMessage());
    		}
        }else if(testURI.equals("/servletTest02/jsonTest/Database/Row")) {
        	System.out.println("데이터 삭제");
            command = new DeleteDataCommand();
            command.execute(request);
            viewPage = "selectJson.do";
        }else {
            System.out.println("아무것도 안들어옴");
            viewPage = "notCommand.jsp";
        }
        //RequestDispatcher 객체에 어떤 View 페이지로 보낼 지 맵핑하는 곳이다.
	   //해당 페이지로 포워딩 해준다.
		/*
		 * RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		 * dispatcher.forward(request, response);
		 */
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost이다.");
        System.out.println(String.format("Method : %s / URL : %s / URL2 : %s", request.getMethod(), request.getContextPath(), request.getRequestURI()));
        System.out.println(request.getMethod());
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		JsonCommand command = null;
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        String testURI = request.getRequestURI();
        System.out.println(testURI);
        if(testURI.equals("/servletTest02/jsonTest/Database/Table")) {
        	System.out.println("테이블 생성");
        	try {
    			Class.forName("org.mariadb.jdbc.Driver");
    			String url = "jdbc:mariadb://127.0.0.1:3306/jsondata";
    			connection = DriverManager.getConnection(url, "root", "0000");
    			String query = "create table JsonData.testJson\r\n" + 
    					"(\r\n" + 
    					"	EventID	VARCHAR(30) Not Null primary key,\r\n" + 
    					"	EventType VARCHAR(30) not null,\r\n" + 
    					"	CamID int not null,\r\n" + 
    					"	PlaneID VARCHAR(20) not null,\r\n" + 
    					"	PeriodEnd int not null,\r\n" + 
    					"	PeriodStart int not null,\r\n" + 
    					"	Amount int not null,\r\n" + 
    					"	Reg_DT DateTime not null\r\n" + 
    					")";
    			preparedStatement = connection.prepareStatement(query);
    		    int resultCreateTable = preparedStatement.executeUpdate();
    		    System.out.println(resultCreateTable);
    		    response.setContentType("text/html; charset=utf-8");
    			PrintWriter pw = response.getWriter();
    			pw.println("<html>");
    			pw.println("<head></head>");
    			pw.println("<body>");
    			if(resultCreateTable == 0) {
    				pw.println("테이블이 생성되었습니다.<br/>");
    			}
    			else {
    				pw.println("테이블이 생성되지 않았습니다.<br/>");
    			}
    			pw.println("</body>");
    		}catch(ClassNotFoundException e) {
    			System.out.println(e.getMessage());
    		}catch(SQLException e) {
    			System.out.println(e.getMessage());
    		}
        }else if(testURI.equals("/servletTest02/jsonTest/Database/Row")) {
        	System.out.println("데이터 삽입");
            command = new InsertDataCommand();
            command.execute(request);
            viewPage = "selectJson.do";
        }else {
            System.out.println("아무것도 안들어옴");
            viewPage = "notCommand.jsp";
        }
		/*
		 * RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		 * dispatcher.forward(request, response);
		 */
    }
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("doPut입니다.");
		System.out.println(String.format("Method : %s / URL : %s / URL2 : %s", request.getMethod(), request.getContextPath(), request.getRequestURI()));
        System.out.println(request.getMethod());
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		JsonCommand command = null;
        String contextPath = request.getContextPath();
        String testURI = request.getRequestURI();
        System.out.println(testURI);
		
		if(testURI.equals("/servletTest02/jsonTest/Database/Table")) {
        	System.out.println("테이블 수정");
        	try {
    			Class.forName("org.mariadb.jdbc.Driver");
    			String url = "jdbc:mariadb://127.0.0.1:3306/jsondata";
    			connection = DriverManager.getConnection(url, "root", "0000");
    			String query = "Alter table testJson add jbColumn int after Reg_DT";
    			preparedStatement = connection.prepareStatement(query);
    		    int resultAlterTable = preparedStatement.executeUpdate();
    		    System.out.println(resultAlterTable);
    		    response.setContentType("text/html; charset=utf-8");
    			PrintWriter pw = response.getWriter();
    			pw.println("<html>");
    			pw.println("<head></head>");
    			pw.println("<body>");
    			if(resultAlterTable == 1) {
    				pw.println("테이블이 수정되었습니다.<br/>");
    			}
    			else {
    				pw.println("테이블이 수정되지 않았습니다.<br/>");
    			}
    			pw.println("</body>");
    		}catch(ClassNotFoundException e) {
    			System.out.println(e.getMessage());
    		}
    		catch(SQLException e) {
    			System.out.println(e.getMessage());
    		}
        }else if(testURI.equals("/servletTest02/jsonTest/Database/Row")) {
        	System.out.println("데이터 수정");
            command = new ModifyDataCommand();
            command.execute(request);
            viewPage = "selectJson.do";
        }else {
            System.out.println("아무것도 안들어옴");
            viewPage = "notCommand.jsp";
        }
        //RequestDispatcher 객체에 어떤 View 페이지로 보낼 지 맵핑하는 곳이다.
	   //해당 페이지로 포워딩 해준다.
		/*
		 * RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		 * dispatcher.forward(request, response);
		 */
	}
	
	/*
	 * protected void doAction(HttpServletRequest request, HttpServletResponse
	 * response) throws IOException, ServletException {
	 * System.out.println("doAction입니다."); System.out.println(request.getMethod());
	 * request.setCharacterEncoding("UTF-8"); System.out.println("여긴 어디?"); String
	 * viewPage = null; System.out.println("여긴 어디??"); JsonCommand command = null;
	 * System.out.println("여긴 어디???");
	 * 
	 * //String requestUri = request.getRequestURI();
	 * //System.out.println("여긴 어디????"); String contextPath =
	 * request.getContextPath(); System.out.println("여긴 어디?????"); String
	 * commandName = viewPage.substring(contextPath.length());
	 * System.out.println("여긴 어디??????");
	 * 
	 * if(commandName.equals("/jsonTest/Database/Row")) {
	 * System.out.println("데이터 삽입"); command = new InsertDataCommand();
	 * command.execute(request); viewPage = "selectJson.do"; }else
	 * if(commandName.equals("/jsonTest/Database/Row")) {
	 * System.out.println("데이터 조회"); command = new SelectDataCommand();
	 * command.execute(request); viewPage = "selectJson.jsp"; }else
	 * if(commandName.equals("/jsonTest/Database/Row")) {
	 * System.out.println("데이터 수정"); command = new ModifyDataCommand();
	 * command.execute(request); viewPage = "selectJson.do"; }else
	 * if(commandName.equals("/jsonTest/Database/Row")) {
	 * System.out.println("데이터 삭제"); command = new DeleteDataCommand();
	 * command.execute(request); viewPage = "selectJson.do"; }else
	 * if(commandName.equals("/jsonTest/Database/Table")) {
	 * System.out.println("테이블 생성"); try { Class.forName("org.mariadb.jdbc.Driver");
	 * String url = "jdbc:mariadb://127.0.0.1:3306/jsondata"; connection =
	 * DriverManager.getConnection(url, "root", "0000"); String query =
	 * "create table JsonData.testJson\r\n" + "(\r\n" +
	 * "	EventID	VARCHAR(30) Not Null primary key,\r\n" +
	 * "	EventType VARCHAR(30) not null,\r\n" + "	CamID int not null,\r\n" +
	 * "	PlaneID VARCHAR(20) not null,\r\n" + "	PeriodEnd int not null,\r\n" +
	 * "	PeriodStart int not null,\r\n" + "	Amount int not null,\r\n" +
	 * "	Reg_DT DateTime not null\r\n" + ")"; preparedStatement =
	 * connection.prepareStatement(query); int resultCreateTable =
	 * preparedStatement.executeUpdate(); System.out.println(resultCreateTable);
	 * response.setContentType("text/html; charset=utf-8"); PrintWriter pw =
	 * response.getWriter(); pw.println("<html>"); pw.println("<head></head>");
	 * pw.println("<body>"); if(resultCreateTable == 0) {
	 * pw.println("테이블이 생성되었습니다.<br/>"); } else {
	 * pw.println("테이블이 생성되지 않았습니다.<br/>"); } pw.println("</body>");
	 * }catch(ClassNotFoundException e) { System.out.println(e.getMessage());
	 * }catch(SQLException e) { System.out.println(e.getMessage()); } }else
	 * if(commandName.equals("/jsonTest/Database/Table")) {
	 * System.out.println("테이블 삭제"); try { Class.forName("org.mariadb.jdbc.Driver");
	 * String url = "jdbc:mariadb://127.0.0.1:3306/jsondata"; connection =
	 * DriverManager.getConnection(url, "root", "0000"); String query =
	 * "Drop table testJson"; preparedStatement =
	 * connection.prepareStatement(query); int resultDropTable =
	 * preparedStatement.executeUpdate(); System.out.println(resultDropTable);
	 * response.setContentType("text/html; charset=utf-8"); PrintWriter pw =
	 * response.getWriter(); pw.println("<html>"); pw.println("<head></head>");
	 * pw.println("<body>"); if(resultDropTable == -1) {
	 * pw.println("테이블이 삭제되었습니다.<br/>"); } else {
	 * pw.println("테이블이 삭제되지 않았습니다.<br/>"); } pw.println("</body>");
	 * }catch(ClassNotFoundException e) { System.out.println(e.getMessage()); }
	 * catch(SQLException e) { System.out.println(e.getMessage()); } }else
	 * if(commandName.equals("/jsonTest/Database/Table")) {
	 * System.out.println("테이블 수정"); try { Class.forName("org.mariadb.jdbc.Driver");
	 * String url = "jdbc:mariadb://127.0.0.1:3306/jsondata"; connection =
	 * DriverManager.getConnection(url, "root", "0000"); String query =
	 * "Alter table testJson add jbColumn int after Reg_DT"; preparedStatement =
	 * connection.prepareStatement(query); int resultAlterTable =
	 * preparedStatement.executeUpdate(); System.out.println(resultAlterTable);
	 * response.setContentType("text/html; charset=utf-8"); PrintWriter pw =
	 * response.getWriter(); pw.println("<html>"); pw.println("<head></head>");
	 * pw.println("<body>"); if(resultAlterTable == 1) {
	 * pw.println("테이블이 수정되었습니다.<br/>"); } else {
	 * pw.println("테이블이 수정되지 않았습니다.<br/>"); } pw.println("</body>");
	 * }catch(ClassNotFoundException e) { System.out.println(e.getMessage()); }
	 * catch(SQLException e) { System.out.println(e.getMessage()); } }else {
	 * System.out.println("아무것도 안들어옴"); viewPage = "notCommand.jsp"; }
	 * //RequestDispatcher 객체에 어떤 View 페이지로 보낼 지 맵핑하는 곳이다. //해당 페이지로 포워딩 해준다.
	 * RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	 * dispatcher.forward(request, response); }
	 */
}
