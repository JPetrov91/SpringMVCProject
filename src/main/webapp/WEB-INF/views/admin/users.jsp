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
      <th>Username</th>
      <th>Password</th>
      <th>Group</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items = "${usersList}" var="user">
    <tr>
      <th scope="row"><c:out value="${user.id}"></c:out></th>
      <td><c:out value="${user.username}"></c:out></td>
      <td><c:out value="${user.password}"></c:out></td>
      <td><c:out value="${user.group.groupname}"></c:out></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
EDIT USERS PAGE
</t:admin_navigation>