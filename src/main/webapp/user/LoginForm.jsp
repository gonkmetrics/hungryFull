<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="defaultPageHeightStyle.css">
</head>
<body>
	
	<div class="container">
	<c:import url="../templateHeader.html"/>
		<div id="bodyBackground">
				<div class="row justify-content-center">
					<div class="col-md-6" id="content">
						<br>
						${user}
						<form action="/HFProject/userLoginCheck.do" method="post">
							아이디 : <input type="text" name="formId" /><br/>
							비밀번호 : <input type="password" name="formPw" /><br/>
							<input type="submit" value="로그인" />
						</form>
						<a href="/HFProject/userJoinForm.do">회원가입하기.</a>
					</div>
				</div>
		</div>
	<footer>
	<c:import url="../templateFooter.html"/>
	</footer>
	</div>
	
</body>
</html>