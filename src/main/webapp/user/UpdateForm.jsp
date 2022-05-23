<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.s_id eq null}">
<c:redirect url="/userLogin.do"/>
</c:if>
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
		<div id="bodyBackground">
			<div class="row justify-content-center">
				<div class="col-md-8 pt-3" id="contentPrimary">
				<br>
					<form action="/HFProject/userUpdate.do" method="post">
					<input type ="hidden" name="userNum">
					<label for="id" class="form-label">아이디</label>
					<input class="form-control" id="id" type="text" name="s_id" value ="${user.userId }"readonly/><br/>
					<label for="pw" class="form-label">비밀번호</label>
					<input class="form-control" id="pw" type="password" name="user_pw" value="${user.userPw }"/><br/>
					<label for="nm" class="form-label">이름</label>
					<input class="form-control" id="nm" type="text" name="user_name" value="${user.userName }" readonly/><br/>
					<label for="em" class="form-label">이메일</label>	
					<input class="form-control" id="em" type="text" name="user_email" value="${user.userEmail }"/><br/>
	        		<label for="ag" class="form-label">나이</label>
					<input class="form-control" id="ag" type="text" name="user_age" value="${user.uage }"/><br/>	
	       	 	    <input type ="hidden" name="isAdmin"><br>
					<input class="btn btn-primary" type="submit" value="수정하기">
					</form>
				</div>
			</div>
		
		</div>
	</div>	
	<c:import url="../templateFooter.html"/>
</body>
</html>


