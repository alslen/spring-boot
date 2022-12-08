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
	<div align="center">
		<textarea rows="3" cols="50" id="msg"></textarea>
		<button type="button" class="btn btn-info" id="btnComment">답글쓰기</button>
	</div>
	<br><br>
	댓글(<span id="replyCount"></span>)
	<div id="replyResult"></div>
</div>

<script>

// 댓글 전체보기
var init = function(){
	$.ajax({
		type:'get',
		url:"/reply/list/"+$("#num").val()
	})  // ajax
	.done(function(resp){
		var str = "<table class='table table-hover'>"
		$.each(resp.clist, function(key,val){
			str += "<tr>"
			str += "<td>"+val.user.id+"</td>"
			str += "<td>"+val.user.username+"</td>"
			str += "<td>"+val.content+"</td>"
			str += "<td>"+val.regdate+"</td>"
			str += "<td>삭제</td>"
			str += "</tr>"
		})  // each
		str += "</table>"
		$("#replyResult").html(str)
		$("#replyCount").text(resp.count)
	}) // done
}  // init

// 댓글 추가
$("#btnComment").click(function(){
	if(${empty principal.user}){  // principal에 user객체가 없다면(로그인을 안했다면)
		alert("로그인을 하세요")
		location.href="/login"
		return;
	}
	if($("#msg").val()==""){
		alert("댓글을 적으세요")
		return;
	}
	var data = {
			"bnum" : $("#num").val(),
			"content":$("#msg").val()
	}
	$.ajax({
		type:'post',
		url:"/reply/insert/"+$("#num").val(),
		contentType:"application/json;charset=utf-8",
		data:JSON.stringify(data)
	})
	.done(function(resp,status){  // status 안에는 success라는 키워드가 들어가 있음.
		alert(status)
		alert("댓글 추가 성공")
		init();
	})
	.fail(function(){
		alert("댓글 추가 실패")
	})
});

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
		if(!confirm('정말 수정할까요?')) return false;
		location.href="/board/update/${board.num}"
	})  // btnUpdate
	
init();
</script>