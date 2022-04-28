<%@page import="kr.co.HF.domain.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 로그인했는지 여부 확인(세션)
	String strsNum = (String)session.getAttribute("sNum");
	int sNum = 0;
	if(strsNum.equals("")) {
	} else {
	 sNum = Integer.parseInt(strsNum);
}
	// 로그인 안했다면 redirect로 로그인창으로 보내기
	if(sNum == 0){
		response.sendRedirect("LoginForm.jsp");
	}

	session.invalidate();
	UserDAO dao = UserDAO.getInstance();
	dao.Delete(sNum);
	response.sendRedirect("LoginForm.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
