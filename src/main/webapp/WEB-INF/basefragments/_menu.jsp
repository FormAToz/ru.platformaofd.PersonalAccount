<%@ page contentType='text/html; charset=UTF-8' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="padding: 5px;">

   <ul>

       <li><a href="${pageContext.request.contextPath}/">Главная</a></li>

       <c:if test="${principal == null}">
            <li><a href="${pageContext.request.contextPath}/registration">Регистрация</a></li>
            <li><a href="${pageContext.request.contextPath}/login">Войти</a></li>
       </c:if>

       <c:if test="${principal != null}">
            <li><a href="${pageContext.request.contextPath}/users/logout">Выйти</a></li>
            <li><a href="${pageContext.request.contextPath}/users/details">Детализация</a></li>
       </c:if>

   </ul>

</div>