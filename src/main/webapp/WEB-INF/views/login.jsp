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

<form method="post" action="${contextPath}/j_spring_security_check" class="box_login">
	<fieldset class="boxBody">
		<label>Username</label> <input type="text" name="user_login" placeholder="Username" autofocus="autofocus">
		<label>Password</label> <input type="password" name="user_password" placeholder="Password">
	</fieldset>
	
	<footer>
	<input name="_spring_security_remember_me" type="checkbox" class="checkAdmin">
	</footer>
	
	<c:if test="${not empty error}">
		<span class="error">${error}</span>
	</c:if>
	
	<label for="remember_me">Remember me</label>
	
	<input type="submit" class="btnLogin" value="Submit">
	
</form>

</body>
</html>