<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom:0px;">
    <h1>SpringBoot Board</h1>      
  </div>
</div>

<div class="container">
	<table class="table">
		<tr>
			<th>번호</th>
			<td>${board.num}</td>
			<th>조회수</th>
			<td>${board.hitcount}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer}</td>
			<th>작성일</th>
			<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
		</tr>	
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title}</td>
		</tr>		
		<tr>
			<th>내용</th>
			<td colspan="3">${board.content}</td>
		</tr>
		<tr>
			<td colspan="4">
			<button type="button" class="btn btn-success" id="btnUpdate">수정</button>
			<button type="button" class="btn btn-success" id="btnDelete">삭제</button>
			</td>
		</tr>				
	</table>
</div>

<script>
	// 수정폼
	$("#btnUpdate").click(function(){
		
	})
</script>