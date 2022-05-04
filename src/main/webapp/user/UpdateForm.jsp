<%@page import="kr.co.hf.domain.UserVO"%>
<%@page import="kr.co.hf.domain.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String userId = request.getParameter("userId");

	
	UserDAO dao = UserDAO.getInstance();
	UserVO user = dao.getUserInfo(userId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1><%= userId %> 님의 정보를 수정합니다.</h1>
	<form action="UpdateCheck.jsp" method="post">
		<input type ="hidden" name="userNum">
		<input type="hidden" name="fId" value="<%= user.getUserId() %>"><br/>
		비밀번호 : <input type="password" name="fPw"/><br/>
		이름 : <input type="text" name="fName" value="<%= user.getUserName()%>"/><br/>
		이메일 : <input type="text" name="fEmail" value="<%=user.getUserEmail()%>"/><br/>
		나이 : <input type="text" name="fuage" value="<%=user.getUage()%>"/>
		<input type ="hidden" name="isAdmin"><br/>
		<input type="submit" value="수정하기">
	</form>
	
</body>
</html>
