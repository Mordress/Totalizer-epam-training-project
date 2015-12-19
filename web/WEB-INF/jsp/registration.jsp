<!DOCTYPE HTML>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Тотализатор - Вход</title>
  <link rel="stylesheet" type="text/css" href="/styles.css" media="all">
</head>
<body>
<div id="header">
  <H1>Тотализатор</H1>
</div>
<div id="page">
    <c:url value="/regsave.html" var="registrationSave"/>
    <FORM action="${registrationSave}" method="post" >
        <table>
            <tr>
                <th colspan="2">Данные пользователя</th>
            </tr>
            <tr>
                <td>Логин</td>
                <td>
                    <input type="text" name="login" id="login" placeholder="не более 30 символов" maxlength="30">
                </td>
            </tr>
            <tr>
                <td>Пароль</td>
                <td>
                    <input type="password" name="password" id="password" placeholder="не более 30 символов" maxlength="30">
                    <input type="password" name="confpassword" id="confpassword" placeholder="подтверждение" maxlength="30">
                </td>
            </tr>
            <tr>
                <td>Имя</td>
                <td>
                    <input type="text" name="firstname" id="firstname" placeholder="не более 30 символов" maxlength="30">
                </td>
            </tr>
            <tr>
                <td>Фамилия</td>
                <td>
                    <input type="text" name="lastname" id="lastname" placeholder="не более 30 символов" maxlength="30">
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <input type="email" name="email" id="email" placeholder="не более 30 символов" maxlength="30">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Зарегистрироваться</button>
                </td>
            </tr>
        </table>
    </FORM>
</div>
it's registration page
</body>
</html>
