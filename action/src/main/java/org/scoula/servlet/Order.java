package org.scoula.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/order")
public class Order extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("<html><head><title>주문 목록</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("</head><body class='container mt-5'>");

        out.println("<h2 class='mb-4'>주문 정보</h2>");
        out.println("<ul class='list-group'>");

        // 1. 단일 값
        String name = req.getParameter("customerName");
        out.println("<li class='list-group-item'><strong>고객명:</strong> " + name + "</li>");

        // 2. 복수 값
        String[] products = req.getParameterValues("product");
        out.print("<li class='list-group-item'><strong>주문 상품:</strong> ");
        if (products != null) {
            out.print(String.join(", ", products));
        } else {
            out.print("없음");
        }
        out.println("</li>");

        // 3. 배송 방법
        out.println("<li class='list-group-item'><strong>배송 방법:</strong> " + req.getParameter("delivery") + "</li>");

        // 4. 주소
        out.println("<li class='list-group-item'><strong>배송지:</strong> " + req.getParameter("address") + "</li>");

        // 5. 전체 파라미터 이름 + 값 출력
        out.println("<li class='list-group-item'><strong>전체 파라미터 목록:</strong><ul>");
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            String param = names.nextElement();
            String[] values = req.getParameterValues(param);
            out.println("<li>" + param + " = " + String.join(", ", values) + "</li>");
        }
        out.println("</ul></li>");

        out.println("</ul>");
        out.println("<a href='order.html' class='btn btn-primary mt-3'>다시 주문</a>");
        out.println("</body></html>");
    }
}

