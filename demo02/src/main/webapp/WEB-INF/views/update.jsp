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
      	<label for="userid">title:</label>
      	<input type="text" class="form-control" id="title" placeholder="Enter title" name="title" value=${board.title }>
    </div>
    
     <div class="form-group">
      	<label for="subject">writer:</label>
      	<input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer" value="${board.writer}" readonly="readonly">
    </div>
    
     <div class="form-group">
      	<label for="content">Content:</label>
      	<textarea class="form-control" rows="5" id="content" name="content">${board.content}</textarea>
    </div>
    <button type="button" class="btn btn-primary" id="btnModify">수정하기</button>
</div>
</table>
</div>