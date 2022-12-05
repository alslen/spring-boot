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

 <div class="form-group">
 	<div class="form-group">
      	<label for="userid">title:</label>
      	<input type="text" class="form-control" id="title" placeholder="Enter title" name="title" value=${board.title }>
    </div>
    
     <div class="form-group">
      	<label for="subject">writer:</label>
      	<input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" value="${board.writer}">
    </div>
    
     <div class="form-group">
      	<label for="content">Content:</label>
      	<textarea class="form-control" rows="5" id="content" name="content">${board.content}</textarea>
    </div>
    <button type="button" class="btn btn-primary" id="btnModify">수정하기</button>
</div>
</table>
</div>

<script>
$("#btnModify").click(function(){
	if(!confirm('정말 수정할까요?')){
		return false;
	}
	var data = {
		"num" : $("#num").val(),
		"title" : $("#title").val(),
		"content":$("#content").val()
		
	}
	$.ajax({
		type:'put',
		url:'/update',
		contentType:'application/json;charset=utf-8', // 제이슨 형태로 사용하기 위해 선언
		data:JSON.stringify(data),  // 제이슨 형태로 값을 전달하기 위해 사용
		success:function(resp){
			if(resp=="success")
				alert('수정성공')
				location.href="/list"
		},
		error:function(e){
			alert("수정실패")
		}
		
	}) // ajax
});  // btnModify
</script>