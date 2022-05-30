<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<c:import url="templateHead.html"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<c:import url="templateHeader.jsp"/>
	<div class="container">
		<div id="backgroundPrimary">
			<!-- only displays background. do not modify -gonk -->
        </div>
        <div class="justify-content-center"  id="contentPrimary">
                <div class="row" style="text-align : center">
                <br/><br/>
                <br/><br/>
                <br/><br/>
					<h1>일치하는 페이지가 없습니다.</h1>
				</div>
				<div class="row">
					<img src="404error.svg" style= "height:100px;">
				</div>
		</div> 
	</div>
	<c:import url="templateFooter.html" />
</body>
</html>
