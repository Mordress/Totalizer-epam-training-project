<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<fmt:setLocale value="ru"/>

<u:html title="редактирование результатов забега" message="${message}" validator="validator-of-horserace-edit.js">
    <table>
        <tr>
            <th>Дата забега/Время старта</th>
            <th>Дистанции(м)</th>
            <th>Имя лошади</th>
            <th>Место</th>
            <th>Времени в забеге</th>
        </tr>
        <tr>
            <td>
                <fmt:formatDate value="${horseRace.race.raceDate}" pattern="dd MMMM yyyy - HH:mm:ss"/>
            </td>
            <td>${horseRace.race.distance}</td>
            <td>${horseRace.horse.name}</td>
            <td>${horseRace.resultRank}</td>
            <td>
                <fmt:formatDate value="${horseRace.resultTime}" pattern="HH:mm:ss"/>
            </td>
        </tr>
        <c:url value="/horseraces/resultsave.html" var="resultSaveUrl"/>
        <form action="${resultSaveUrl}" method="post" onsubmit="return validateHorseRaceEdit(this)">
            <input type="hidden" name="horseRaceId" value="${horseRace.id}">
            <tr>
                <td colspan="3">
                    Введите результаты:
                </td>
                <td>
                    <input type="number" id="newRank" name="newRank" min="1" max="10" required="required"/>
                </td>
                <td>
                    <input type="number" min="0" max="23" id="newTimeHours" name="newTimeHours" required="required" placeholder="чч"/>
                    <input type="number" min="0" max="59" id="newTimeMinutes" name="newTimeMinutes" required="required" placeholder="мм"/>
                    <input type="number" min="0" max="59" id="newTimeSeconds" name="newTimeSeconds" required="required" placeholder="сс"/>
                </td>
            </tr>
            <tr>
                <td colspan="5">
                    <button type="submit">Сохранить</button>
                    <button type="reset">Сбросить</button>
                </td>
            </tr>
        </form>
    </table>
</u:html>
