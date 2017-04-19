<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<t:booksheader title="Edit Profile">
	<form:form id="editBook" modelAttribute="book" action="editAction" method="post">
		<form:hidden path="id"/>
		Title: <form:input path="title" id="titleId"/>
		Author: <form:input path="author" id="authorId"/>
		Image: <form:input path="image" id="imageId"/>
		Description: <form:input path="description" id="descriptionId"/>
		Rating: <form:input path="rating" id="ratingId"/>
		<form:button type="submit">Save</form:button>
	</form:form>
</t:booksheader>