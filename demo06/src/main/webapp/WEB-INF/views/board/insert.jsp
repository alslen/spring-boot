<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SecurityJPA Board</h1>      
  </div>
</div>

<div class="container">
	<h3>Board Insert</h3>
	<form action="/board/insert" method="post">
	<div class="form-group">
		<label for="title">제목:</label>
		<input type="text" class="form-control" id="title" name="title" placeholder="Enter title"/>
	</div>
	<div class="form-group">
		<label for="title">작성자:</label>
		<input type="text" class="form-control" id="writer" name="writer" placeholder="Enter writer" readonly="readonly"
		value="<sec:authentication property='principal.user.username'/>"/>
	</div>
	<div class="form-group">
		<label for="content">내용:</label>
		<textarea class="form-control" rows="3" cols="50" id="content" name="content"></textarea>
	</div>
	<button class="btn btn-info">글쓰기</button>
	</form>
</div>