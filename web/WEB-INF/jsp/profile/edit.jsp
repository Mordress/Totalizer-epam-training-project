<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<u:html title="редактирование профиля" message="${message}">
    <c:if test="${not empty message}"><H4>${message}</H4></c:if>
    <c:url value="/profile/save.html" var="profileSaveUrl"/>
    <form action="${profileSaveUrl}" method="post">
        <label for="login">Имя пользователя:</label>
        <input type="text" id="login" value="${authorizedUser.login}" disabled>
        <label for="role">Роль:</label>
        <select id="role" disabled>
            <option selected>${authorizedUser.role.name}</option>
        </select>
        <label for="old-password">Старый пароль:</label>
        <input type="password" id="old-password" name="old-password">
        <label for="new-password">Новый пароль:</label>
        <input type="password" id="new-password" name="new-password">
        <label for="confirm-password">Подтверждение:</label>
        <input type="password" id="confirm-password" name="confirm-password">
        <button type="submit">Сменить пароль</button>
        <button type="reset">Сбросить</button>
    </form>
</u:html>
