<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//js.nicedit.com/nicEdit-latest.js" type="text/javascript"></script>
<script type="text/javascript">bkLib.onDomLoaded(nicEditors.allTextAreas);</script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<style>
</style>
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-center">
		<h1 class="align-middle">insertPost</h1>
	</div>
	<br>
		<form class="row" action="http://localhost:8080/MyFirstWeb/boardInsert" method="post">
			<div class="col-12 pb-2">
				<input type="text" class="form-control border-0" name="bTitle" placeholder="Title"/>
				<hr>
			</div>
		
		<div class="row">
			<div class="col-auto pb-3">
				<textarea name="bText" cols="92" rows="6"></textarea>		
			</div>
		</div>
		<br>
		<div class="row justify-content-center">
				<div class="col-auto">
				  <input type="text" class="form-control" name="bAuthor" placeholder="Author">
				</div>
				<div class="col-auto">
				  <button type="submit" class="btn btn-primary mb-3">Submit</button>
				</div>
				<div class="col-auto ms-auto">
					<a class="btn btn-primary mb-3 ms-1" href="http://localhost:8080/MyFirstWeb/boardList">목록으로 돌아가기</a>
				</div>
				</div>	
				</form>	
			</div>
</body>
</html>