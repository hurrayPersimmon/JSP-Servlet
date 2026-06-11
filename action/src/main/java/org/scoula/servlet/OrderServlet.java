package org.scoula.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        String name = req.getParameter("name");
        String item = req.getParameter("item");

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<h2> GET 방식으로 주문됨</h2>");
        out.println("<ul><li>고객명: " + name + "</li><li>상품: " + item + "</li></ul>");
        out.println("<a href='orderForm.html'>돌아가기</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String item = req.getParameter("item");

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<h2> POST 방식으로 주문됨</h2>");
        out.println("<ul><li>고객명: " + name + "</li><li>상품: " + item + "</li></ul>");
        out.println("<a href='orderForm.html'>돌아가기</a>");
    }
}

