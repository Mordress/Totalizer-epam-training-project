<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<fmt:setLocale value="ru"/>

<u:html title="результаты забега" message="${message}">
    <c:url value="/horseraces/resultedit.html" var="resultEditUrl"/>
    <table>
        <tr>
            <th>Дата забега/Время старта</th>
            <th>Дистанция(м)</th>
            <th>Имя лошади</th>
            <th>Место</th>
            <th>Время финиша</th>
            <th>Результат</th>
        </tr>
            <c:forEach items="${horseRaces}" var="hRace">
                <c:set var="id" value="${hRace.id}"/>
                <c:set var="date" value="${hRace.race.raceDate}"/>
                <c:set var="distance" value="${hRace.race.distance}"/>
                <c:set var="horsename" value="${hRace.horse.name}"/>
                <c:set var="resultRank" value="${hRace.resultRank}"/>
                <c:set var="resultTime" value="${hRace.resultTime}"/>
                <tr>
                    <td>
                        <fmt:formatDate value="${date}" pattern="dd MMMM yyyy - HH:mm:ss"/>
                    </td>
                    <td>${distance}</td>
                    <td>${horsename}</td>
                    <td>${resultRank}</td>
                    <td>
                        <fmt:formatDate value="${resultTime}" pattern="HH:mm:ss"/>
                    </td>
                    <td>
                        <form action="${resultEditUrl}" method="post">
                            <input type="hidden" name="id" value="${hRace.id}">
                            <button type="submit">Изменить результат</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        <tr>
            <td colspan="6">
                <form action="/races/list.html" method="post">
                    <button type="submit">Вернуться</button>
                </form>
            </td>
        </tr>
    </table>
</u:html>
