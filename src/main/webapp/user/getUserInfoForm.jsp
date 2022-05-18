<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../templateHeader.html"/>
	<form action="getUserInfo.jsp" method="post">
		조회할 아이디 : <input type="text" name="userId"><br/>
		<input type="submit" value="조회하기">
	</form>
	<c:import url="../templateFooter.html"/>
</body>
</html>