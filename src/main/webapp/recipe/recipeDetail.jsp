<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="../templateHead.html"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdn.tiny.cloud/1/z9bmvgme3buxgw19nqhokowjd4x0b9mxwo8nspf31c2zbvmd/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
    <script src="https://cdn.jsdelivr.net/npm/@tinymce/tinymce-jquery@1/dist/tinymce-jquery.min.js"></script>
    <script src="ajaxLike.js"></script>
    <script>
	function loadReportLike() {
		var postid = $("#postid").text();
		var usernum = $("#usernum").text();
		console.log("report function runs");
		console.log(postid);
		console.log(usernum);
		$.ajax({
			type : "POST",
			url : "reportLike.action",
			data : "postID=" + postid + "&userNum=" + usernum,
			success : function(data) {
				var ht = data.likeType;
				console.log("liketype check: "+ht)
				$("#message").html(ht);
				if(ht === 0){
					console.log("loadno");
				}else if(ht === 1){
					console.log("loadyes");
					$("#heartA").text('Liked');
				}
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
	}
    $("#toggleLike").on("load", loadReportLike);
    function fillModal(sCom, sAut, sCid) { 
    	const a1 = sCid;
    	console.log(a1)
    	const a2 = sAut;
    	console.log(a2)
    	const a3 = sCom;
    	console.log(a3)
    	$('#comUpCID').val(a1);
    	$('#comUpAUN').val(a2);
    	$('#tinyComUpCON').val(a3);
    	}
    </script>
</head>
<body>
    <c:import url="../templateHeader.jsp" />
    <div class="container">
            <div id="backgroundPrimary">
				<!-- only displays background. do not modify -gonk -->
            </div>
    	
        <div>
            <div class="row justify-content-center">
                <div class="col-md-11 m-1" id="contentPrimary">
                	<br>
                	<div class="d-flex">
                		<h1 id="bigTitle">${board.postTitle}</h1>
	                	<div class="card ms-auto" style="width: 7rem;">
						  <!--  <div class="card-header">
						    Post Information
						  </div>-->
						  <ul class="list-group list-group-flush">
						    <li class="list-group-item">Author: ${board.postAuthor}</li>
						    <li class="list-group-item">조회수 : ${board.viewCount}</li>
						    <c:choose>
		                        <c:when test="${board.postType == 1}"><li class="list-group-item bg-primary">다이어트</li></c:when>
		                        <c:when test="${board.postType == 2}"><li class="list-group-item bg-success">간편식</li></c:when>
		                        <c:when test="${board.postType == 3}"><li class="list-group-item bg-danger">이유식</li></c:when>
		                        <c:when test="${board.postType == 4}"><li class="list-group-item bg-warning">건강식</li></c:when>
		                        <c:when test="${board.postType == 5}"><li class="list-group-item bg-info">특별식</li></c:when>
	                    	</c:choose>
	                    	<!-- <li class="list-group-item">Post ID: ${board.postID}</li>-->
						  </ul>
						</div>
                	</div>
                    <hr>
                    <div class="d-flex">
                    	<div class="p-1 me-auto">
                    		<c:if test="${sessionScope.s_id ne null }">
	                    	<button type="button" class="btn btn-outline-danger" id="toggleLike">&#129505; <span id="heartA">Like</span></button>
							<span id="message"></span>
							</c:if>
	                    </div>
	                    <div class="p-1">
		                    <button type="button" class="btn btn-secondary" data-bs-toggle="tooltip" data-bs-placement="top" title="최근 수정 : ${board.postLastModified}">
							  작성시간 | ${board.postTime}
							</button>
	                    </div>
	                    <c:if test="${sessionScope.s_num eq board.postAuthor || sessionScope.s_isAdmin eq 1}">
	                    <div class="dropdown-center p-1">
						  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownCenterBtn" data-bs-toggle="dropdown" aria-expanded="false">
						    Post Options
						  </button>
						  <ul class="dropdown-menu" aria-labelledby="dropdownCenterBtn">
						    <li>
						    	<form action="/HFProject/boardDelete.do" method="post">
	                                <input type="hidden" name="postID" value="${board.postID}">
	                                <input type="submit" class="dropdown-item" value="삭제하기">
	                            </form>
						    </li>
						    <li>
						    	<form action="/HFProject/boardUpdateForm.do" method="post">
	                                <input type="hidden" name="postID" value="${board.postID}">
	                                <input type="submit" class="dropdown-item" value="수정하기">
	                            </form>
						    </li>
						  </ul>
						</div>
						</c:if>
                    </div>
                    <br>
					<div class="row">
						<img id="imgBoard" src="${board.imageLink}" />
					</div>
                    <hr>
                    <div class="mb-12">
                        <h4>본문 </h4>
                        <p class="p-2">${board.postContent}</p>
                    </div>
                    <hr>
                    <div class="d-flex">
                    	<div class="me-auto">
                    		<h4>Comments</h4>
                    	</div>
	                    <div>
	                    	<c:if test="${sessionScope.s_id ne null }">
	                    	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#comModal">
							  Write Comment
							</button>
							</c:if>
	                    </div>
                    </div>
                    <br>
                    <table class="table table-bordered table-hover table-dark">
                        <thead>
                            <tr>
                                <td class="col-md-1">댓글번호</td>
                                <td class="col-md-1">글쓴이</td>
                                <td class="col-md-7">내용</td>
                                <td class="col-md-3"></td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="com" items="${ComList}">
                                <tr>
                                    <td>${com.commentID}</td>
                                    <td>${com.getCommentAuthor()}</td>
                                    <td>${com.getCommentContent()}</td>
                                    <td>
	                                    <c:if test="${com.getCommentAuthor() eq sessionScope.s_num || sessionScope.s_isAdmin eq 1}">
		                                    <div class="d-flex">
		                                    	<form action="ComDelete.do" method="post">
		                                            <input type="hidden" name="commentID" value="${com.commentID}">
		                                            <input type="hidden" name="postID" value="${board.postID}">
		                                            <input type="submit" class="btn btn-outline-danger" value="삭제">
		                                        </form>
		                                        <div class="ms-auto">
			                                        <!-- CommentUpdate Modal -->
			                                        <button type="button" class="btn btn-outline-warning" data-bs-toggle="modal" data-bs-target="#comUpModal" onclick="fillModal('${com.commentContent}', '${com.commentAuthor}', '${com.commentID}')">
													  Update Comment
													</button>
			                                        <!-- CommentUpdate Modal -->
		                                        </div>
		                                    </div>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br>
        			<hr>
                    <!-- Comment Modal (unable to import) -->
                    <div>
						<div class="modal fade" id="comModal" tabindex="-1" aria-labelledby="comModalLabel" aria-hidden="true">
						  <div class="modal-dialog">
						    <div class="modal-content">
						    <form action="ComInsert.do" method="post">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLabel">Comment</h5>
						        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						      </div>
						      <div class="modal-body">
								<input type="hidden" name="commentAuthor" value="${sessionScope.s_num}"><br>
								<textarea id="tiny" name="commentContent"></textarea><br>
								<input type="hidden" name = "postID" value="${board.postID}">
						      </div>
						      <div class="modal-footer">
						      	<input type="submit" value="Post" class="btn btn-primary">
						   		<input type="reset" value="Cancel" data-bs-dismiss="modal" class="btn btn-secondary">
						      </div>
						    </form>
						    </div>
						  </div>
						</div>
					</div>
					<!-- Comment Modal (unable to import) -->
					<!-- CommentUpdate Modal -->			
					<div class="modal fade" id="comUpModal" tabindex="-1" aria-labelledby="comUpModalLabel" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					    <form action="ComUpdate.do" method="post">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">Comment</h5>
					        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      </div>
					      <div class="modal-body">
					      	<input type="hidden" name="postID" value="${board.postID}">
					      	<input type="hidden" id="comUpCID" name="commentID">
							<input type="hidden" id="comUpAUN" name="commentAuthor"><br>
							<textarea id="tinyComUpCON" name="commentContent" id="comUpCON"></textarea><br>
					      </div>
					      <div class="modal-footer">
					      	<input type="submit" value="Post" class="btn btn-primary">
					   		<input type="reset" value="Cancel" data-bs-dismiss="modal" class="btn btn-secondary">
					      </div>
					    </form>
					    </div>
					  </div>
					</div>
                 	<!-- CommentUpdate Modal -->
                </div>
            </div>
        </div>
        <div id="postid" style="display: none;">${board.postID}</div>
        <div id="usernum" style="display: none;">${sessionScope.s_num}</div>
        
        <c:import url="../templateFooter.html" />
    </div>
</body>

</html>