<%@page import="kr.co.hf.domain.UserVO"%>
<%@page import="kr.co.hf.domain.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.s_id eq null}">
<c:redirect url="/userLogin.do"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/HFprj/userUpdate.do" method="post">
		<input type ="hidden" name="userNum">
		아이디 : <input type="text" name="s_id" value ="${user.userId }"readonly /><br/>
		비밀번호 : <input type="password" name="user_pw" value="${user.userPw }"/><br/>
		이름 : <input type="text" name="user_name" value="${user.userName }" readonly/><br/>
		이메일 : <input type="text" name="user_email" value="${user.userEmail }"/><br/>
		나이 : <input type="text" name="user_age" value="${user.uage }"/>
		<input type ="hidden" name="isAdmin"><br/>
		<input type="submit" value="수정하기">
	</form>
	
</body>
</html>
