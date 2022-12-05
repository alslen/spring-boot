<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
<sec:authorize access="isAnonymous()">  <!-- 인증x -->
<a href="/login">로그인</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()"> <!-- 인증되었다면 -->
	<a href="/logout">로그아웃</a><br>
	principal : <sec:authentication property="principal"/><br>
	<!--principal에 담겨있는 username은 userid를 가리킴  -->
	사용자ID : <sec:authentication property="principal.username"/><br>
	사용자이름 : <sec:authentication property="principal.member.username"/><br> <!-- member라는 변수는 MemberService에서 반환되어짐. -->
	권한 : <sec:authentication property="principal.member.authList"/> <!-- authList자체에 auth객체가 들어가있음. --><hr>
	Member : <sec:authentication property="principal.member"/>
</sec:authorize>

</body>
</html>