<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<u:html title="регистрация" message="${message}">
    <c:url value="/regsave.html" var="registrationSave"/>
    <form action="${registrationSave}" method="post" >
        <label for="login">Имя пользователя(login)</label>
        <input type="text" name="login" id="login" maxlength="30">

        <label for="password">Пароль</label>
        <input type="password" name="password" id="password" maxlength="30">

        <label for="confpassword">Подтверждение пароля</label>
        <input type="password" name="confpassword" id="confpassword" maxlength="30">

        <label for="firstname">Ваше имя</label>
        <input type="text" name="firstname" id="firstname" maxlength="30">

        <label for="lastname">Ваша Фамилия</label>
        <input type="text" name="lastname" id="lastname" maxlength="30">

        <label for="email">Email</label>
        <input type="email" name="email" id="email" maxlength="30">
        <br>
        <button type="submit">Зарегистрироваться</button>
    </form>
</u:html>
