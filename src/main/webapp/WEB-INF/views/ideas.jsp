<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/assets/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/assets/css/styles.css" />" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>

<t:layout title="List of Ideas">
	<h1 class="text-center text-uppercase">List of Ideas</h1>
	
	<div class="jumbotron">
			<c:forEach items="${list}" var="item" varStatus="loop">
				<c:if test="${loop.index % 2 == 0}">
					<div class="row"></div>
				</c:if>
				<div class="col-md-6">
					<div class="idea-note">
						<div class="idea-header">
							<span class="idea-caption"><c:out value="${item.caption}"></c:out></span>
						</div>
						<div class="idea-body">
							<span class="idea-caption"><c:out value="${item.content}"></c:out></span>
						</div>
						<div class="idea-footer">
							<span class="idea-likes-dislikes">
								<span class="glyphicon glyphicon-triangle-top idea-likes-button" title="Likes"></span>
								<span class="idea-likes"><c:out value="${item.likes}"></c:out></span>
								<span class="idea-dislikes"><c:out value="${item.dislikes}"></c:out></span>
								<span class="glyphicon glyphicon-triangle-bottom idea-dislikes-button" title="Dislikes"></span>
							</span>
							<span class="idea-edit-block">
								<a href="update?id=${item.id}" title="Update" class="idea-edit"><span class="glyphicon glyphicon-pencil"></span></a>
								<a href="delete?id=${item.id}" title="Delete" class="idea-delete"><span class="glyphicon glyphicon-remove"></span></a>
							</span>
						</div>
					</div>
				</div>
			</c:forEach>
	</div>
</t:layout>