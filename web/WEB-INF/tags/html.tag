<%@ tag import="java.util.Date" %>
<%@ tag import="com.gmail.mordress.epamproject.utils.DateFormatConverter" %>
<!DOCTYPE html>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" rtexprvalue="true" type="java.lang.String"%>
<%@attribute name="message" required="false" rtexprvalue="true" type="java.lang.String"%>
<%@attribute name="validator" required="false" rtexprvalue="true" type="java.lang.String"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="u"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Тотализатор - ${title}</title>
        <link rel="stylesheet" type="text/css" href="/styles.css" media="all">
        <c:url value="/js" var="javascriptUrl"/>
        <script type="text/javascript" src="${javascriptUrl}/main.js"></script>
        <c:if test="${not empty message}">
            <script type="text/javascript">
                startMessage = "${message}";
            </script>
        </c:if>
        <c:if test="${not empty validator}">
            <script type="text/javascript" src="${javascriptUrl}/validator.js"></script>
            <script type="text/javascript" src="${javascriptUrl}/${validator}"></script>
        </c:if>
    </head>
<body>
    <u:menu/>
    <div id="page">
        <jsp:doBody/>
    </div>
</body>
</html>