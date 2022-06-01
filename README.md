Java8 + Maven + Selenide + Junit + Allure 

Тестирование функционала Jira:
Авторизация;
Проверка общего количества задач и поиск задачи TestSelenium с проверкой статуса, версии;
Создание новой задачи и полное заполнение всех ее полей;
Изменение статуса задачи.

#Входные данные
задаются в файле application.properties

#Запуск всех тестов
mvn clean test

#Запуск тестов по тегам
mvn clean test -Dgroups=1

#Построение отчета Allure
mvn allure:serve


