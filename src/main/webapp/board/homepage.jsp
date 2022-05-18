<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src='main.js'></script>
    <link rel="stylesheet" href="stylesheet.css">
    <script src='defaultScript.js'></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://unpkg.com/react@18/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@18/umd/react-dom.development.js" crossorigin></script>
</head>
<body>
    <div>
        <div class="fixed-top" id="staticHead">
            <!-- #header -->
            <div id="headBarPrimary">
	            <div class="row">
	                <div class="col-md-1">
	            	<button class="btn btm-primary" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample" onclick="toggleHeader()">
	                <img src="logosvgblack.svg" style="width: 180%;"> 
	                </button>
	            	</div>
	            	<div class="col-md-2 offset-md-9 align-self-center">
                          <a class="btn btn-secondary" href="/HFProject/userLogin.do">로그인하기</a>
	            	</div>
	            </div>
            </div>
        </div>

        <div style="display: flex; position: absolute; z-index: 2; top: 0; height: 100%;">
            <div class="collapse collapse-horizontal" id="collapseWidthExample">
              <div style="width: 200px; height: 100%; background-color: #ecf4ff;">
    
                <div class="row" id="sidebarElement" style="background-color:  #f0b968; padding-bottom: 20px; margin-right: 0;">
                    <br>
                    <button class="btn" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" onclick="toggleHeader()" aria-controls="collapseWidthExample">
                        <img src="logosvgwhite.svg" style="width: 95%; padding-top: 20px; padding-right: 10px; display: inline-block;">
                    </button>
                    <!-- note: make js function to stop page scroll when sidebar is open-->
                    <!--
                        <img src="logosvgwhite.svg" style="width: 60%; padding-top: 20px; display: inline-block;">
                    <br><br>
                    <button style="display: inline-block; width: 20%; margin-left: 40px; margin-top: 20px;" class="btn btn-outline-light" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample">
                        
                    </button> -->
                </div>
                <div class="row" id="sidebarElement" style="margin-top: 10px;">
                    <h4 style="color: #f0b968; font-weight: 1000;">Hungry & Full</h4>
                </div>
                <div class="row" id="sidebarElement">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                          <a class="nav-link" href="userLogout.do">로그아웃</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="userDelete.do">회원탈퇴</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="AllUser.do">회원목록</a>
						<!--  <form action = "userUpdateForm.do" method = "post">
							<input type="text" name="s_id" value="${s_id}"/>
							<input type ="submit" value = "정보수정" />
						</form>   -->                        
                        </li>
                      </ul>
                </div>
                <hr>
                <div class="row" id="sidebarElement" style="margin-right: 10px;">
                	<a class="btn btn-light" href="homepage.do">Homepage</a>
                </div>
              </div>
            </div>
          </div>
    
        <div class="container-fluid">
            <!-- #body -->
            <div id="bodyPrimary">
                <p>
                </p>
            </div>
            <div id="searchPrimary">
                <div class="row justify-content-center">
                    <div class="col-6 align-self-center rounded-pill" id="searchBar">
                        <form>
                            <!-- #submit is kb-enter -->
                            <div class="form-group">
	                            <div class="row">
		                            <div class="col-md-11">
	                                	<input type="text" class="form-control border-0"/>	                            
		                            </div>
		                            <div class="col-md-1">
	                                	<img src="search.svg" style="width: 99%; padding-top:5px; padding-right:5px;"/>	                            
		                            </div>
	                            </div>
                            </div>
                        </form>
                        
                    </div>
                </div>
            </div>
            
            

            <div id="rankBox" class="row justify-content-center">
                <div id="rankContents" class="col-8 rounded-3">
                    <div id="rankTitle" class="row">
                        <!-- <h1>rankTitle</h1> -->
                    </div>
                    <div id="rankPost" class="row">
                        <!-- <h1>rankPost</h1> -->
                        <!-- #add forEach logic, 3 elements -->
                        <div class="col-md-4" id="rankDisplayBlock">
                        element 1
                        </div>
                        <div class="col-md-4" id="rankDisplayBlock">
                        element 2
                        </div>
                        <div class="col-md-4" id="rankDisplayBlock">
                        element 3
                        </div>                        
                    </div>
                </div>
            </div>
            <div id="postList">
    
            </div>
        </div>
    
        <div class="container" id="recipeBody">
            <div class="row justify-content-center">
                <div class="col-10">
                	<a href="/HFProject/boardInsertForm.do" class="btn btn-light">Post Recipe</a>
                    <div class="recipePost">
                        <!--  <h1 style="">recipePost</h1> -->
                        <!-- #add forEach logic, 5 elements -->
                        <!-- limit is defined in service -->
						<c:forEach var="board" items="${boardList}">
                            <div class="row justify-content-center">
                            <div class="col rounded" id="recipeDetail">
                            	<div class="row">
                            		<div class="col-md-2">
                            			<img class="rounded" src="${board.imageLink}" style="width: 200px; padding-top:10px;"/>                            		
                            		</div>
                            		<div class="col-md-8 offset-md-1">
                            		<br>
                            		<div class="row">
	                            		<div class="col-sm-4">
			                            	<c:choose>
												  <c:when test="${board.postType == 1}"><span class="badge bg-success">다이어트</span></c:when>
												  <c:when test="${board.postType == 2}"><span class="badge bg-primary">간편식</span></c:when>
												  <c:when test="${board.postType == 3}"><span class="badge bg-info">이유식</span></c:when>
												  <c:when test="${board.postType == 4}"><span class="badge bg-warning">건강식</span></c:when>
											      <c:when test="${board.postType == 5}"><span class="badge bg-danger">특별식</span></c:when>
											</c:choose>
											<span class="badge rounded-pill bg-secondary">Post#: ${board.postID}</span>
											<!-- ${board.postAuthor}  -->                           		
	                            		</div>
                            		</div>
                            		<br>
                            		<div class="row justify-content-center">
                            			<a href="/HFProject/recipeDetail.do?postID=${board.postID}" class="btn btn-light"> ${board.postTitle}</a>                    		
                            		</div>
                            		<br>
                            		<div class="row" id="contentBox">
                            			<span>${board.postContent} </span>   
                            		</div>
                            		<div class="row align-items-end">
	                            		<div class="col-sm-10 align-self-end">
	                            			<span>${board.postTime}<span> | </span>
											${board.postLastModified}</span>
											<span class="badge bg-secondary">  Views: ${board.viewCount} </span>	                            		
	                            		</div>
                            		</div>
                            		</div>
                            	</div>
                                <hr>
                            </div>
                            </div>
						</c:forEach>
                        <!-- #end of logic -->
                        <!-- #temporary elements -->
                        <!-- #end of temporary elements -->
                    </div>
                </div>
            </div>
        </div>
    
        <div class="container" id="pagination">
            <div class="row justify-content-center">
                <div class="col-6">
                    <hr>
                    <br>
					<nav aria-label="Page navigation example">
					  <ul class="pagination justify-content-center">
					  	<c:if test="${buttons.startPage ne 1}">
							<li class="page-item"><a class="page-link" href="/HFProject/board/homepage.do?pageNum=${buttons.startPage - 1}">&laquo;</a></li>
						</c:if>
						<c:forEach var="pageNum" begin="${buttons.startPage }" end="${buttons.endPage }">
							<li class="page-item ${buttons.currentPage eq pageNum ? 'active' : ''}"><a class="page-link" href="/HFProject/board/homepage.do?pageNum=${pageNum}">${pageNum}</a></li>
						</c:forEach>
						<c:if test="${buttons.endPage ne buttons.totalPages}">
					    	<li class="page-item"><a class="page-link" href="/HFProject/board/homepage.do?pageNum=${buttons.endPage + 1}">&raquo;</a></li>
					    </c:if>
					  </ul>
					</nav>
                </div>
            </div>
        </div>
    
        <div class="container">
            <!-- #footer -->
            <div id="footerPrimary">
                <div class="row">
                    <div>
                        <img id="logoWhite" src="logosvgwhite.svg">
                    </div>
                    <div id="linkTableA">
    
                    </div>
                    <div id="linkTableB">
            
                    </div>
                </div>
                <div class="row">
                    <div id="footerInfo" class="">
                        <span>A Web Project by ** | Repository: </span><a href="https://github.com/gonkmetrics/hungryFull">gonkmetrics/hungryFull</a>
                        <br><span>Copyright ©HungryAndFull | All Rights Reserved</span>
                    </div>
                </div>
    
            </div>
        </div>
    </div>
</body>
</html>