<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.s_id eq null}">
<c:if test="${sessionScope.s_isAdmin eq 1 }">
<c:redirect url="/userLogin.do"/>
</c:if>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>회원번호</th>
				<th>유저아이디</th>
				<th>유저비번</th>
				<th>유저이름</th>
				<th>이메일</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="userList" items="${userList}">
			<tr>
						<td>${userList.userNum}</td>
						<td>${userList.userId}</td>
						<td>${userList.userPw}</td>
						<td>${userList.userName}</td>
						<td>${userList.userEmail}</td>
						<td>${userList.uage}</td>
					</tr>
					</c:forEach>
		</tbody>
	</table>
	<c:if test = "${buttons.startPage ne 1}">
	 <a href = "http://localhost:8181/HFprj/AllUser.do?pageNum=${buttons.startPage - 1 }">[prev]</a>
	</c:if>
	<c:forEach var = "pageNum" begin="${buttons.getStartPage() }" end="${buttons.getEndPage() }">
	<a href = "http://localhost:8181/HFprj/AllUser.do?pageNum=${pageNum }">[${pageNum }]</a> 
	</c:forEach>
	<c:if test = "${buttons.endPage ne buttons.totalPages}">
	 <a href = "http://localhost:8181/HFprj/AllUser.do?pageNum=${buttons.endPage + 1 }">[next]</a>
	</c:if>
</body>
</html>
