<%@ page contentType='text/html; charset=UTF-8' %>

<form action="/users/register" method="post">
  <div>
    <h1>Регистрация</h1>
    <p>Пожалуйста, заполните поля для создания нового аккаунта:</p>

    <hr>
    <label for="login"><b>Логин</b></label>
    <input type="text" placeholder="Введите логин" name="login" required>

    <label for="psw"><b>Пароль</b></label>
    <input type="password" placeholder="Введите пароль" name="password" required>
    <hr>

    <button type="submit">Регистрация</button>
  </div>

  <div>
    <p>Есть аккаунт? <a href="${pageContext.request.contextPath}/login">Войти</a>.</p>
  </div>
</form>