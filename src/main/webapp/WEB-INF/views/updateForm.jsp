<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<t:layout title="Edit Idea">
     <h1 class="text-center text-uppercase">Edit Idea</h1>
     <div class="jumbotron">
        <form:form id="formCreate" modelAttribute="newIdea" method="post" action="submitUpdate">
             <div class="form-group">
                 <label for="captionId">Название</label>
                 <form:input path="caption" id="captionId" cssClass="form-control"/>
                 </div>
         </form:form>
 
     </div>
     </t:layout>