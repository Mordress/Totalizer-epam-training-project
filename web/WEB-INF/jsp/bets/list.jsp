<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<fmt:setLocale value="ru"/>

<u:html title="ставки" message="${message}">
    <h2>Cтавки</h2>
        <table>
            <tr>
                <th>Дата забега/время старта</th>
                <th>Дистанция(м)</th>
                <th>Лошадь</th>
                <th>Место</th>
                <th>Время финиша</th>
                <th>Предполагаемое место</th>
                <th>Размер ставки</th>
                <th>Размер выигрыша</th>
                <th>Победа?</th>
            </tr>
            <c:if test="${not empty bets}">
                <c:forEach items="${bets}" var="bet">
                    <tr>
                        <td>
                            <fmt:formatDate value="${bet.horseRace.race.raceDate}" pattern="dd MMMM yyyy - HH:mm:ss"/>
                        </td>
                        <td>${bet.horseRace.race.distance}</td>
                        <td>${bet.horseRace.horse.name}</td>
                        <td>${bet.horseRace.resultRank}</td>
                        <td>
                            <fmt:formatDate value="${bet.horseRace.resultTime}" pattern="HH:mm:ss"/>
                        </td>
                        <td>${bet.resultRank}</td>
                        <td>${bet.betAmount}</td>
                        <td>${bet.winAmount}</td>
                        <c:choose>
                            <c:when test="${not empty bet.winAmount}">
                                <td>${bet.isWinner}</td>
                            </c:when>
                            <c:when test="${empty bet.winAmount}">
                                <td></td>
                            </c:when>
                        </c:choose>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    <c:url value="/bets/create.html" var="betsCreateUrl"/>
    <form action="${betsCreateUrl}" method="post">
        <button type="submit">Сделать ставку</button>
    </form>
</u:html>
