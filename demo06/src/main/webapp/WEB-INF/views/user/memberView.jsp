<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>


<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SecurityJPA Member</h1>      
  </div>
</div>

<div class="container">
<h3>${user.username}의 정보</h3>
	<input type="hidden" name="id" id="id" value="${user.id}"/>

	<div class="form-group">
		<label for="username">아이디:</label>
		<input type="text" class="form-control" id="username" name="username" value="${user.username}" readonly="readonly"/>
	</div>
	<div class="form-group">
		<label for="password">비밀번호:</label>
		<input type="text" class="form-control" id="password" name="password" readonly="readonly"/>
	</div>
	<div class="form-group">
		<label for="email">이메일:</label>
		<input type="text" class="form-control" id="email" name="email" value="${user.email}"/>
	</div>
	<button type="button" id="btnUpdate" class="btn btn-info">수정</button>
	<button type="button" id="btnDelete" class="btn btn-info">탈퇴</button>
</div>

<script>

// 수정
$("#btnUpdate").click(function(){
	$.ajax({
		type:'put',
		url:'/memberUpdate',
		contentType:'application/json;charset=utf-8',
		data:JSON.stringify({"email" : $("#email").val(), "id" : $("#id").val()}),
		success:function(resp){
			alert("수정완료")
			location.href="/login"
		},
		error:function(e){
			alert("수정실패")
		}
	})
})  // btnUpdate


// 삭제
$("#btnDelete").click(function(){
	if(!confirm('정말 탈퇴할까요?')) return false;
	$.ajax({
		type:'delete',
		url:'/memberDelete/${user.id}',
		success:function(resp){
			alert("탈퇴가 되었습니다.")
			location="/register"
		},
		error:function(e){
			alert("탈퇴 실패")
		}
	}) // ajax
}) // btnDelete

</script>