<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SecurityJPA Board</h1>      
  </div>
</div>

<div class="container">
<h3>${board.user.username}의 글 수정하기</h3>
	<input type="hidden" name="num" id="num" value="${board.num }"/>
	<div class="form-group">
		<label for="title">제목:</label>
		<input type="text" class="form-control" id="title" name="title" value="${board.title }"/>
	</div>
	<div class="form-group">
		<label for="writer">글쓴이:</label>
		<input type="text" class="form-control" id="writer" name="writer" value="${board.user.username }" readonly="readonly"/>
	</div>
	<div class="form-group">
		<label for="content">내용:</label>
		<textarea rows="3" cols="50" class="form-control" id="content" name="content">${board.content}</textarea>
	</div>
	<div align="right">
		<button type="button" class="btn btn-info" id="btnModify">수정</button>
	</div>
</div>

<script>
	$("#btnModify").click(function(){
		var data = {
				"num" : $("#num").val(),
				"title" : $("#title").val(),
				"content" : $("#content").val()
		}
		$.ajax({
			type:'put',
			url:'/board/update',
			contentType:'application/json;charset=utf-8',
			data :JSON.stringify(data),
			success:function(resp){
				alert("수정성공")
				location.href="/board/list"
			},
			error:function(e){
				alert("수정실패")
			}
		})  // ajax
	}) // btnUpdate
	

</script>