<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : ${member.id}<br/>
이름 : ${member.name}<br/>
이메일 : ${member.email}<br/>
주소 : ${member.addr} <br>
<a href="/update/${member.id}">수정</a><br>
</body>
</html>