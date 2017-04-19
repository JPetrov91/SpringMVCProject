<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="Login Page">
<c:if test="${not empty error}">
<c:out value="${error}"></c:out>
</c:if>
<form:form id="form_login" modelAttribute="newUser" action="j_spring_security_check" method="post">
			<div class="form-group">
				<label for="emailId">E-mail</label>
				<form:input path="user_login" id="user_login" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<label for="passwordId">Password</label>
				<form:input path="user_password" id="user_password" cssClass="form-control"/>
			</div>
			<button type="submit" class="btn btn-success">Register</button>
</form:form>


</t:layout>