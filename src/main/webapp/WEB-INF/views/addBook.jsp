<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-*">
<title>Add new Book</title>
</head>
<body>
<form:form id="addBook" modelAttribute="newBook" method="post" action="submitBook">
	Title:
	<form:input path="title"/>
	Author:
	<form:input path="author"/>
	Image:
	<form:input type="file" path="image"/>
	Description:
	<form:textarea path="description"/>
	<form:button>Save</form:button>
</form:form>
<span><a href="/">Back</a></span>
</body>
</html>