<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

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
		<p>		
		<c:out value="${book.rating}"/>
		<form action="ratebook" method="post">
		<select name="bookEvaluation">
			<option value="None">---SELECT---</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
		</select>
		<input type="hidden" name="id" value="${book.id}" >
		<button type="${contextPath}/books/submit">Rate</button>
		</form>
		</p>
		</div>
	</div>

</div>

</t:booksheader>
