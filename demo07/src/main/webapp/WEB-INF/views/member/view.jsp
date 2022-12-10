<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>


<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SecurityJPA View</h1>      
  </div>
</div>
    
<div class="container">
<h3>${member.username}의 정보</h3>
	<input type="hidden" name="id" id="id" value="${member.id}"/>

	<div class="form-group">
		<label for="username">아이디:</label>
		<input type="text" class="form-control" id="username" name="username" value="${member.username}" readonly="readonly"/>
	</div>
	<div class="form-group">
		<label for="password">비밀번호:</label>
		<input type="password" class="form-control" id="password" name="password" value="${member.password }"readonly="readonly"/>
	</div>
	<div class="form-group">
		<label for="email">성명:</label>
		<input type="text" class="form-control" id="name" name="name" value="${member.name}"/>
	</div>
	<div class="form-group">
		<label for="email">이메일:</label>
		<input type="text" class="form-control" id="email" name="email" value="${member.email}"/>
	</div>
	<div class="form-group">
		<label for="email">주소:</label>
		<input type="text" class="form-control" id="address" name="address" value="${member.address}"/>
	</div>
	<div class="form-group">
		<label for="phone">전화번호:</label>
		<input type="text" class="form-control" id="phone" name="phone" value="${member.phone}"/>
	</div>
	<button type="button" id="btnUpdate" class="btn btn-info">수정</button>
	<button type="button" id="btnDelete" class="btn btn-info">탈퇴</button>
</div>

<script>
// 수정
	$("#btnUpdate").click(function(){
		var data = {
				"id" : $("#id").val(),
				"username" : $("#username").val(),
				"name" : $("#name").val(),
				"email" : $("#email").val(),
				"address" : $("#address").val(),
				"phone" : $("#phone").val()
		}
		$.ajax({
			type:'put',
			url:'/update',
			contentType:'application/json;charset=utf-8',
			data:JSON.stringify(data),
			success:function(resp){
				alert("회원정보가 수정되었습니다.")
				location.href="/login"
			},
			error:function(e){
				alert("수정실패")
			}
		})
	})  // btnUpdate
	
// 탈퇴
$("#btnDelete").click(function(){
	if(!confirm('정말 탈퇴할까요?')) return false;
	$.ajax({
		type:'delete',
		url:'/delete/${member.id}',
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

 