<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <c:import url="../templateHead.html" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
    $(function() {
        $('#delete').click(function() {
            return window.confirm("Are you sure?");
        });
    });
    </script>
  </head>
  <body>
  	<c:import url="../templateHeader.jsp" />
  	<div id="backgroundPrimary">
        <!-- only displays background. do not modify -gonk -->
    </div>
    <div class="container" id="dashboard">
      <div class="row" id="contentPrimary">
        <div class="col-md-4">
        <div class="row">
        <div class="col">
        	<span>Hello, ${sessionScope.s_id} </span>
            <div class="card">
                <div class="card-header">
                    User Administration
                </div>
                <ul class="list-group list-group-flush">
                  <li class="list-group-item">
                    <form action = "userUpdateForm.do" method = "post">
						<input type="hidden" name="s_id" value="${sessionScope.s_id}"/>
						<input type="submit" class="btn btn-link nav-link" value = "정보수정" />
					</form>
                  </li>
                  <li class="list-group-item">
                    <a class="nav-link" id="delete" href="userDelete.do">회원탈퇴</a>
                  </li>
                  <li class="list-group-item">
                    <a class="nav-link" href="userPostList.do">My Posts</a>
                  </li>
                  <c:if test="${s_isAdmin eq 1}">
                   <li class="list-group-item">
                    <a class="nav-link" href="AllUser.do">Global User List</a>
                  </li>
                  </c:if>
                </ul>
              </div>
              </div>
        </div>
        <br>
        <div class="row">
        <div class="col">
            <span>My Info</span>
            <div class="card">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Username | ${sessionScope.s_id}</li>
                    <li class="list-group-item">Name | ${user.userName}</li>
                    <li class="list-group-item">Age | ${user.uage}</li>
                    <li class="list-group-item">Email | ${user.userEmail}</li>
                  </ul>
            </div>
            </div>
        </div>
            
        </div>
        
        <div class="col-md-8">
            <span>My Liked Posts</span>
            <div class="card">
            	        <div class="container">
            <div class="row justify-content-center">
                <div class="col-11">
                    <div class="recipePost">
						<c:forEach var="board" items="${boardLike}">
						    <div class="col rounded" id="recipeDetail">
							<div class="d-flex position-relative p-3">
							    <img src="${board.imageLink}" class="w-50" id="imgBoard">
							    <div class="ms-4">
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
                                        href="/HFProject/userDashboard.do?pageNum=${buttons.startPage - 1}">&laquo;</a>
                                </li>
                            </c:if>
                            <c:forEach var="pageNum" begin="${buttons.startPage }" end="${buttons.endPage }">
                                <li class="page-item ${buttons.currentPage eq pageNum ? 'active' : ''}"><a
                                        class="page-link"
                                        href="/HFProject/userDashboard.do?pageNum=${pageNum}">${pageNum}</a></li>
                            </c:forEach>
                            <c:if test="${buttons.endPage ne buttons.totalPages}">
                                <li class="page-item"><a class="page-link"
                                        href="/HFProject/userDashboard.do?pageNum=${buttons.endPage + 1}">&raquo;</a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
            </div>
        </div>
      </div>
    </div>
    <c:import url="../templateFooter.html" />
  </body>
</html>