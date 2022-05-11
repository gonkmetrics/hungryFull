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
<div class="container-lg">
		<div class="col-sm-12">
			<form action="/HFprj/boardUpdate.do" method="post">		
					<div class="col-sm-9">
						<br/>
						<br/>
		  				<label for="title" class="form-label">제목</label>
		  				<input type="text" name="postTitle" class="form-control" id="title" value="${board.postTitle}">
		  				<br/>
					     <div class="dropdown">
							<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
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
						 <div class="dropdown">
							  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
							    Dropdown button
							  </button>
							  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							    <li><a class="dropdown-item" href="#">Action</a></li>
							    <li><a class="dropdown-item" href="#">Another action</a></li>
							    <li><a class="dropdown-item" href="#">Something else here</a></li>
							  </ul>
						</div>
						  <div class="btn-group" role="group">
    <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
      Dropdown
    </button>
    <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      <li><a class="dropdown-item" href="#">Dropdown link</a></li>
      <li><a class="dropdown-item" href="#">Dropdown link</a></li>
    </ul>
  </div>
  <div class="cont_line"><p class="cont_tit4">카테고리</p>
        <select name="cok_sq_category_4" id="cok_sq_category_4" text="종류별">
			<option value="">종류별</option><option value="63">밑반찬</option>
			<option value="56">메인반찬</option>
			<option value="54">국/탕</option>
			<option value="55">찌개</option>
			<option value="60">디저트</option>
			<option value="53">면/만두</option>
			<option value="52">밥/죽/떡</option>
			<option value="61">퓨전</option>
			<option value="57">김치/젓갈/장류</option>
			<option value="58">양념/소스/잼</option>
			<option value="65">양식</option>
			<option value="64">샐러드</option>
			<option value="68">스프</option>
			<option value="66">빵</option>
			<option value="69">과자</option>
			<option value="59">차/음료/술</option>
			<option value="62">기타</option>
		</select>
		<span class="guide" style="margin:-22px 0 0 146px;">분류를 바르게 설정해주시면, 이용자들이 쉽게 레시피를 검색할 수 있어요.</span>
      </div>
		  				<label for="type" class="form-label">타입</label>
		  				<input type="text" name="postType" class="form-control" id="title" value="${board.postType}">
		  				<br/>
					  </div>
					</div>
					<div class="col-sm-3">
		  				<label for="author" class="form-label">글쓴이</label>
		  				<input type="text" name="postAuthor" class="form-control" id="author" value="${board.postAuthor}" readonly>
						<br/>
					</div>
				<div class="mb-12">
				 	<label for="textarea" class="form-label"> 본 문 </label>
					<textarea class="form-control" name="postContent" id="textarea" cols="40" rows="20">${board.postContent}</textarea>
					<br/>
				</div>
				<br/>
				<input type="hidden" name="postID" value="${board.postID}">
				<input type="submit" value="수정완료" class="btn btn-primary btn-mb-3">
			</form>
		</div>
	</div> <!-- container END -->
</body>
</html>