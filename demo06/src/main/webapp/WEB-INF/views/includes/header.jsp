<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SecurityJPA JPA</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>

<sec:authorize access="isAuthenticated()"> <!-- 권한이 있으면 -->
	<sec:authentication property="principal" var="principal"/>
</sec:authorize>

<nav class="navbar navbar-expand-sm bg-info navbar-dark">
<div class="container">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="/">HOME</a>
  
  <!-- Links -->
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <a class="nav-link" href="/board/insert">BoardInsert</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="/board/list">BoardList</a>
    </li>
  </ul>
  
  <ul class="navbar-nav">
	  <sec:authorize access="isAnonymous()">
	    <li class="nav-item">
	      <a class="nav-link" href="/login">로그인</a>
	    </li>
	     <li class="nav-item">
	      <a class="nav-link" href="/register">회원가입</a>
	    </li>
	    </sec:authorize>
	    
	    <sec:authorize access="isAuthenticated()">
	      <li class="nav-item">
	      <a class="nav-link" href="/logout">로그아웃(<sec:authentication property = "principal.user.username"/>)</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="/memberView">회원변경</a>
	    </li>
	    </sec:authorize>
	    
  </ul>
 </div>
</nav>
