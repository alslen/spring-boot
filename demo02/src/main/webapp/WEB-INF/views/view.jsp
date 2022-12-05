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
<br><br>
	<div align="center">
		<textarea rows="4" cols="50" id="msg"></textarea>
		<button type="button" id="btnComment" class="btn btn-success">댓글쓰기</button>
	</div>
	<hr>
	댓글(<span id="replyCount"></span>)
	<div id="replyResult"></div>
</div>

<script>

// 댓글 전체보기 + 댓글 개수
var init = function(){
	$.ajax({
		type:'get',
		url:'/reply/commentList',
		data:{"bnum":$("#num").val()}
	}) //ajax
	.done(function(resp){
		var str = "<table class='table table-hove mt-3'>"
		$.each(resp, function(key,val){
			str += "<tr>"
			str += "<td>"+val.userid+"</td>"
			str += "<td>"+val.content+"</td> "
			str += "<td>"+val.regdate+"</td>"
			str += "<td><a href='javascript:fdel("+val.cnum+")'>삭제</a></td></tr>"
		})  // each
		$("#replyResult").html(str);
		$("#replyCount").text(resp.count);
	}) // done
	.fail(function(e){
		alert("실패")
	})  // fail
}

// 댓글 삭제
function fdel(cnum){
	$.ajax({
		type:'delete',
		url:'/reply/del/'+cnum,
		success:function(resp){
			alert(resp+"번 글 삭제성공")
			init();
		},
		error:function(e){
			alert("삭제실패")
		}
		
	})
}

// 댓글 추가
$("#btnComment").click(function(){
	if($("#msg").val()==""){
		alert("댓글을 입력하세요")
		return false;
	}
	var data = {
			"bnum" : $("#num").val(),
			"content" : $("#msg").val(),
			"userid" :'aa'
	}
	$.ajax({
		type:'post',
		url:'/reply/commentInsert',
		contentType:'application/json;charset=utf-8',
		data:JSON.stringify(data)
	}) // ajax
	.done(function(resp){
		alert("댓글추가 성공")
		init();
	})
	.fail(function(e){
		alert('댓글추가 실패')
	})
})  // btnComment

// 게시글 삭제
$("#btnDelete").click(function(){
	//if(!confirm('정말 삭제할까요?'))
	if(confirm('정말 삭제할까요?')==false)	return false;
	$.ajax({
		type:"DELETE",
		url:"/delete/${board.num}",
		success:function(resp){
				alert(resp+'번 글 삭제성공')
				location.href="/list";
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

init(); //script가 실행되자마자 실행되게 만들기 위해 선언
</script>
