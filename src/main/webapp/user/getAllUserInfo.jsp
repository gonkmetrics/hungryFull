<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.s_id eq null}">
	<c:if test="${sessionScope.s_isAdmin eq 1 }">
		<c:redirect url="/userLogin.do"/>
	</c:if>
</c:if>
<!DOCTYPE html>
<html>
<head>
	<c:import url="../templateHead.html"/>
</head>
<body>
	<c:import url="../templateHeader.jsp"/>
	<div class="row justify-content-center pt-3">
	<div class="col-md-10">
	
	
	<table class="table">
		<thead>
			<tr>
				<th>회원번호</th>
				<th>유저아이디</th>
				<th>유저비번</th>
				<th>유저이름</th>
				<th>이메일</th>
				<th>나이</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="userList" items="${userList}">
			<tr>
						<td>${userList.userNum}</td>
						<td>${userList.userId}</td>
						<td>${userList.userPw}</td>
						<td>${userList.userName}</td>
						<td>${userList.userEmail}</td>
						<td>${userList.uage}</td>
					</tr>
					</c:forEach>
		</tbody>
	</table>
	<div class="row justify-content-center">
	<nav aria-label="Paging">
	  <ul class="pagination">
	    <li class="page-item"><c:if test = "${buttons.startPage ne 1}">
	 	<a class="page-link" href = "http://localhost:8181/HFprj/AllUser.do?pageNum=${buttons.startPage - 1 }">Prev</a>
		</c:if></li>
	    <li class="page-item"><c:forEach var = "pageNum" begin="${buttons.getStartPage() }" end="${buttons.getEndPage() }">
		<a class="page-link" href = "http://localhost:8181/HFprj/AllUser.do?pageNum=${pageNum }">${pageNum }</a> 
		</c:forEach></li>
	    <li class="page-item"><c:if test = "${buttons.endPage ne buttons.totalPages}">
		 <a class="page-link" href = "http://localhost:8181/HFprj/AllUser.do?pageNum=${buttons.endPage + 1 }">Next</a>
		</c:if></li>
	  </ul>
	</nav>
	</div>
	</div>

	
		
	</div>
	<c:import url="../templateFooter.html"/>
	
</body>
</html>