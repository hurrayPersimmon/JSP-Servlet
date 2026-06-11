<%--
  Created by IntelliJ IDEA.
  User: hurray
  Date: 2026. 6. 11.
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>입력 결과</title>
</head>
<body>

<h1>입력 결과</h1>

<p>이름: ${username}</p>
<p>메시지: ${message}</p>

<p>
  <a href="${pageContext.request.contextPath}/index.jsp">
    다시 입력
  </a>
</p>

</body>
</html>
