<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom:0px;">
    <h1>SpringBoot Board</h1>      
  </div>
</div>


<div class = "container">
<table class="table">
<input type="hidden" id="num" name="num" value="${board.num }"/>
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
		<th>글제목</th>
		<td colspan="3">${board.title}</td>
	</tr>
	<tr>
		<th>글내용</th>
		<td colspan="3">${board.content}</td>
	</tr>
	<tr>
		<td colspan="4" align="right">
			<button type="button" class="btn btn-success" id="btnUpdate">수정</button>
			<button type="button" class="btn btn-success" id="btnDelete">삭제</button>
		</td>
	</tr>
</table>
<script>
// 게시글 삭제
$("#btnDelete").click(function(){
	if(!confirm('정말 삭제할까요?'))
		return false;
	$.ajax({
		type:"DELETE",
		url:"/delete/${board.num}",
		success:function(resp){
			if(resp=="success"){
				alert(resp)
				location.href="/list";
			}
		},
		error:function(){
			alert("삭제 실패")
		}
	}) // ajax
})  // btnDelete

// 게시글 수정폼
$("#btnUpdate").click(function(){
	if(!confirm('정말 수정할까요?'))
		return false;
	location.href="/update/${board.num}"
})  // btnUpdate

</script>
</div>