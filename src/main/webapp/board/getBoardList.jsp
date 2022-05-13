<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class = "table table-primary">
	<thead>
		<tr>
			<th>postID</th>
			<th>postAuthor</th>
			<th>postTitle</th>
			<th>postContent</th>
			<th>postTime</th>
			<th>postLastModified</th>
			<th>viewCount</th>
			<th>postType</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.postID}</td>
				<td>${board.postAuthor}</td>
				<td><a href="/HFprj/recipeDetail.do?postID=${board.postID}"/>${board.postTitle}</td>
				<td>${board.postContent}</td>
				<td>${board.postTime}</td>
				<td>${board.postLastModified}</td>
				<td>${board.viewCount}</td>
				<td>${board.postType}</td>
			</tr>
		</c:forEach>
		</tbody>
</table>
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		  	<c:if test="${buttons.startPage ne 1}">
				<li class="page-item"><a class="page-link" href="/HFprj/boardList.do?pageNum=${buttons.startPage - 1}">Previous</a></li>
			</c:if>
			<c:forEach var="pageNum" begin="${buttons.startPage }" end="${buttons.endPage }">
				<li class="page-item ${buttons.currentPage eq pageNum ? 'active' : ''}"><a class="page-link" href="/HFprj/boardList.do?pageNum=${pageNum}">${pageNum}</a></li>
			</c:forEach>
			<c:if test="${buttons.endPage ne buttons.totalPages}">
		    	<li class="page-item"><a class="page-link" href="/HFprj/boardList.do?pageNum=${buttons.endPage + 1}">Next</a></li>
		    </c:if>
		  </ul>
		</nav>

<a href="/HFprj/boardInsertForm.do">글쓰기</a>
</body>
</html>