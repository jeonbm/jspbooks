<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="calc" class="ch07.Calculator"/>
    <jsp:setProperty name="calc" property="*"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>useBean계산기</h2>
	<hr>
	<h2>계산결과 : <%=calc.calc() %></h2>
</body>
</html>