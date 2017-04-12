<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class="comments-form container">
	<div class="new-comment-form">
	<input type="text" value="title" placeholder="Title"><br>
	<textarea name="content" rows="10" cols="45" placeholder="Add your comment"></textarea>
	<button type="action_path_here">Submit</button>
	</div>
	<div class="comments-list">
	Comments List are here
	</div>
</div>
