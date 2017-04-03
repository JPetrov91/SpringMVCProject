<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout title="User registration">
	<h1 class="text-center text-uppercase">Register</h1>
	<div class="jumbotron">
		<form:form id="formRegister" modelAttribute="userForm" method="post" action="registrationSubmit">
			<div class="form-group">
				<label for="emailId">E-mail</label>
				<form:errors path="username" cssClass="form-control label-danger"></form:errors>
				<form:input path="username" id="username" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<label for="passwordId">Password</label>
				<form:errors path="password" cssClass="form-control label-danger"></form:errors>
				<form:input path="password" id="passwordId" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<label for="passwordId">Confirm Password</label>
				<form:errors cssClass="form-control label-danger"></form:errors>
				<form:input path="confirmPassword" id="repeatPasswordId" cssClass="form-control"/>
			</div>
			<button type="submit" class="btn btn-success">Register</button>
			<a href="ideas" class="danger-link">Cancel</a>
		</form:form>
	</div>
</t:layout>