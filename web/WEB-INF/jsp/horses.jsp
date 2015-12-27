<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>
<fmt:setLocale value="ru"/>

<u:html title="лошади" message="${message}">
    <h2>Доступные лошади</h2>
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
