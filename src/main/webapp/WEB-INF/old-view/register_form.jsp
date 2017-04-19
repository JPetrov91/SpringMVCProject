<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>


</head>
<body>
	<h1 class="text-center text-uppercase">Register</h1>
	<div class="container">
		<form:form id="formRegister" method="post" modelAttribute="user" action="registrationSubmit">
			<h2 class="Registration"></h2>
			<div class="form-group">
				<input name="username" id="username" class="form-control" placeholder="E-Mail">
				<input name="password" id="password" type="password" class="form-control" placeholder="Password">
				<input name="confirmPassword" id="confirmPassword" type="password" class="form-control" placeholder="Confirm Password">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
			</div>
		</form:form>
	</div>
	</body>
</html>
