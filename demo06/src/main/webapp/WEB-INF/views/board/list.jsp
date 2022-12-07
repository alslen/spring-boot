<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
  <div class="container" style="margin-bottom: 0px">
    <h1>SecurityJPA Board</h1>      
  </div>
</div>

<div class="container">
	<h3>게시판(${count})</h3>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${board.content}" var="board"> <!--board.content : 게시글에 대한 값이 들어있음  -->
			<tr>
				<td>${board.num}</td>
				<td><a href="/board/view/${board.num}">${board.title}</a></td>
				<td>${board.user.username}</td> <!-- Board안에 User객체가 있고 User객체 안에 username있기때문에  -->
				<td>${board.regdate}</td>
				<td>${board.hitCount}</td>
			</tr>
		</c:forEach>
	</table>
	
	<div class="d-flex justify-content-between mt-5 mr-auto">
		<ul class="pagination">
			<c:if test="${board.first==false}"> <!-- 첫페이지가 아니면 -->
				<li class="page-item"><a class="page-link" href="?page=${board.number-1}">이전</a></li> <!-- board.number은 현제 페이지를 나타냄 -->
			</c:if>
			<c:if test="${board.last==false}"> <!-- 마지막 페이지가 아니면 -->
				<li class="page-item"><a class="page-link" href="?page=${board.number+1}">다음</a></li>
			</c:if>
		</ul>
	</div>
</div>