# Личный кабинет пользователей


## Функционал

Минимальная реализация личного кабинета пользователей: регистрация, авторизация, отображение и изменение баланса


## Стэк

| **Описание** | **Технологии и версии** |
|---|----|
| **Версия JDK** | **8** |
| **Порт** | **8080** |
| **Сборщик проекта** | **Maven**|
| **Система контроля версий** | **git** |
| **Spring** | **MVC (4.3.3.RELEASE)** |
| **База данных** | **-**|
| **Apache Tiles** | **3.0.7** |


## Запуск проекта

Для запуска проекта в IntelliJ Idea Community Edition необходимо установить сервер Tomcat https://tomcat.apache.org/download-80.cgi 
и плагин Smart Tomcat https://plugins.jetbrains.com/plugin/9492-smart-tomcat. 

Далее:  Edit Configurations -> Add New Configuration -> Smart Tomcat.
Необходимо заполнить поля:
-  **```Tomcat Server```** - выбрать папку с установленным Tomcat-сервером
-  **```Deployment Directory```** - путь до папки "webapp" в проекте
-  **```Context Path```** - /

Приложение будет доступно по адресу http://localhost:8080