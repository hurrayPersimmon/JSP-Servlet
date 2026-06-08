package org.scoula.servletactionfirst;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "actionServlet", value = "/action-servlet")
public class ActionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String bgcolor = request.getParameter("bgcolor");
        String name = request.getParameter("name");
        if (bgcolor == null) {
            bgcolor = "skyblue";
        }

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body bgcolor='" + bgcolor + "'>");
        out.println("<h1>"+name+"&nbsp;fighting</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
