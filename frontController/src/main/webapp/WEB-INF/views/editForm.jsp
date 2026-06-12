<%--
  Created by IntelliJ IDEA.
  User: hurray
  Date: 2026. 6. 12.
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <titlev><%@ page contentType="text/html;charset=UTF-8" %>
      <%@ include file="common/header.jsp" %>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

      <div class="container mt-4">
        <h2>글 수정</h2>
        <form action="edit.do" method="post">
          <input type="hidden" name="id" value="${dto.id}">
          <div class="mb-3">
            <label>제목</label>
            <input type="text" name="title" class="form-control" value="${dto.title}">
          </div>
          <div class="mb-3">
            <label>내용</label>
            <textarea name="content" class="form-control" rows="5">${dto.content}</textarea>
          </div>
          <div class="mb-3">
            <label>작성자</label>
            <input type="text" name="writer" class="form-control" value="${dto.writer}">
          </div>
          <button type="submit" class="btn btn-success">수정</button>
          <a href="view.do?id=${dto.id}" class="btn btn-secondary">취소</a>
        </form>
      </div>

      <%@ include file="common/footer.jsp" %>

      /title>
</head>
<body>

</body>
</html>
