package org.scoula.servletcore;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionDetails")
public class SessionDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // 세션 ID 출력
        String sessionId = session.getId();
        response.getWriter().println("Session ID: " + sessionId);

        // 세션 생성 시간 출력
        long creationTime = session.getCreationTime();
        response.getWriter().println("Creation Time: " + new Date(creationTime));

        // 마지막 접근 시간 출력
        long lastAccessedTime = session.getLastAccessedTime();
        response.getWriter().println("Last Accessed Time: " + new Date(lastAccessedTime));

        // 세션의 최대 비활성 시간 설정 및 출력
        session.setMaxInactiveInterval(1800); // 30분
        int maxInactiveInterval = session.getMaxInactiveInterval();
        response.getWriter().println("Max Inactive Interval: " + maxInactiveInterval + " seconds");

        // 세션이 새로 생성된 것인지 여부 출력
        boolean isNew = session.isNew();
        response.getWriter().println("Is New Session: " + isNew);

        // 세션에 속성 저장
        session.setAttribute("username", "JohnDoe");
        session.setAttribute("email", "john.doe@example.com");

        // 세션 속성 출력
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            response.getWriter().println("Attribute Name: " + name + ", Value: " + session.getAttribute(name));
        }

        // 특정 속성 제거
        session.removeAttribute("username");

        // 세션 무효화
        session.invalidate();
    }
}
