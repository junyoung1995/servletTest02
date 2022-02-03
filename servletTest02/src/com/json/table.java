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
		System.out.println("doGet�씠�떎.");
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost�씠�떎.");
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
					"	CamID int not null,\r\n" + 
					"	PlaneID VARCHAR(20) not null,\r\n" + 
					"	PeriodEnd int not null,\r\n" + 
					"	PeriodStart int not null,\r\n" + 
					"	Amount int not null,\r\n" + 
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
				pw.println("�뀒�씠釉� �깮�꽦�뿉 �꽦怨듯븯���뒿�땲�떎.<br/>");
			}
			else {
				pw.println("�뀒�씠釉� �깮�꽦�뿉 �떎�뙣�븯���뒿�땲�떎.<br/>");
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
				pw.println("�뀒�씠釉� �닔�젙�뿉 �꽦怨듯븯���뒿�땲�떎.<br/>");
			}
			else {
				pw.println("�뀒�씠釉� �닔�젙�뿉 �떎�뙣�븯���뒿�땲�떎.<br/>");
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
				pw.println("�뀒�씠釉� �궘�젣�뿉 �꽦怨듯븯���뒿�땲�떎.<br/>");
			}
			else {
				pw.println("�뀒�씠釉� �궘�젣�뿉 �떎�뙣�븯���뒿�땲�떎.<br/>");
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
		System.out.println("doAction�쑝濡� �꽆�뼱�솕�떎.");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		}
		
		String viewPage = null;
		// �뼱�뼡 View �럹�씠吏�濡� 蹂댁뿬以꾩�瑜� �떞�뒗 蹂��닔
        // �쎒�뿉�꽌 �뼱�뼡 濡쒖쭅�쓣 �닔�뻾�븷吏�瑜� 寃곗젙�빐二쇰뒗 Command媛앹껜 -> �쑀吏�蹂댁닔 諛� 愿�由щ�� �쐞�븳 遺꾩궛 泥섎━
        // �룞�씪�븳 BCommand �씪�뒗 �씤�꽣�럹�씠�뒪瑜� �씠�슜�븯�뿬 �룞�씪�븳 硫붿냼�뱶瑜� �넻�빐 媛곸옄 �븣留욎� 濡쒖쭅�쓣 �닔�뻾�븯寃� 留뚮뱾湲곗쐞�븳 媛앹껜.
		JsonCommand command = null;
		
		String searchUri = request.getRequestURI(); //李얠븘媛��뒗 url
		String contextPath = request.getContextPath();
		String commandName = searchUri.substring(contextPath.length());
		
		   if(commandName.equals("/insertJson.do")) {
	            command = new InsertDataCommand();
	            command.execute(request, response);
	            viewPage = "insertJson.do";
	        }else if(commandName.equals("/selectJson.do")) {
	            command = new SelectDataCommand();
	            command.execute(request, response);
	            viewPage = "selectJson.do";
	        }else if(commandName.equals("/modifyJson.do")) {
	            command = new ModifyDataCommand();
	            command.execute(request, response);
	            viewPage = "modifyJson.do";
	        }else if(commandName.equals("/deleteJson.do")) {
	            command = new DeleteDataCommand();
	            command.execute(request, response);
	            viewPage = "deleteJson.do";
	        }else if(commandName.equals("/createTable.do")) {
	            command = new CreateTableCommand();
	            command.execute(request, response);
	            viewPage = "reply_view.jsp";
	        }else if(commandName.equals("/deleteTable.do")) {
	            command = new DeleteTableCommand();
	            command.execute(request, response);
	            viewPage = "list.do";
	        }else if(commandName.equals("/alterTable.do")) {
	            command = new AlterTableCommand();
	            command.execute(request, response);
	            viewPage = "list.do";
	        }else {
	            System.out.println("아무것도 안들어옴");
	            viewPage = "notCommand.jsp";
	        }
	        
	        // RequestDispatcher 媛앹껜�뿉�떎媛� �뼱�뼡 View �럹�씠吏�濡� 蹂대궪吏� 留듯븨�븷 怨녹쓣 �떞�뒗�떎.
	        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	        // �빐�떦 �럹�씠吏�濡� �룷�썙�뵫�빐以��떎. --> *.do濡� 諛쏆쑝硫� �떎�떆 BFrontController濡� 媛��꽌 濡쒖쭅 �닔�뻾.
	        // .jsp 濡� 諛쏆쑝硫� �빐�떦 View濡� �솕硫댁쓣 蹂댁뿬以��떎.
	        dispatcher.forward(request, response);

	}
}
