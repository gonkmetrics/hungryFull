<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<c:import url="../templateHead.html"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
	$( document ).ready(function() {
		var loginState = '${sessionScope.loginState}';
		console.log("Login Status: "+loginState);
		if(loginState == 1){
			return alert("Login Failed");
		}
	});
	</script>
</head>
<body>
    <div>
		<c:import url="../templateHeader.jsp"/>
        <div class="container-fluid">
            <div id="backgroundPrimary">
				<!-- only displays background. do not modify -gonk -->
            </div>
            <div id="backgroundSpacer">
            </div>

            <div class="row justify-content-center" id="rankBody">
                <div id="rankContents" class="col-8 rounded-3 py-4">
                    <div id="rankPost" class="row justify-content-center">
                        <!-- <h1>rankPost</h1> -->
                        <div class="d-flex align-items-center">
	                        <p class="me-auto p-1 fs-1">${sessionScope.s_id ne null ? 'Hello ' : 'Hello'}${sessionScope.s_id}!</p>
	                        <p class="p-1 fs-5">Check out our most popular recipes:</p>
                        </div>
                        <div class="row row-cols-1 row-cols-md-3 g-4">
                        <c:forEach items="${bo}" var="board">
						  <div class="col">
						    <div class="card h-100">
						      <img src="${board.imageLink}" class="card-img-top" alt="...">
						      <div class="card-body">
						        <h5 class="card-title">${board.postTitle}</h5>
						        <p class="card-text" id="rankContentsTruncated">${board.postContent}</p>
						      </div>
						      <a href="/HFProject/recipeDetail.do?postID=${board.postID}" class="stretched-link"></a>
						    </div>
						  </div>
						  </c:forEach>
						  </div>
                        <!-- <span>ranklist: ${applicationScope['rank1']}</span> -->
                    </div>
                </div>
            </div>
        </div>

        <div class="container" id="recipeBody">
            <div class="row justify-content-center">
                <div class="col-11">
                    <div class="recipePost">
						<c:forEach var="board" items="${boardList}">
						    <div class="col rounded" id="recipeDetail">
							<div class="d-flex position-relative p-3">
							    <img src="${board.imageLink}" class="w-25">
							    <div class="ps-4">
							      <h3 class="mt-0">${board.postTitle}</h3>
							      	<c:choose>
							        <c:when test="${board.postType == 1}"><span class="badge bg-success">다이어트</span></c:when>
							        <c:when test="${board.postType == 2}"><span class="badge bg-primary">간편식</span></c:when>
							        <c:when test="${board.postType == 3}"><span class="badge bg-info">이유식</span></c:when>
							        <c:when test="${board.postType == 4}"><span class="badge bg-warning">건강식</span></c:when>
							        <c:when test="${board.postType == 5}"><span class="badge bg-danger">특별식</span></c:when>
							        </c:choose>
							        <span class="badge rounded-pill bg-secondary">Post#: ${board.postID}</span>
							        <br><br>
							      <p>${board.postContent}</p>
							      <a href="/HFProject/recipeDetail.do?postID=${board.postID}" class="stretched-link"></a>
							        <div class="pt-3">
								        <span>${board.postTime}<span> | </span>
								        ${board.postLastModified}</span>
								        <span class="badge bg-secondary"> Views: ${board.viewCount} </span>								        
							        </div>
							    </div>
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
                	<br>
                    <hr>
                    <br>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <c:if test="${buttons.startPage ne 1}">
                                <li class="page-item"><a class="page-link"
                                        href="/HFProject/homepage.do?pageNum=${buttons.startPage - 1}">&laquo;</a>
                                </li>
                            </c:if>
                            <c:forEach var="pageNum" begin="${buttons.startPage }" end="${buttons.endPage }">
                                <li class="page-item ${buttons.currentPage eq pageNum ? 'active' : ''}"><a
                                        class="page-link"
                                        href="/HFProject/homepage.do?pageNum=${pageNum}">${pageNum}</a></li>
                            </c:forEach>
                            <c:if test="${buttons.endPage ne buttons.totalPages}">
                                <li class="page-item"><a class="page-link"
                                        href="/HFProject/homepage.do?pageNum=${buttons.endPage + 1}">&raquo;</a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <c:import url="../templateFooter.html"/>
    </div>
</body>

</html>