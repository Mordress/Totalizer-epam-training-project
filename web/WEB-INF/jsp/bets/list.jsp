<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<fmt:setLocale value="ru"/>

<u:html title="ставки" message="${message}">
    <h1>Текущий баланс: ${cash}$
        <button>Пополнить</button>
    </h1>
    <h2>Завершенные ставки</h2>
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
            <c:if test="${not empty passedBets}">
                <c:forEach items="${passedBets}" var="pBet">
                    <tr>
                        <td>
                            <fmt:formatDate value="${pBet.horseRace.race.raceDate}" pattern="dd MMMM yyyy - HH:mm:ss"/>
                        </td>
                        <td>${pBet.horseRace.race.distance}</td>
                        <td>${pBet.horseRace.horse.name}</td>
                        <td>${pBet.horseRace.resultRank}</td>
                        <td>
                            <fmt:formatDate value="${pbet.horseRace.resultTime}" pattern="HH:mm:ss"/>
                        </td>
                        <td>${pBet.resultRank}</td>
                        <td>${pBet.betAmount}</td>
                        <td>${pBet.winAmount}</td>
                        <c:choose>
                            <c:when test="${not empty pBet.winAmount}">
                                <td>${pBet.isWinner}</td>
                            </c:when>
                            <c:otherwise>
                                <td></td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    <h2>Активные ставки</h2>
    <table>
        <tr>
            <th>Дата забега/время старта</th>
            <th>Дистанция(м)</th>
            <th>Лошадь</th>
            <th>Предполагаемое место</th>
            <th>Размер ставки</th>
            <th>Изменить</th>
        </tr>
        <c:if test="${not empty futureBets}">
            <c:forEach items="${futureBets}" var="fBet">
                <tr>
                    <td>
                        <fmt:formatDate value="${fBet.horseRace.race.raceDate}" pattern="dd MMMM yyyy - HH:mm:ss"/>
                    </td>
                    <td>${fBet.horseRace.race.distance}</td>
                    <td>${fBet.horseRace.horse.name}</td>
                    <td>${fBet.resultRank}</td>
                    <td>${fBet.betAmount}</td>
                    <td>
                        <c:url value="/bets/delete.html" var="betDeleteUrl"/>
                        <form action="${betDeleteUrl}" method="post">
                            <input type="hidden" name="id" value="${fBet.id}">
                            <input type="hidden" name="betAmount" value="${fBet.betAmount}">
                            <button type="submit">Удалить</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <c:url value="/bets/create.html" var="betsCreateUrl"/>
    <form action="${betsCreateUrl}" method="post">
        <button type="submit">Сделать ставку</button>
    </form>
</u:html>
