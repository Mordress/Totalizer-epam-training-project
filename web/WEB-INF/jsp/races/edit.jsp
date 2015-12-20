<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<u:html title="создание нового забега" message="${message}">
    <c:url value="/races/save.html" var="racesSaveUrl"/>
    <form action="${racesSaveUrl}" method="post" >
        <%--TODO JS VALIDATION--%>
        <label for="date">Введите дату и время нового забега</label>
        <input type="datetime-local" id="date" name="date">
        <br>
        <label for="distance">Введите длину дистанции</label>
        <input type="number" id="distance" name="distance" min="100" max="10000">
        <br>
        <button type="submit">Сохранить</button>
        <button type="reset">Сбросить</button>
    </form>
</u:html>
