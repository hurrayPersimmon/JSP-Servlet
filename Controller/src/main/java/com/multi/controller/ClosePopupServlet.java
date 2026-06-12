package com.multi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/closePopup")
public class ClosePopupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String dontShowToday = request.getParameter("dontShowToday");

        if (dontShowToday != null) {
            Cookie cookie = new Cookie("popupCookie", "done");

            // 오늘 하루 유지
            cookie.setMaxAge(60 * 60 * 24);

            // 현재 프로젝트 전체에서 사용 가능
            cookie.setPath(request.getContextPath());

            response.addCookie(cookie);
        }

        PrintWriter out = response.getWriter();

        out.println("<script>");
        out.println("window.close();");
        out.println("</script>");
    }
}