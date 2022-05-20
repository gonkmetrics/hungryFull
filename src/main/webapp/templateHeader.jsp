<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<nav class="navbar navbar-expand-lg navbar-light bg-light py-3">
		    <div class="container-fluid">
		        <a class="navbar-brand" href="homepage.do">
		        	<img id="logo" src="logosvgblack.svg"/>
		        </a>
		        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
		            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		            <span class="navbar-toggler-icon"></span>
		        </button>
		        <div class="collapse navbar-collapse" id="navbarSupportedContent">
		            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		                <li class="nav-item">
		                    <a class="nav-link active" aria-current="page" href="#">Home</a>
		                </li>
		                <!--<li class="nav-item dropdown">
		                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
		                        data-bs-toggle="dropdown" aria-expanded="false">
		                        Dropdown
		                    </a>
		                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
		                        <li><a class="dropdown-item" href="#">Action</a></li>
		                        <li><a class="dropdown-item" href="#">Another action</a></li>
		                        <li>
		                            <hr class="dropdown-divider" />
		                        </li>
		                        <li><a class="dropdown-item" href="#">Something else here</a></li>
		                    </ul>
		                </li> -->
		                <li class="nav-item">
		                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">User Dashboard</a>
		                </li>
		                <li class="nav-item">
		                    <a class="nav-link" href="#">About</a>
		                </li>
		            </ul>
		            <div>
		            	<c:if test="${sessionScope.s_id eq null}">
			            	<a class="nav-link" data-bs-toggle="modal" data-bs-target="#exampleModal">
							  Login
							</a>
		            	</c:if>
		            	<c:if test="${sessionScope.s_id ne null}">
		            		<a class="nav-link" href="userLogout.do">logout</a>
		            	</c:if>
		            </div>
		            <div class="col-2 align-self-center rounded-pill" id="searchBar">
			            <form class="d-flex">	            	
	                            <!-- #submit is kb-enter -->
		                            <div class="form-group">
		                                <div class="d-flex">
		                                    <div class="p-1 flex-grow-1">
		                                        <input type="text" class="form-control border-0" />
		                                        <input type="submit" hidden />
		                                    </div>
		                                    <div class="p-1">
		                                        <img src="search.svg" style="width: 50px;" />
		                                    </div>
		                                </div>
		                            </div>
		                            </form>
	                    </div>
		                <!--  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
		                <button class="btn btn-outline-success" type="submit">Search</button> -->
		            </div>
		        </div>
		</nav>
        <!--<div class="fixed-top" id="staticHead">
            <div id="headBarPrimary">
                <div class="d-flex align-items-center">
                    <div class="align-self-start">
                        <button class="btn btm-primary" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample"
                            aria-expanded="false" aria-controls="collapseWidthExample" onclick="toggleHeader()">
                            <img id="logo" src="logosvgblack.svg">
                        </button>
                    </div>
                    <div class="ms-auto px-3">
                        <a class="btn btn-secondary" href="/HFProject/userLogin.do">Login</a>
                    </div>
               </div>
            </div>
        </div>-->
        
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        		<form action="/HFProject/userLoginCheck.do" method="post">
							<label for="fi" class="form-label">id</label>
							<input type="text" class="form-control" id="fi" name="formId" /><br>
							<label for="pw" class="form-label">pw</label>
							<input type="password" class="form-control" id="pw" name="formPw" /><br>
							<div class="d-flex">
								<div class="p-1">
									<input class="btn btn-primary" type="submit" value="login" />
								</div>
								<div class="p-1 ms-auto">
									<a class="btn btn-warning" href="/HFProject/userJoinForm.do">register</a>
								</div>
							</div>
							
						</form>
		      </div>
		    </div>
		  </div>
		</div>




</body>
</html>