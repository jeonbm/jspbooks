<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./hello.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- html 주석 -->
	<%-- JSP 주석 --%>
	<%!
		//선언과 참조
		String[] array = {"홍","김","동","전"};
		int num = 10;
		
		int calc(int _input){
			return _input + num;
		}
		
	%>
	<h3><%=calc(10)%></h3>
	<hr>

</body>
</html>