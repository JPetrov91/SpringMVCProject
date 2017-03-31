<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<c:if test="${not empty msg}">
		<span class="msg">${msg}</span>
	</c:if>

<form method="post" action="${contextPath}/login" class="box_login">
	<fieldset class="boxBody">
		<label>Username</label> <input type="text" name="username" placeholder="Username" autofocus="autofocus">
		<label>Password</label> <input type="password" name="password" placeholder="Password">
	</fieldset>
	
	<footer>
	<input name="_spring_security_remember_me" type="checkbox" class="checkAdmin">
	</footer>
	
	<c:if test="${not empty error}">
		<span class="error">${error}</span>
	</c:if>
	
	<input type="hidden" name="${_csrf_parameterName}" value="${_csrf_token}">
	
	<label for="remember_me">Remember me</label>
	
	<input type="submit" class="btnLogin" value="Submit">
	
</form>

</body>
</html>