<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SecurityJPA Board</h1>      
  </div>
</div>

<div class="container">
	<h2>File List</h2>
	<br>
	<div class="row">
		<c:forEach items="${flist}" var="flist">
			<div class="col-3 mb-3" style="width:400px">
			<div class="card">
				<img class="card-img-top" src="/images/${flist.fileImage}" alt="Card img" style="width:100%; height:200px">
				<div class="card-body">
					<h4 class="card-title">제목 : ${flist.title}</h4>
					<p class="card-text">저자 : ${flist.writer}</p>
					<p class="card-text">내용 : ${flist.content}</p>
				</div>
			</div>
			</div>
		</c:forEach>
	</div>
</div>