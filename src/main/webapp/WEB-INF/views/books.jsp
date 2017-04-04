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
<t:booksheader title="Books">
<h1>Books</h1>
<table border="2px">
<tr>
<th>Id</th>
<th>Image</th>
<th>Title</th>
<th>Author</th>
</tr>
<c:forEach items="${booksList}" var="book">
        <tr>
<td><c:out value="${book.id}"/></td>
<td><img height="150" width="150" src="<c:out value="${book.image}"/>"/></td>
<td><c:out value="${book.title}"/></td>
<td><c:out value="${book.author}"/></td>
</tr>
</c:forEach>
</table>


</t:booksheader>