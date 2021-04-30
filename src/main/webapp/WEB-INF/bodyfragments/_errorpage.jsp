<%@ page contentType='text/html; charset=UTF-8' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Ошибка с кодом <c:out value="${ex.getCode()}" /></h2>

<p><c:out value="${ex.getMessage()}" />