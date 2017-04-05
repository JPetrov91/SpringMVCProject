<%@tag pageEncoding="UTF-8" description="Base layout" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@attribute name="title" type="java.lang.String" required="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
<title><c:out value="${title}"/></title>
</head>
<body>

<header>
<div id = "login-bar">
<c:choose>
	<c:when test="${user != null}">
		<c:out value="Hello, ${user.username}"></c:out>
		<a href="j_spring_security_logout">Exit</a>
		</c:when>
		<c:otherwise>
		Abbu-Dhabi
		</c:otherwise>
	</c:choose>
</div>
	<div id="top-wrapper">
		<div id ="logo"><a href="#">LOGO</a></div>
		<nav>
		<ul>
			 <li>
                <a href="books">List of Books</a>
            </li>
            <li>
                <a href="create">Create new</a>
            </li>
            <li>
            	<a href="register">Register</a>
            </li>
              <li>
            	<a href="j_spring_security_logout">Exit</a>
            </li>
        </ul>
        </nav>
    </div>
</header>
<div class="container">
    <jsp:doBody/>
</div>
</body>
<script src="<c:url value="/assets/js/jquery-3.1.1.min.js" />"></script>
<script src="<c:url value="/assets/js/bootstrap.min.js" />"></script>
</html>
