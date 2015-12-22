<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<u:html title="Вход" message="${message}">
    <h2>Вход</h2>
    <div id="login">
        <c:url value="/login.html" var="loginUrl"/>
        <form action="${loginUrl}" method="post">
            <label for="login">Логин</label>
            <input type="text" id="login" name="login" value="${param.login}" maxlength="30">
            <label for="password">Пароль</label>
            <input type="password" id="password" name="password" value="${param.password}">
            <br>
            <button type="submit">Войти</button>
        </form>
        <c:url value="/registration.html" var="registrationUrl"/>
        <form action="${registrationUrl}" method="post">
            <button type="submit">Регистрация</button>
        </form>
    </div>
</u:html>
