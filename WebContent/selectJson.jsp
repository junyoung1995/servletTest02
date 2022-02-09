<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>데이터 조회</title>
</head>
<body>
	<h1>list</h1>
	<hr>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
	    <tr>    
	        <th>EventID</th>
	        <th>EventType</th>
	        <th>CamID</th>
	        <th>PlaneID</th>
	        <th>PeriodEnd</th>
	        <th>PeriodStart</th>
	        <th>Amount</th>
	        <th>Reg_DT</th>
	    </tr>
	    <c:forEach items="${ jsonSelect }" var="jsonDto" >
	    <tr>
	        <td>${ jsonDto.eventID }</td>
	        <td>${ jsonDto.eventType }</td>
	        <td>${ jsonDto.camID }</td>
	        <td>${ jsonDto.planeID }</td>
	        <td>${ jsonDto.periodEnd }</td>
	        <td>${ jsonDto.periodStart }</td>
	        <td>${ jsonDto.amount }</td>
	        <td>${ jsonDto.reg_DT }</td>
	    </tr>
	    </c:forEach>
	    <tr>
	        <td colspan="5"><a href="/servletTest02/table.html">버튼 다시 누르기</a></td>
	    </tr>
	</table>
</body>
</html>