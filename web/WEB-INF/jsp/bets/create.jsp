<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<fmt:setLocale value="ru"/>

<u:html title="создание ставки" message="${message}" validator="validator-of-bet-create.js">
    <h1>Текущий баланс: ${cash}$
        <button>Пополнить</button>
    </h1>
    <h2>Введите данные ставки</h2>
    <br>
    <div id="bet">
        <c:url value="/bets/newsave.html" var="betsNewSave"/>
        <form action="${betsNewSave}" method="post" onsubmit="return validateBetCreate(this)">
            <label for="chosenRaceId">Выберите дату и время забега:</label>
            <select name="chosenRaceId" id="chosenRaceId" required="required">
                <option selected="" value = "">не выбрано</option>
                <c:forEach items="${futureRaces}" var="fRace">
                    <option value = "${fRace.id}">
                        <fmt:formatDate value="${fRace.raceDate}" pattern="dd MMMM yyyy - HH:mm:ss"/>
                    </option>
                </c:forEach>
            </select>
            <label for="chosenHorseId">Выберите лошадь:</label>
            <select name="chosenHorseId" id="chosenHorseId" required="required">
                <option selected="" value = "">не выбрана</option>
                <c:forEach items="${allHorses}" var="horse">
                    <option value = "${horse.id}">${horse.name}</option>
                </c:forEach>
            </select>
            <label for="betAmount">Размер ставки($):</label>
            <input type="number" min="10" max="${cash}" id="betAmount" name="betAmount" placeholder=">10$"/>
            <label for="rank">Предполагаемое место:</label>
            <input type="number" min="1" max="${horseCount}" id="rank" name="rank" placeholder="1-${horseCount}"/>
            <br>
            <button type="submit">Сделать ставку</button>
            <button type="reset">Сбросить</button>
        </form>
    </div>
    <br>
    <br>
    <br>
    <h3>Доступные лошади</h3>
    <table>
        <tr>
            <th>Имя</th>
            <th>Порода</th>
            <th>Возраст (лет)</th>
            <th>Вес (кг)</th>
        </tr>
        <c:forEach items="${allHorses}" var="horse">
            <tr>
                <td>${horse.name}</td>
                <td>${horse.breed.name}</td>
                <td>${horse.age}</td>
                <td>${horse.weight}</td>
            </tr>
        </c:forEach>
    </table>
</u:html>
