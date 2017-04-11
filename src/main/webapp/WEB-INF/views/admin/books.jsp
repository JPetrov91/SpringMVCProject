<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
<t:admin_navigation title="Edit Users">
<table class="table table-sm">
  <thead class="thead-default">
    <tr>
      <th>#</th>
      <th>Title</th>
      <th>Author</th>
      <th>Image</th>
      <th>Description</th>
      <th>Rating</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items = "${booksList}" var="book">
    <tr>
      <th scope="row"><c:out value="${book.id}"></c:out></th>
      <td><c:out value="${book.title}"></c:out></td>
      <td><c:out value="${book.author}"></c:out></td>
      <td><c:out value="${book.image}"></c:out></td>
      <td><c:out value="${book.description}"></c:out></td>
      <td><c:out value="${book.rating}"></c:out></td>
      <td><a href="${contextPath}/books/edit?id=${book.id}" title="edit" class="edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
      <td><a href="${contextPath}/books/delete?id=${book.id}" title="delete" class="delete"><span class="glyphicon glyphicon-remove"></span></a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
EDIT BOOKS PAGE
</t:admin_navigation>