<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:out value="Hi, ${user.username}"></c:out>

<form action="uploadFile" method="post" enctype="multipart/form-data">
File to upload: <input type="file" name="file"><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
<input type="submit" value="Upload">Press here to upload a file
</form>
</body>
</html>