<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
		<nav class="navbar navbar-expand-lg navbar-light bg-light py-3" id="navbar-primary">
		    <div class="container-fluid">
		        <a class="navbar-brand" href="homepage.do">
		        	<img id="logo" src="logosvgblack.svg"/>
		        </a>
		        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
		            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		            <span class="navbar-toggler-icon"></span>
		        </button>
		        <div class="collapse navbar-collapse" id="navbarSupportedContent">
		        	<br>
		            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		                <li class="nav-item p-1">
		                    <a class="nav-link active" aria-current="page" href="homepage.do">Home</a>
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
		                <li class="nav-item p-1">
		                    <a class="nav-link ${sessionScope.s_id eq null ? 'disabled' : ''}" href="userDashboard.do" tabindex="-1" aria-disabled="true">User Dashboard</a>
		                </li>
		                <li class="nav-item p-1">
		                    <a class="nav-link" href="#">About</a>
		                </li>
		                <c:if test="${sessionScope.s_id ne null}">
		                <li class="nav-item p-1 ps-3">
		                    <a class="btn btn-outline-success" href="/HFProject/boardInsertForm.do">Post Recipe</a>
		                </li>
		                </c:if>		                
		            </ul>
		            <div>
		            	<c:if test="${sessionScope.s_id eq null}">
			            	<a class="btn btn-outline-dark me-4" data-bs-toggle="modal" data-bs-target="#exampleModal">
							  Login
							</a>
		            	</c:if>
		            	<c:if test="${sessionScope.s_id ne null}">
		            		<a class="btn btn-outline-dark me-4" href="userLogout.do">Logout</a>
		            	</c:if>
		            </div>
		            <div >
			            <form class="d-flex" method="get" action="searchPage.do">	            	
	                            <!-- #submit is kb-enter -->
		                            <div class="form-group">
		                                <div class="rounded-pill" id="searchBar">
		                                    <div class="d-flex">
		                                    	<div class="p-1 flex-grow-1 ps-3">
		                                    		<input type="text" class="form-control border-0 bg-transparent" name="query"/>
		                                    	</div>
		                                    	<div class="p-2">
		                                    		<img src="search.svg" id="search" />
		                                    	</div>     
		                                    </div>
		                                </div>
		                            </div>
		                            	<input type="submit" hidden/>
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
		        <h5 class="modal-title" id="exampleModalLabel">Login</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        		<form action="/HFProject/userLoginCheck.do" method="post" novalidate>
		        		<div>
							<label for="fi" class="form-label">Username or ID</label>
							<input type="text" class="form-control" id="fi" name="formId" required/><br>
							<div class="invalid-feedback">
						        Please enter your username.
						    </div>
							</div>
							<div>
							<label for="pw" class="form-label">Password</label>
							<input type="password" class="form-control" id="pw" name="formPw" required/><br>
							<div class="invalid-feedback">
						        Please enter your password.
						    </div>
							</div>
							<div class="d-flex">
								<div class="p-1">
									<input class="btn btn-primary" type="submit" value="Login" />
								</div>
								<div class="p-1 ms-auto">
									<a class="btn btn-warning" href="/HFProject/userJoinForm.do">Register</a>
								</div>
							</div>
							
						</form>
		      </div>
		    </div>
		  </div>
		</div>




</body>
</html>