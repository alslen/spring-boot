<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SpringBootTest List</h1>      
  </div>
</div>

<div class="container">
	<h3>회원목록(${count})</h3><br>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${member.content}" var="member">
			<tr>
				<td>${member.id}</td>
				<td>${member.username}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.address}</td>
				<td>${member.phone}</td>
				<td><a href="/deleteAdmin/${member.id}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<div class="d-flex justify-content-between mt-5 mr-auto">
	<div>
		<ul class="pagination">
			<c:if test="${member.first==false}"> <!-- 첫페이지가 아니면 -->
				<li class="page-item"><a class="page-link" href="?page=${member.number-1}&field=${param.field}&word=${param.word}">이전</a></li> <!-- board.number은 현제 페이지를 나타냄 -->
			</c:if>
			<c:if test="${member.last==false}"> <!-- 마지막 페이지가 아니면 -->
				<li class="page-item"><a class="page-link" href="?page=${member.number+1}&field=${param.field}&word=${param.word}">다음</a></li>
			</c:if>
		</ul>
	</div>
		<form class="form-inline" action="/list" method="get">
		<select name="field" class="form-control mr-sm-1">
			<option value="username">아이디</option>
			<option value="name">이름</option>
		</select>
		<input type="text" name="word" class="form-control" placeholder="Search"/>
		<button class="btn btn-info">Search</button>
		
	</form>
</div>
	
</div>

