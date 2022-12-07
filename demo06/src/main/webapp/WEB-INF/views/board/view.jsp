<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>


<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SecurityJPA Board</h1>      
  </div>
</div>

<div class="container">
<h3>${board.user.username}의 글</h3>
	<div class="form-group">
		<label for="num">글번호:</label>
		<input type="text" class="form-control" id="num" name="num" value="${board.num}" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="title">제목:</label>
		<input type="text" class="form-control" id="title" name="title" value="${board.title}" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="writer">글쓴이:</label>
		<input type="text" class="form-control" id="writer" name="writer" value="${board.user.username}" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="content">내용:</label>
		<textarea rows="3" cols="50" class="form-control" id="content" name="content" readonly="readonly">${board.content}</textarea>
	</div>

	<div align="right">
		<c:if test="${principal.user.username==board.user.username }">
			<button type="button" class="btn btn-info" id="btnUpdate">수정</button>
			<button type="button" class="btn btn-info" id="btnDelete">삭제</button>
		</c:if>
	</div>
</div>

<script>
// 게시글 삭제
	$("#btnDelete").click(function(){
		if(!confirm('정말 삭제할까요?')) return false;
		$.ajax({
			type:'delete',
			url:'/board/delete/${board.num}'
		})  // ajax
		.done(function(resp){
			alert(resp+"번 글 삭제")
			location.href="/board/list";
		})
		.faile(function(){
			alert("삭제실패")
		})
	}) // btnDelete
	

// 수정폼
	$("#btnUpdate").click(function(){
		
	})  // btnUpdate
</script>