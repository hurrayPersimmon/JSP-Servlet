package com.multi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        String rememberId = request.getParameter("rememberId");

        if (rememberId != null) {
            Cookie cookie = new Cookie("saveId", userId);

            // 아이디 저장 쿠키 7일 유지
            //cookie.setMaxAge(60 * 60 * 24 * 7);
            cookie.setMaxAge(60);

            // 현재 프로젝트 전체에서 쿠키 사용
            cookie.setPath(request.getContextPath());

            response.addCookie(cookie);

        } else {
            Cookie cookie = new Cookie("saveId", "");

            // saveId 쿠키 삭제
            cookie.setMaxAge(0);

            // 생성할 때와 같은 path를 줘야 삭제된다.
            cookie.setPath(request.getContextPath());

            response.addCookie(cookie);
        }

        if ("admin".equals(userId) && "1234".equals(userPw)) {
            HttpSession session = request.getSession();
            session.setAttribute("loginId", userId);

            response.sendRedirect(request.getContextPath() + "/main");

        } else {
            response.sendRedirect(request.getContextPath() + "/loginPage");
        }
    }
}