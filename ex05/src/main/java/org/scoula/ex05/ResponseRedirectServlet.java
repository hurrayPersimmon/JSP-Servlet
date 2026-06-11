package org.scoula.ex05;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/response_redirect")
public class ResponseRedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = (String) req.getAttribute("username");
        String useraddress = (String) req.getAttribute("useraddress");
        req.setAttribute("username", username);
        req.setAttribute("useraddress", useraddress);
        RequestDispatcher dis = req.getRequestDispatcher("/redirect_res.jsp");
        dis.forward(req, res);
    }
}