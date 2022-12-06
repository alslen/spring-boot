<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom:0px;">
    <h1>SpringBoot Board(${count})</h1>      
  </div>
</div>

<div class="container mt-5">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boards}" var="board">
				<tr>
					<td>${board.num}</td>
					<td><a href="view/${board.num}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
					<td>${board.hitcount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
