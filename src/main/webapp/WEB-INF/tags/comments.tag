<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
  <!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
<link href=<c:url value="/resources/css/bootstrap.min.css" /> rel="stylesheet">
<link href=<c:url value="/resources/css/font-awesome.min.css" /> rel="stylesheet">
<link href=<c:url value="/resources/css/style.css" /> rel="stylesheet">
</head>
<body>
<div class="comments-form-container">
<!-- <form action="/submit_comment" method="post"> -->
<!-- 	<div class="new-comment-form"> -->
<!-- 	<input type="text" name="title" placeholder="Title"><br> -->
<%-- 	<textarea name="content" rows="10" cols="45" placeholder="Add your comment"></textarea> --%>
<!-- 	<button type="submit">Submit</button> -->
<!-- 	</div> -->
<!-- </form> -->

<form:form id="addComment" modelAttribute="comment" method="post" action="submit_comment">
	Title:<form:input path="title"/> <br>
	Comment:<form:input path="content"/>
	<form:button>Submit</form:button>
	<input type="hidden" name="bookId" value="${book.id}" >
	<input type="hidden" name="userId" value="${user.id}" >
</form:form>

	<div class="comments-list">
		<c:forEach items="${commentsList}" var="comment">
			<div class="comment">
				<p><c:out value="${comment.publicationDate}"></c:out></p>
				<p><c:out value="${comment.author.username}"></c:out></p>
				<p><c:out value="${comment.title}"></c:out></p>
				<p><c:out value="${comment.content}"></c:out></p>
			</div>
		
		</c:forEach>
	</div>
</div>
