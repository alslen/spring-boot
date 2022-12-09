<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SecurityJPA Board</h1>      
  </div>
</div>

<div class="container">
	<h3>회원수(${count})</h3><br>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이메일</th>
			<th>권한</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${member}" var="member">
			<tr>
				<td>${member.id}</td>
				<td>${member.username}</td>
				<td>${member.email}</td>
				<td>${member.role}</td>
				<td><a href="/adminDelete/${member.id}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	
</div>