<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그인페이지</h3>
<form action="loginPro" method="post"> <!--loginPro페이지를 만들필요x -> Security가 알아서 만들어줌. -->
	ID : <input type="text" name="username"/><br>
	PWD : <input type="password" name="password"/><br>
	<button>로그인</button>
</form>
</body>
</html>