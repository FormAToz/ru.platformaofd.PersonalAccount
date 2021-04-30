<%@ page contentType='text/html; charset=UTF-8' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/users/login" method="post">
  <div>
    <h2>Пожалуйста, заполните поля для входа:</h2>

    <hr>
    <label for="login"><b>Логин</b></label>
    <input type="text" placeholder="Введите логин" name="login" required>

    <label for="password"><b>Пароль</b></label>
    <input type="password" placeholder="Введите пароль" name="password" required>
    <hr>

    <button type="submit">Вход</button>
  </div>
</form>