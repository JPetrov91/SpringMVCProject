<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<t:booksheader title="Edit Profile">
	<form:form id="editProfile" modelAttribute="editedUser" action="editAction" method="post">
		<form:hidden path="id"/>
		Username: <form:input path="username" id="usernameId"/>
		<form:hidden path="password"/>
		<form:button type="submit">Save</form:button>
	</form:form>
</t:booksheader>