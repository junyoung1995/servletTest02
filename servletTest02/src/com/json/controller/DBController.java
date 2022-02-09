package com.json.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.command.AlterTableCommand;
import com.json.command.CreateTableCommand;
import com.json.command.DeleteDataCommand;
import com.json.command.DropTableCommand;
import com.json.command.InsertDataCommand;
import com.json.command.JsonCommand;
import com.json.command.ModifyDataCommand;
import com.json.command.SelectDataCommand;

/**
 * Servlet implementation class table
 */
@WebServlet("jsonTest/Database/*")
public class DBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//commit test
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBController() {
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
        String URI = request.getRequestURI();
        
        System.out.println(URI);
        
		if(URI.equals("/servletTest02/jsonTest/Database/Row")) {
        	System.out.println("데이터 조회");
            
        	command = new SelectDataCommand();
            command.execute(request);
            request.setAttribute("seleteJson", command);
            viewPage = "selectJson.jsp";
            ServletContext jsonJsp = this.getServletContext();
            RequestDispatcher dispatcher = jsonJsp.getRequestDispatcher("/selectJson.jsp");
            try {
            	dispatcher.forward(request, response);
            }catch(ServletException selectE) {
            	System.out.println(String.format("오류 메세지 = %s", selectE.getMessage()));
            }
            
        }else {
            System.out.println("아무것도 안들어옴");
            
            viewPage = "notCommand.jsp";
            
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		JsonCommand command = null;
        String contextPath = request.getContextPath();
        
        System.out.println(contextPath);
        
        String URI = request.getRequestURI();
        
        System.out.println(URI);
		
		if(URI.equals("/servletTest02/jsonTest/Database/Table")) {
        	System.out.println("테이블 삭제");
        	
        	command = new DropTableCommand();
        	command.execute(request);
        	PrintWriter result = response.getWriter();
        	result.print("테이블 삭제 완료");
        	result.close();
        }else if(URI.equals("/servletTest02/jsonTest/Database/Row")) {
        	System.out.println("데이터 삭제");
            command = new DeleteDataCommand();
            command.execute(request);
            PrintWriter result = response.getWriter();
        	result.print("데이터 삭제 완료");
        	result.close();
        }else {
            System.out.println("아무것도 안들어옴");
            viewPage = "notCommand.jsp";
        }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost이다.");
        request.setCharacterEncoding("UTF-8");
		JsonCommand command = null;
        String contextPath = request.getContextPath();
        String viewPage = null;
        System.out.println(contextPath);
        
        String URI = request.getRequestURI();
        System.out.println(URI);
        
        if(URI.equals("/servletTest02/jsonTest/Database/Table")) {
        	System.out.println("테이블 생성 uri");
        	
        	command = new CreateTableCommand();
        	command.execute(request);
        	PrintWriter result = response.getWriter();
        	result.print("테이블 생성 완료");
        	result.close();
        }else if(URI.equals("/servletTest02/jsonTest/Database/Row")) {
        	System.out.println("데이터 삽입 uri");
            command = new InsertDataCommand();
            command.execute(request);
            PrintWriter result = response.getWriter();
        	result.print("데이터 생성 완료");
        	result.close();
        }else {
            System.out.println("아무것도 안들어옴");
            viewPage = "notCommand.jsp";
        }
    }
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		JsonCommand command = null;
        String URI = request.getRequestURI();
        System.out.println(URI);
		
		if(URI.equals("/servletTest02/jsonTest/Database/Table")) {
        	System.out.println("테이블 수정");
        	
        	command = new AlterTableCommand();
        	command.execute(request);
        	PrintWriter result = response.getWriter();
        	result.print("테이블 수정 완료");
        	result.close();
        }else if(URI.equals("/servletTest02/jsonTest/Database/Row")) {
        	System.out.println("데이터 수정");
            command = new ModifyDataCommand();
            command.execute(request);
            PrintWriter result = response.getWriter();
        	result.print("데이터 수정 완료");
        	result.close();
        }else {
            System.out.println("아무것도 안들어옴");
            viewPage = "notCommand.jsp";
        }
	}
}
