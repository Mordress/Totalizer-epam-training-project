<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<fmt:setLocale value="ru"/>

<u:html title="ставки" message="${message}" validator="validator-of-bet-fix.js">
    <c:if test="${empty nofixbets}">
        <h2>На данный момент все ставки по завершенным забегам обработаны</h2>
    </c:if>
    <c:if test="${not empty nofixbets}">
        <h3>Необработанные ставки</h3>
        <table>
            <tr>
                <th>Дата забега</th>
                <th>Дата ставки</th>
                <th>Имя лошади</th>
                <th>Факт. место</th>
                <th>Предп. место</th>
                <th>Ставка($)</th>
                <th>Выигрыш($)</th>
                <th>Победил?</th>
                <th>Результат</th>
            </tr>
            <c:forEach items="${nofixbets}" var="bet">
                <tr>
                    <c:url value="/bets/fixsave.html" var="fixSaveUrl"/>
                    <form action="${fixSaveUrl}" method="post" onsubmit="return validateBetFix(this)">
                        <input type="hidden" name="betId" value="${bet.id}">
                        <td>
                            <fmt:formatDate value="${bet.horseRace.race.raceDate}" pattern="dd MMMM yyyy - HH:mm:ss"/>
                        </td>
                        <td>
                            <fmt:formatDate value="${bet.createdDate}" pattern="dd MMMM yyyy - HH:mm:ss"/>
                        </td>
                        <td>${bet.horseRace.horse.name}</td>
                        <td>${bet.horseRace.resultRank}</td>
                        <td>${bet.resultRank}</td>
                        <td>${bet.betAmount}</td>
                        <td>
                            <input type="number" min="${bet.betAmount}" id="winamount" name="winamount" placeholder="$">
                        </td>
                        <td>
                            <select name="iswinner" required="required">
                                <option selected="" value = "">не выбрано</option>
                                <option value = "yes">Да</option>
                                <option value = "no">Нет</option>
                            </select>
                        </td>
                        <td>
                            <button type="submit">Сохранить</button>
                        </td>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</u:html>
