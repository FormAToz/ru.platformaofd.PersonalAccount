<%@ page contentType='text/html; charset=UTF-8' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p><strong>Баланс пользователя</strong></p>

<table class="table">
<thead>
  <tr>
    <th>Кол-во средств</th>
    <th>Тип баланса</th>
    <th>Дата добавления баланса</th>
  </tr>
</thead>
<tbody>

    <c:forEach var="balance" items="${user.getBalanceList()}">
       <tr>
           <td><c:out value="${balance.getCount()}" /></td>
           <td><c:out value="${balance.getType().name()}" /></td>
           <td><c:out value="${balance.getCreatedPretty()}" /></td>
       </tr>
    </c:forEach>

</tbody>
</table>

<hr>

<strong>Добавление нового баланса</strong>

<form action="/users/details" method="post">

<p>
<div>
  <label for="type">Выберите тип</label>
  <select id="balance_type" name="type" class="form-control">
        <c:forEach var="type" items="${types}">
            <option value="${type.name()}"><c:out value="${type.name()}" /></option>
        </c:forEach>
      </select>
</div>

<p>
<div>
  <label for="count">Количество средств</label>
  <input id="balance_count" name="count" type="number" placeholder="" required="">
</div>

<p>
<button type="submit">Добавить</button>

</form>
