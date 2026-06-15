package org.scoula.ex05;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String password = request.getParameter("passwd");

        request.setAttribute("userid", userid);
        request.setAttribute("passwd", password);

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
