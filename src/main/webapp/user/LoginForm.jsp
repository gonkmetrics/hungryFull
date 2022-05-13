<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD

=======
>>>>>>> f8bab1a264f2813218ab3cd3304984d04866ea80
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${user}
	<form action="/HFprj/userLoginCheck.do" method="post">
		아이디 : <input type="text" name="formId" /><br/>
		비밀번호 : <input type="password" name="formPw" /><br/>
		<input type="submit" value="로그인" />
	</form>
	<a href="/HFprj/userJoinForm.do">회원가입하기.</a>
</body>
</html>