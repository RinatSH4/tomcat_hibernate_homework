<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tomcat HOMEWORK</title>
</head>
<body>
    <h3> Добавление данных:</h3>
        <form action="check" method="post">
            <input type="text" placeholder="имя пользователя" name="username"><br>
            <input type="number" placeholder="возраст" name="age"><br>
            <button type="submit">Добавить</button>
        </form>
    <br>

    <h3> Редактирование: </h3>
        <form action="edit" method="post">
            <input type="number" placeholder="id пользователя" name="id"><br>
            <input type="text" placeholder="Новое имя" name="username"><br>
            <input type="number" placeholder="Возраст" name="age"><br>
            <button type="submit">Изменить</button>
        </form>
    <br>

    <h3> Найти данные о пользователе: </h3>
        <form action="find" method="post">
            <input type="text" placeholder="имя пользователя" name="username"><br>
            <button type="submit">Найти</button>
        </form>
    <br>

    <h3> Удалить по имени</h3>
    <form action="delete" method="post">
        <input type="text" placeholder="Имя" name="username"><br>
        <button type="submit">Удалить</button>
    </form>
    <br>
    <form action="all" method="post">
        <button type="submit">старше 10 и младше 35</button>
    </form>
    <br>
<br/>
</body>
</html>