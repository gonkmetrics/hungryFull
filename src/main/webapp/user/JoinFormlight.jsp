<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<c:import url="../templateHead.html"/>
</head>
<body>
	<c:import url="../templateHeader.jsp"/>
	<div id="backgroundPrimary">
		<!-- only displays background. do not modify -gonk -->
    </div>
	<div class="container">
		<div>
			<div class="row justify-content-center">
				<div class="col-md-8" id="contentPrimary">
					<form action="userJoinCheck.do" method="post">
					<input type ="hidden" name="userNum">
					<label for="id" class="form-label">아이디</label>
					<input class="form-control" id="id" type="text" name="userId"/><br/>
					<label for="pw" class="form-label">비밀번호</label>
					<input class="form-control" id="pw" type="password" name="userPw"/><br/>
					<label for="nm" class="form-label">이름</label>
					<input class="form-control" id="nm" type="text" name="userName"/><br/>
					<label for="em" class="form-label">이메일</label>	
					<input class="form-control" id="em" type="text" name="userEmail"/><br/>
	        		<label for="ag" class="form-label">나이</label>
					<input class="form-control" id="ag" type="text" name="uage"/><br/>	
	       	 	    <input type ="hidden" name="isAdmin"><br>
					<input class="btn btn-primary" type="submit" value="가입하기">
					</form>
				</div>
			</div>
		</div>
	</div>
	<c:import url="../templateFooter.html"/>
</body>
</html>


	

