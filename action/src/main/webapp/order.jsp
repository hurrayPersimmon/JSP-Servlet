<%--
  Created by IntelliJ IDEA.
  User: hurray
  Date: 2026. 6. 10.
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
```java
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>물건 주문</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<header class="bg-primary text-white text-center p-3">
    <h1>상품 주문 페이지</h1>
</header>

<main class="container mt-4">
    <form action="order" method="post">
        <div class="mb-3">
            <label for="customerName" class="form-label">고객명</label>
            <input type="text" class="form-control" id="customerName" name="customerName" required>
        </div>

        <div class="mb-3">
            <label class="form-label">상품 선택</label><br>
            <input type="checkbox" name="product" value="노트북"> 노트북
            <input type="checkbox" name="product" value="마우스"> 마우스
            <input type="checkbox" name="product" value="키보드"> 키보드
        </div>

        <div class="mb-3">
            <label class="form-label">배송 방법</label><br>
            <input type="radio" name="delivery" value="일반배송" checked> 일반배송
            <input type="radio" name="delivery" value="빠른배송"> 빠른배송
        </div>

        <div class="mb-3">
            <label for="address" class="form-label">주소</label>
            <input type="text" class="form-control" id="address" name="address" required>
        </div>

        <button type="submit" class="btn btn-success">주문하기</button>
    </form>
</main>

<footer class="bg-dark text-white text-center p-3 mt-4">
    &copy; 2025 주문 시스템
</footer>
</body>
</html>

```