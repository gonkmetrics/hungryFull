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
<title>잘 들어가나 안 들어가나 확인용 </title>
</head>
<body>
${user}
	<h1>${user.userName}님 환영합니다.</h1><br/>
	<a href="userLogout.do">로그아웃</a>
	<a href="userDelete.do">회원탈퇴</a>
	<form action = "userUpdateForm.do" method = "post">
	<input type="text" name="s_id" value="${s_id}"/>
	<input type ="submit" value = "정보수정" />
	</form>
	<a href="AllUser.do">회원목록</a>
</body>
</html>