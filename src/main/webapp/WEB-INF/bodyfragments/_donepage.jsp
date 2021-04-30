<%@ page contentType='text/html; charset=UTF-8' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2><c:out value="${response.getMessage()} - код ${response.getCode().getCode()} (${response.getCode().name()})" /></h2>