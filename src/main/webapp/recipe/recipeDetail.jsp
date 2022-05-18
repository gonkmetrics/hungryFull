<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="ajaxLike.js"></script>  <!-- Note: when deploying, replace "development.js" with "production.min.js". -->
<script src="https://unpkg.com/react@18/umd/react.development.js" crossorigin></script>
<script src="https://unpkg.com/react-dom@18/umd/react-dom.development.js" crossorigin></script>
<link rel="stylesheet" href="recipePage.css">
</head>
<body>
제목 : ${board.postTitle}
<br/>
postID : <span id="postid">${board.postID}</span>
<br/>
타입 :
<c:choose>
	  <c:when test="${board.postType == 1}"><span class="badge bg-secondary">다이어트</span></c:when>
	  <c:when test="${board.postType == 2}"><span class="badge bg-secondary">간편식</span></c:when>
	  <c:when test="${board.postType == 3}"><span class="badge bg-secondary">이유식</span></c:when>
	  <c:when test="${board.postType == 4}"><span class="badge bg-secondary">건강식</span></c:when>
      <c:when test="${board.postType == 5}"><span class="badge bg-secondary">특별식</span></c:when>
</c:choose>
<br/>
내용 : ${board.postContent}
<br/>
postAuthor : <span id="usernum">${board.postAuthor}</span>
<br/>
userId :<span id = "userId">${user.userId}</span> 
<br/>
조회수 : ${board.viewCount}
<br/>
작성시간 : ${board.postTime}
<br/>
최근 수정 : ${board.postLastModified}
<br/>
<br/>imageLink : <img src="${board.imageLink}"/>
<hr>
<div class="mb-12">
		
		<br/>
		<label for="textarea1" class="form-label"> 본 문 </label>
		<textarea class="form-control" name="postContent" id="textarea1" cols="40" rows="20" readonly>${board.postContent}</textarea>
		<br/>
		<br/>
		<a href="/HFProject/boardList.do" class="btn btn-success btn-mb-3">목록으로</a>
	<div>
		<form action= "/HFProject/boardDelete.do" method="post">
			<input type="hidden" name="postID" value="${board.postID}">
			<input type="submit" class="btn btn-danger btn-mb-3" value="삭제하기">
		</form>
	</div>
	<div>
		<form action= "/HFProject/boardUpdateForm.do" method="post">
			<input type="hidden" name="postID" value="${board.postID}">
			<input type="submit" class="btn btn-primary btn-mb-3" value="수정하기">
		</form>
	</div>
	<div>
			<form action= "/HFProject/tamplateSample.do" method="post">
			<input type="submit" class="btn btn-primary btn-mb-3" value="홈으로">
		</form>
	</div>
</div>

<div>
	<div>

		<button type="button" class="btn btn-primary" id="toggleLike">like</button>
		<span id="message"></span>
		<hr>
	    <div class="heart-btn">
	      <div class="content">
	        <span class="heart"></span>
	        <span class="text">Like</span>
	        <span class="numb"></span>
	      </div>
	    </div>
	</div>
</div>

 <table class="table table-bordered table-hover table-dark">
         <thead>
             <tr>
                <td>댓글번호</td>
                <td>글쓴이</td>
                <td>내용</td>
             </tr>
         </thead>
          <tbody>
             <c:forEach var="com" items="${ComList}">
              <tr>
                <td><a href="http://localhost:8181/HFProject/ComDetail?commentID=${com.commentID}">${com.commentID }</td>
                 <td>${com.getCommentAuthor()}</td>
                 <td>${com.getCommentContent()}<form action="http://localhost:8181/HFProject/ComDelete.do" method="post">
				        <input type="hidden" name="commentID" value="${com.commentID}">
				        <input type="hidden" name="postID" value="${com.postID}">
				        <input type="submit" value="삭제" >
				       </form>
				       <form action="http://localhost:8181/HFProject/ComUpdateForm.do" method="post">
					   <input type="hidden" name="commentID" value="${com.commentID }">
					   <input type="hidden" name="commenContent" value="${com.commentContent }">
                       <input type="hidden" name="commentAuthor" value="${com.commentAuthor }">
					   <input type="submit" value="수정">
					 </form>
				  </td>
              </tr>
              </c:forEach>
          </tbody>
     </table>
     
	 <form action="/HFProject/ComInsertForm.do" method="post">
	     	<input type="hidden" name="postID" value="${board.postID}">
			<input type="submit" value="댓글쓰기">
	 </form>
</body>
</html>