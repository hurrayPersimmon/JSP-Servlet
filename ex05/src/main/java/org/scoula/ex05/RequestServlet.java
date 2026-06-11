package org.scoula.ex05;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username", "hurray");
        request.setAttribute("useraddress","seoul");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/res.jsp");
        dispatcher.forward(request, response);
    }

}
