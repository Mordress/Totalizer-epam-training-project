<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<fmt:setLocale value="ru"/>

<u:html title="забеги" message="${message}">
    <h2>Состоявшиеся забеги</h2>
    <table>
        <tr>
            <th>Дата забега</th>
            <th>Дистанция (м)</th>
            <th>Результаты</th>
        </tr>
        <c:url value="/horseraces/edit.html" var="horseRacesEditUrl"/>
        <c:forEach items="${passedRaces}" var="pRace">
            <tr>
                <td>
                    <fmt:formatDate value="${pRace.raceDate}" pattern="dd MMMM yyyy - HH:mm"/>
                </td>
                <td>${pRace.distance}</td>
                <td>
                    <form action="${horseRacesEditUrl}" method="post">
                        <input type="hidden" name="id" value="${pRace.id}">
                        <button type="submit">Результаты</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h2>Будущие забеги</h2>
    <table>
        <tr>
            <th>Дата забега</th>
            <th>Дистанция(м)</th>
            <th>Редактирование</th>
        </tr>
        <c:forEach items="${futureRaces}" var="fRace">
            <tr>
                <td>
                    <fmt:formatDate value="${fRace.raceDate}" pattern="dd MMMM yyyy - HH:mm"/>
                </td>
                <td>${fRace.distance}</td>
                <td>
                    <c:url value="/races/delete.html" var="raceDeleteUrl"/>
                    <form action="${raceDeleteUrl}" method="post">
                        <input type="hidden" name="id" value="${fRace.id}">
                        <button type="submit">Удалить</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <c:url value="/races/edit.html" var="raceEditUrl"/>
    <form action="${raceEditUrl}" method="post">
        <button type="submit">Добавить забег</button>
    </form>
</u:html>
