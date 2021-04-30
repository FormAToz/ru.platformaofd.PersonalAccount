<%@ page contentType='text/html; charset=UTF-8' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="header">
  <div style="text-align: center">

     <c:if test="${principal == null}">
         <h1>Личный кабинет пользователей</h1>
     </c:if>
     <c:if test="${principal != null}">
         <h1>Личный кабинет пользователя "${principal.getName()}"</h1>
     </c:if>

  </div>
</div>