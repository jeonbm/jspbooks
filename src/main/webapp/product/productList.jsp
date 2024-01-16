<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품목록</h2>
	<table>
		<td>번호</td><td>상품명</td><td>가격</td><br>
		<c:forEach var="p" varStatus="i" items="${products}">
			<tr>
				<td>${i.count}</td>
				<td><a href="/jspbooks/pcontrol?action=info&id=${p.id}">${p.name}</a></td>
				<td>${p.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>