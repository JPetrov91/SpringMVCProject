<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@attribute name="title" type="java.lang.String" required="true"%>
<t:booksheader title="Admin Panel">
<ul class="nav nav-pills">
  <li class="nav-item">
    <a class="nav-link active" href="main">Main</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="users">Users</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="books">Books</a>
  </li>
</ul>
<div class="container">
    <jsp:doBody/>
</div>
</t:booksheader>

