<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.s_id eq null}">
	<c:redirect url="/userLogin.do"/>
</c:if>
<style>
   div.container{
        width:10000px; 
        background:#e9ecef;
        margin:10px;
        margin-left:55px;
        padding:10px;
        float:center;
        border-radius:10px 10px 10px 10px;
        }
        
        .write{
        margin:10px;
        padding:10px;
        }
        
        .header{
         background:#f8f9fa;
        padding:10px;
        margin:10px;
        border-radius:10px 10px 10px 10px;
        }
        
        .content{
        padding:10px;
        margin:10px;
        background:#f8f9fa;
        border-radius:10px 10px 10px 10px;
        }
        
        .author{
        padding:10px;
        margin:10px;
        border-radius:10px 10px 10px 10px;
        }
        
        #textarea1{
        height:50vh;
        width:1070px;
        margin-right:40px;
        border-radius:10px 10px 10px 10px;
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
  <form action="/HFProject/boardInsert.do" method="post">
    <div class="header">
	<label for="postTitle" class="form-label" style="margin : 10px; ">레시피 제목</label>
	<input type="text" name="postTitle"  style="margin : 10px; "><br/>
	<label for="postType" class="form-label" style="margin : 10px; ">카테고리</label>
	<input type="text" name="postType"   style="margin : 10px; "><br/>
	<div class="dropdown">
					     <label for="postType" class="form-label" style="margin : 10px; ">카테고리</label>
							<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false" style="margin : 10px;">
							  종류
							</button>
  				            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							  <li><a class="dropdown-item active" id="dropdown1" href="#" onclick="setValue1()">다이어트</a></li>
							  <li><a class="dropdown-item active" id="dropdown2"href="#" onclick="setValue2()">간편식</a></li>
							  <li><a class="dropdown-item active" id="dropdown3"href="#" onclick="setValue3()">이유식</a></li>
							  <li><a class="dropdown-item active" id="dropdown4"href="#" onclick="setValue4()">건강식</a></li>
							  <li><a class="dropdown-item active" id="dropdown5"href="#" onclick="setValue5()">특별식</a></li>
							</ul>
						  </div>
						 <script>
						 function setValue1() { document.getElementById('buttonType').value = "1"; }
						 function setValue2() { document.getElementById('buttonType').value = "2"; }
						 function setValue3() { document.getElementById('buttonType').value = "3"; }
						 function setValue4() { document.getElementById('buttonType').value = "4"; }
						 function setValue5() { document.getElementById('buttonType').value = "5"; }
						 </script>
	</div>
	<div class="author">
	 글쓴이  <input type="text" name="userID"  style="margin : 10px; " value="${sessionScope.s_id}"  readonly><br/>
	 <input type="hidden" name="postAuthor" value="${user.userNum}"/>
	</div>
	<div class="content">
	<label for="postTitle" class="form-label" style="margin : 10px; ">요리 소개</label>
	<br>
	 <textarea class="form-control" name="postContent" style="margin : 10px; " id="textarea1"></textarea><br/>
	 사진 업로드<input type="text" name="imageLink" style="margin : 10px; "><br/>
	</div>
	<div class="write">
	  <input type="submit" value="확인" class="btn btn-dark btn-mb-3">
	</div>
   </form>
</div>

</body>
</html>