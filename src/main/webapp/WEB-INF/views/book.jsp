<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:booksheader title="Book">
<div class="container">
	<div class="book-header">
		<h3 class="text-left"><c:out value="${book.title}"/></h3>
		<h4 class="text-right"><c:out value="${book.author}"/></h4>
	</div>
	<div class="book-content">
		<div class="book-content left-column">
			<img alt="<c:out value="${book.title}"/>" src="<c:url value="/resources/img/${book.image}"/>"/>
			<button type="button" class="btn btn-primary">Add to List</button>
		</div>
		<div class="book-content right-column">
		<p>Year</p>
		<p>Genres</p>
		<p><c:out value="${book.description}"/></p>
		</div>
	</div>

</div>

</t:booksheader>
