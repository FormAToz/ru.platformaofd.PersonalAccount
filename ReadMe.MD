# Личный кабинет пользователей


## Функционал

Минимальная реализация личного кабинета пользователей: регистрация, авторизация, отображение и изменение баланса.
В случае возникновения ошибок - будет перенаправление на страницу с указанием кода и сообщением об ошибке.


## Стэк

| **Описание** | **Технологии и версии** |
|---|----|
| **Версия JDK** | **8** |
| **Порт** | **8080** |
| **Сборщик проекта** | **Maven**|
| **Система контроля версий** | **git** |
| **Spring** | **MVC (5.3.6), Security (5.3.9.RELEASE)** |
| **HSQLDB** | **2.6.0**|
| **Apache Tiles** | **3.0.7** |


## Запуск проекта

Для запуска проекта в IntelliJ Idea Community Edition необходимо установить сервер Tomcat https://tomcat.apache.org/download-80.cgi 
и плагин Smart Tomcat https://plugins.jetbrains.com/plugin/9492-smart-tomcat. 

Далее:  Edit Configurations -> Add New Configuration -> Smart Tomcat.

Необходимо заполнить поля:
-  **```Tomcat Server```** - выбрать папку с установленным Tomcat-сервером
-  **```Deployment Directory```** - путь до папки "webapp" в проекте

Приложение будет доступно по адресу http://localhost:8080


## Коды ответов

Овет передается в виде сообщения и кода:

-  **```0```** - все ОК
-  **```1```** - пользователь с таким логином уже существует
-  **```2```** - техническая ошибка
-  **```3```** - пользователя не существует
-  **```4```** - логин/пароль не верен


## Примечание 

В рамках задания не реализовано:

-  тесты
-  логи
-  все пользователи при регистрации получают роль USER (по умолчанию)
-  не использовал пагинацию при получении списка данных из базы