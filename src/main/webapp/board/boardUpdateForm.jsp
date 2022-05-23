<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.s_id eq null}">
	<c:redirect url="/userLogin.do"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
    <c:import url="../templateHead.html" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdn.tiny.cloud/1/z9bmvgme3buxgw19nqhokowjd4x0b9mxwo8nspf31c2zbvmd/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
    <script src="https://cdn.jsdelivr.net/npm/@tinymce/tinymce-jquery@1/dist/tinymce-jquery.min.js"></script>
    <script>
	    function setValue1() { 
	    	$('#buttonType').val("1");
	    	}
	    function setValue2() { 
	    	$('#buttonType').val("2");
	    	}
	    function setValue3() { 
	    	$('#buttonType').val("3");
	    	}
	    function setValue4() { 
	    	$('#buttonType').val("4");
	    	}
	    function setValue5() { 
	    	$('#buttonType').val("5");
	    	}
	    $( document ).ready(function() {
	    	$('textarea#tiny').tinymce({ height: 500, });
	    });
    </script>
</head>
<body>
    <c:import url="../templateHeader.jsp" />
    <div id="backgroundPrimary">
        <!-- only displays background. do not modify -gonk -->
    </div>
    <div class="container">
        <form action="/HFProject/boardUpdate.do" id="contentPrimary" method="post">
            <div class="m-2">
            	<div class="form-floating">
            		<input type="text" class="form-control" name="postTitle" id="float1" placeholder="Title" value="${board.postTitle}">
            		<label for="float1">레시피 제목</label>
            	</div>
                <br>
                
                <div class="d-flex">
	                <div class="dropdown p-2">
	                    <label for="dropdownMenuButton1" class="form-label">카테고리</label>
	                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1"
	                        data-bs-toggle="dropdown" aria-expanded="false">
	                        종류
	                    </button>
	                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
	                        <li><a class="dropdown-item" id="dropdown1" onclick="setValue1()">다이어트</a></li>
	                        <li><a class="dropdown-item" id="dropdown2" onclick="setValue2()">간편식</a></li>
	                        <li><a class="dropdown-item" id="dropdown3" onclick="setValue3()">이유식</a></li>
	                        <li><a class="dropdown-item" id="dropdown4" onclick="setValue4()">건강식</a></li>
	                        <li><a class="dropdown-item" id="dropdown5" onclick="setValue5()">특별식</a></li>
	                    </ul>
	                    <input type="hidden" name="postType" id="buttonType" value="${board.postType}">
	                </div>
	                <div class="p-2 ms-auto">
		            	<span>글쓴이</span>
		                <input class="form-control-plaintext" id="psA" type="text" name="userID" value="${sessionScope.s_id}"
		                    readonly>
		                <input type="hidden" name="postAuthor" value="${board.postAuthor}" />
		            </div>
                </div>
                <h4 class="p-2">요리 소개</h4>
                <textarea name="postContent" id="tiny">${board.postContent}</textarea>
                <br>
                <label for="image" class="form-label">사진 업로드</label>
				<input type="text" id="image" class="form-control" name="imageLink" aria-describedby="image" value="${board.imageLink}">
				<div id="image" class="form-text">
				  Insert an image URL to display for the recipe. URL must be shorter than 300 characters.
				</div>
				<br>
				<div>	
					<input type="hidden" name="postID" value="${board.postID}">
					<input type="submit" value="수정완료" class="btn btn-primary btn-dark">
			    </div>
	            <br>
            </div>

 
        </form>
    </div>
    <c:import url="../templateFooter.html" />
</body>
</html>