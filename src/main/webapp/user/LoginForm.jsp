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
	<c:import url="../templateHeader.html"/>
	<div class="container">
		<div id="bodyBackground">
				<div class="row justify-content-center">
					<div class="col-md-6" id="content">
						<br>
						<!-- Hello: ${user}  -->
						<form action="/HFProject/userLoginCheck.do" method="post">
							<label for="fi" class="form-label">아이디</label>
							<input type="text" class="form-control" id="fi" name="formId" required/><br>
							<label for="pw" class="form-label">비밀번호</label>
							<input type="password" class="form-control" id="pw" name="formPw" required/><br>
							<div class="d-flex">
								<div class="p-1">
									<input class="btn btn-primary" type="submit" value="로그인" />
								</div>
								<div class="p-1 ms-auto">
									<a class="btn btn-warning" href="/HFProject/userJoinForm.do">회원가입하기</a>
								</div>
							</div>
							
						</form>
						
					</div>
				</div>
		</div>
	<footer>
	<c:import url="../templateFooter.html"/>
	</footer>
	</div>
</body>
</html>