<%@ page contentType='text/html; charset=UTF-8' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p><strong>Баланс пользователя</strong></p>

<table class="table">
<thead>
  <tr>
    <th>Баланс</th>
    <th>Тип баланса</th>
    <th>Дата добавления баланса</th>
  </tr>
</thead>
<tbody>

    <c:forEach var="user" items="${users}">
       <tr>
           <td><c:out value="${user}" /></td>
           <td><c:out value="${user}" /></td>
           <td><c:out value="${user}" /></td>
       </tr>
    </c:forEach>

</tbody>
</table>