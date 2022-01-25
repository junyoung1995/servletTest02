<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data Page</title>
</head>
<body>
	<form action="Database/Row" method="POST">
		${jsonData }
		<button type="submit">data 입력</button>
	</form>
	<form action="Database/Row" method="DELETE">
		<button type="submit">data 삭제</button>
	</form>
	<form action="Database/Row" method="PATCH">
		<button type="submit">data 수정</button>
	</form>
	<form action="Database/Row" method="GET">
		<button type="submit">data 조회</button>
	</form>
</body>
</html>