<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>

    <!-- Applied Stylesheets -->
    <link rel="stylesheet" href="stylesheet.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- Applied Scripts -->
    <script src='defaultScript.js'></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://unpkg.com/react@18/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@18/umd/react-dom.development.js" crossorigin></script>
</head>

<body>
    <div>
		<c:import url="../templateHeader.html"/>
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
                                        <input type="text" class="form-control border-0" />
                                    </div>
                                    <div class="col-md-1">
                                        <img src="search.svg" style="width: 99%; padding-top:5px; padding-right:5px;" />
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
                        <c:forEach var="i" begin="1" end="3">
	                        <div class="col-md-4" id="rankDisplayBlock">
	                            <!--  from listener -->
	                        </div>
                        </c:forEach>
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
						<c:forEach var="board" items="${boardList}">
						    <div class="row justify-content-center">
						        <div class="col rounded" id="recipeDetail">
						            <div class="d-flex flex-row">
						                <div class="p-1">
						                    <img class="rounded" src="${board.imageLink}" style="width: 200px; padding-top:10px;" />
						                </div>
						                <div class="p-1">
						                    <c:choose>
						                        <c:when test="${board.postType == 1}"><span class="badge bg-success">다이어트</span></c:when>
						                        <c:when test="${board.postType == 2}"><span class="badge bg-primary">간편식</span></c:when>
						                        <c:when test="${board.postType == 3}"><span class="badge bg-info">이유식</span></c:when>
						                        <c:when test="${board.postType == 4}"><span class="badge bg-warning">건강식</span></c:when>
						                        <c:when test="${board.postType == 5}"><span class="badge bg-danger">특별식</span></c:when>
						                    </c:choose>
						                    <span class="badge rounded-pill bg-secondary">Post#: ${board.postID}</span>
						                </div>
						                <div class="p-1">
						                    <a href="/HFProject/recipeDetail.do?postID=${board.postID}" class="btn btn-light">${board.postTitle}</a>
						                </div>
						                <div class="p-1">
						                    <span>${board.postContent} </span>
						                </div>
						                <div class="p-1">
						                    <span>${board.postTime}<span> | </span>
						                    ${board.postLastModified}</span>
						                    <span class="badge bg-secondary"> Views: ${board.viewCount} </span>
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
        <div id="space"></div>
        <c:import url="../templateFooter.html"/>
    </div>
</body>

</html>