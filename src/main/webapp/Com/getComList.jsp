<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<c:import url="../templateHead.html"/>
</head>
<body>
     <table class="table table-bordered table-hover table-dark">
         <thead>
             <tr>
                <td>댓글번호</td>
                <td>글쓴이</td>
                <td>내용</td>
             </tr>
         </thead>
          <tbody>
             <c:forEach var="com" items="${ComList}">
              <tr>
                <td><a href="http://localhost:8181/HFProject/ComDetail?commentID=${com.commentID}">${com.commentID }</td>
                 <td>${com.getCommentAuthor()}</td>
                 <td>${com.getCommentContent()}</td>
              </tr>
              </c:forEach>
          </tbody>
     </table>
     <a href="http://localhost:8181/HFprj/Com/ComInsertForm.jsp"><button>댓글쓰기</button></a>
</body>
</html>