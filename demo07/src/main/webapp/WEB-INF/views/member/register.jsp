<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SpringBootTest Join</h1>      
  </div>
</div>

<div class="container">
<h3>JOIN</h3>
<div class="form-group">
	<label for="username">아이디:</label>
	<input type="text" class="form-control" id="username" placeholder="Enter id" name="username">
</div>
<div class="form-group">
	<label for="username">비밀번호:</label>
	<input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
</div>
<div class="form-group">
	<label for="username">성명:</label>
	<input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
</div>
<div class="form-group">
	<label for="email">이메일:</label>
	<input type="text" class="form-control" id="email" placeholder="Enter email" name="email">
</div>
<div class="form-group">
	<label for="email">주소:</label>
	<input type="text" class="form-control" id="address" placeholder="Enter address" name="address">
</div>
<div class="form-group">
	<label for="email">전화번호:</label>
	<input type="text" class="form-control" id="phone" placeholder="Enter phone" name="phone">
</div>
<button type="button" class="btn btn-info" id="btnJoin">회원가입</button>
</div>

<script>
	$("#btnJoin").click(function(){
		if($("#username").val()==""){
			alert("아이디를 입력해주세요")
			$("#username").focus();
			return false;
		}
		if($("#password").val()==""){
			alert("비밀번호를 입력해주세요")
			$("#password").focus();
			return false;
		}
		if($("#name").val()==""){
			alert("성명을 입력해주세요")
			$("#name").focus();
			return false;
		}
		if($("#email").val()==""){
			alert("이메일 입력해주세요")
			$("#email").focus();
			return false;
		}
		if($("#address").val()==""){
			alert("주소를 입력해주세요")
			$("#address").focus();
			return false;
		}
		if($("#phone").val()==""){
			alert("전화번호를 입력해주세요")
			$("#phone").focus();
			return false;
		}
		
		var dataParam = {
				"username":$("#username").val(),
				"password":$("#password").val(),
				"name":$("#name").val(),
				"email":$("#email").val(),
				"address":$("#address").val(),
				"phone":$("#phone").val()
		}
		$.ajax({
			type:'post',
			url:'/register',
			contentType:'application/json;charset=utf-8',
			data:JSON.stringify(dataParam),
			success:function(resp){
				if(resp=="success"){
					alert('회원가입 성공')
					location.href="/login";
				} else if(resp=="fail"){
					alert("아이디 중복")
					$("#username").val("")  // 공백으로 만들어줌
				}
			},
			error:function(e){
				alert('회원가입 실패')
			}
		}) // ajax
	})  // btnJoin
		
</script>
    