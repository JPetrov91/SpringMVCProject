<%@tag pageEncoding="UTF-8" description="Base layout" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@attribute name="title" type="java.lang.String" required="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='https://fonts.googleapis.com/css?family=Oxygen:400,300,700' rel='stylesheet' type='text/css'>
<link href=<c:url value="/resources/css/bootstrap.min.css" /> rel="stylesheet">
<link href=<c:url value="/resources/css/font-awesome.min.css" /> rel="stylesheet">
<link href=<c:url value="/resources/css/style.css" /> rel="stylesheet">
<title><c:out value="${title}"/></title>
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">KNIGOPOISK</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            	<form action="search" method="POST" role="search" class="navbar-form navbar-left">
            		<div class="form-group">
            			<input type="text" name="bookName" placeholder="Search" class="form-control">
            		</div>
            	</form>
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="about.html">Main</a>
                    </li>
                    <li>
                        <a href="services.html">Books</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">My Profile <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                        <c:if test="${user != null}"></c:if>
                        	<li><c:out value="${user.username}"></c:out></li>
                            <li>
                                <a href="edit?id=${user.id}">Edit Profile</a>
                            </li>
                            <li>
                                <a href="admin">Admin Panel</a>
                            </li>
                            <li>
                                <a href="logout">Exit</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>
<div class="container" style="margin-top: 40px;">
    <jsp:doBody/>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
