<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="../css/custom2.css" rel="stylesheet">
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
        

        
        div.container{
        width:10000px; background:#e9ecef
        }
        
   
</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<div class="grid">
			<form action="/HFprj/boardUpdate.do" method="post">		
					<div class="header">
					    <label for="postTitle" class="form-label" style="margin : 10px; ">제목</label>
		  				  <input type="text" name="postTitle" value="${board.postTitle}" style="margin : 10px; ">
		  				<br/>
					     <div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false" style="margin : 10px;">
							  카테고리
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							  <li><a class="dropdown-item" href="#" >다이어트</a></li>
							  <li><a class="dropdown-item" href="#">간편식</a></li>
							  <li><a class="dropdown-item" href="#">이유식</a></li>
							  <li><a class="dropdown-item" href="#">건강식</a></li>
							  <li><a class="dropdown-item" href="#">특별식</a></li>
							</ul>
						  </div>
						 <label for="postType" class="form-label" style="margin : 10px; ">타입</label>
		  				<input type="text" name="postType"  value="${board.postType}" style="margin : 10px;">
		  				<br/>
					  </div>
					</div><!-- grid끝 -->
					<div class="author">
		  				<label for="author" class="form-label" style="margin : 10px;">글쓴이</label>
		  				<input type="text" name="postAuthor" value="${board.postAuthor}" readonly style="margin : 10px;">
						<br/>
					</div>
				<div class="wrtier">
				 	<label for="textarea" class="form-label" style="margin : 10px;"> 본 문 </label>
					<textarea class="form-control" name="postContent" id="textarea" rows="30" style="margin : 10px;">${board.postContent}</textarea>
					<br/>
				</div>
				<br/>
				<input type="hidden" name="postID" value="${board.postID}" style="margin : 10px;">
				<input type="submit" value="수정완료" class="btn btn-primary btn-dark" style="margin : 1px 1px 30px 10px;">
			</form>
		</div>
	</div> <!-- container END -->
</body>
</html>