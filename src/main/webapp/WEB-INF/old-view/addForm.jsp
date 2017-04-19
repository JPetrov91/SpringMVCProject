<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-*">
<title>Insert title here</title>
</head>
<body>
<form:form id="formCreate" modelAttribute="newIdea" method="post" action="submitNew">
	Caption:
	<form:input path="caption"/>
	Content:
	<form:textarea path="content"/>
	<form:button>Save</form:button>
</form:form>
<span><a href="ideas">Back</a></span>
</body>
</html>