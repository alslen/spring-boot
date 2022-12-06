<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>
<h3>수정폼</h3>
	id : <input type="text" id="id" name="id" readonly="readonly" value="${member.id}"><br>
	Name : <input type="text" id="name" name="name" value="${member.name}"><br>
	Password : <input type="password" id="password" name="password" value="${member.password}"><br>
	Email : <input type="text" id="email" name="email" value="${member.email}"><br>
	Addr : <input type="text" id="addr" name="addr" size="30" value="${member.addr}"><br>
	Memo : <textarea rows="3" cols="50" id="memo" name="memo">${member.memo}</textarea><br>
	<button type="button" id="btnUpdate">수정하기</button><br> <!--type:submit -->
	<script src="/js/member.js"></script> <!-- document.ready를 사용x -->
</body>
</html>