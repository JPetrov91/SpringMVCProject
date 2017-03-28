<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:layout title="Edit Idea">
     <h1 class="text-center text-uppercase"><c:out value="${book.title}"></c:out></h1>
     <div class="jumbotron">
     <c:out value="${book.id}"></c:out>
     <img height="300" width="300" src="<c:out value="${book.image}"/>"/>
     <c:out value="${book.title}"></c:out>
     <c:out value="${book.author}"></c:out>
     <c:out value="${book.description}"></c:out>
     </div>
     </t:layout>