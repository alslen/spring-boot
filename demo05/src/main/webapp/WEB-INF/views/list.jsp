<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
</head>
<body>

<div id="memberDiv"> <!-- memberDiv를 누를때 삭제class값을 가져옴 -->
	<c:forEach items="${lists}" var="member">
		아이디 : ${member.id}<br/>
		이름 : ${member.name}<br/>
		이메일 : ${member.email}<br/>
		주소 : ${member.addr} <br>
		<a href="detail/${member.id}">상세보기</a>
		<button type="button" onclick="funDelete(${member.id})">삭제</button>
		<button type="button" class="btnDel" data-mid="${member.id}">삭제class</button> <!-- data : 사용자가 지정할 수 있는 속성값 -->
		<br/><br/>
	</c:forEach>
</div>

<script>

	// 삭제
	function funDelete(id){
		//alert(id)
		$.ajax({
			type:'DELETE',
			url:'/delete/'+id
		}) // ajax
		.done(function(resp){
			alert(resp+"번 삭제 성공")
			location.href="/list"
		})  // done
		.fail(function(){
			alert("삭제실패")
		})  // fail
	}  // funDelete
	
	var delfun = function(){
		$.ajax({
			type:'DELETE',
			url:"/delete/"+$(this).data("mid")  //this는 버튼을 누른 객체를 말함.
		})
		.done(function(resp){
			alert(resp+"번 삭제 성공")
			location.href="/list"
		})
		.fail(function(resp){
			alert("삭제 실패")
		}) 
	}
	$("#memberDiv").on("click", ".btnDel", delfun);  // btnDel이 클릭되어지면 delfun이 실행되어짐.
	
	// 삭제 class
	/*$("#memberDiv").on("click", ".btnDel", function(){  // memberDiv영역에 있는 btnDel을 클릭하면
		//alert($(this).data('mid'))
		//alert($(this).attr('data-mid')) : data-mid 속성값을 출력
		$.ajax({
			type:'DELETE',
			url:"/delete/"+$(this).data("mid")  //this는 버튼을 누른 객체를 말함.
		})
		.done(function(resp){
			alert(resp+"번 삭제 성공")
			location.href="/list"
		})
		.fail(function(resp){
			alert("삭제 실패")
		}) 
	}) */ // memberDiv 
</script>

</body>
</html>