<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String sId = (String)session.getAttribute("s_id");
	
	if(sId == null){
		response.sendRedirect("LoginForm.jsp");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>잘 들어가나 안 들어가나 확인용 </title>
</head>
<body>

	<a href="userLogout.do">로그아웃</a>
	<a href="Delete.jsp">회원탈퇴</a>
	<a href="userUpdateForm.do">정보수정</a>
</body>
</html>