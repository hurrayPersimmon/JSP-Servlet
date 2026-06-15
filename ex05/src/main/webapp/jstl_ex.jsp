<%--
  Created by IntelliJ IDEA.
  User: hurray
  Date: 2026. 6. 11.
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSTL 테스트</h1>
<c:if test="${role == 'ADMIN'}">admin</c:if>
<c:if test="${role != 'ADMIN'}">normal</c:if>
<table >
  <tr>
    <c:forEach var="member" items="${members}" varStatus="state">
    <td>${state.index}</td>
    <td>${member.name}</td>
    <td>${member.userid}</td>
  </tr>
  </c:forEach>
</table>
<br>
<br>
${today}<br>
<fmt:formatDate value="${today}" type="date"/><br>
<fmt:formatDate value="${today}" type="time"/><br>
<fmt:formatDate value="${today}" type="both"/><br>
<fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long"/><br>
<fmt:formatDate value="${today}" type="both" dateStyle="long" timeStyle="short"/><br>
<fmt:formatDate value="${today}" pattern="YYYY-MM-dd HH:mm:ss"/><br>
<fmt:formatDate value="${today}" pattern="YYYY-MM-dd a hh:mm:ss"/><br>

</body>
</html>
