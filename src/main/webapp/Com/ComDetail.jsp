<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<c:import url="../templateHead.html"/>
</head>
<body>
<h1>${com.commentID }번 댓글 조회중입니다.</h1><br>
내용 : <textarea cols="30" rows="10"></textarea><br>
작성자 : <input type="text" value=""><br>
<hr>
<a href="http://localhost:8181/HFProject/ComList"><button>목록</button></a>
<!-- 삭제번호를 서블릿 ComDelete로 보내야함 -->
<form action="http://localhost:8181/HFProject/ComDelete" method="post">
  <!-- 삭제용 글 번호는 노출시킬 필요가 없으므로 hidden타입으로 숨겨서 보냄 -->
  <input type="hidden" name="commentID" value="${com.commentID}">
  <input type="submit" value="삭제" ><br>
</form>
<form action="http://localhost:8181/HFProject/ComUpdateForm" method="post">
   <input type="hidden" name="commentID" value="${com.commentID }">
   <input type="submit" value="수정">
</form>

</body>
</html>