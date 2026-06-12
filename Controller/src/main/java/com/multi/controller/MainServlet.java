package com.multi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();

        String loginId = (String) session.getAttribute("loginId");

        if (loginId == null) {
            response.sendRedirect(request.getContextPath() + "/loginPage");
            return;
        }

        boolean popupOpen = true;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("popupCookie".equals(cookie.getName())) {
                    if ("done".equals(cookie.getValue())) {
                        popupOpen = false;
                    }
                    break;
                }
            }
        }

        request.setAttribute("loginId", loginId);
        request.setAttribute("popupOpen", popupOpen);

        request.getRequestDispatcher("/cookie/main.jsp").forward(request, response);
    }
}