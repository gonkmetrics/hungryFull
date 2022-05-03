<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

제목 : ${board.postTitle}
<br/>
타입 : ${board.postType}
<br/>
내용 : ${board.postContent}
<br/>
postAuthor : ${board.postAuthor}
<br/>
조회수 : ${board.viewCount}
<br/>
작성시간 : ${board.postTime}
<br/>
최근 수정 : ${board.postLastModified}


</body>
</html>