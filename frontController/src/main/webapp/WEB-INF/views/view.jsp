<%--
  Created by IntelliJ IDEA.
  User: hurray
  Date: 2026. 6. 12.
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="common/header.jsp" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<div class="container mt-4">
  <h2>${dto.title}</h2>
  <p class="lead">${dto.content}</p>
  <p>작성자: ${dto.writer}</p>
  <p>등록일: ${dto.regdate}</p>

  <a href="editForm.do?id=${dto.id}" class="btn btn-warning">수정</a>
  <a href="delete.do?id=${dto.id}" class="btn btn-danger" onclick="return confirm('정말 삭제할까요?')">삭제</a>
  <a href="list.do" class="btn btn-secondary">목록</a>
</div>

<%@ include file="common/footer.jsp" %>