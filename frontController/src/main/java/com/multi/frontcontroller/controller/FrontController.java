package com.multi.frontcontroller.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

    private HashMap<String, Controller> map = new HashMap<>();

    @Override
    public void init() {
        map.put("/list.do", new BoardListController());
        map.put("/writeForm.do", new BoardWriteFormController());
        map.put("/write.do", new BoardWriteController());
        map.put("/view.do", new BoardViewController());
        map.put("/editForm.do", new BoardEditFormController());
        map.put("/edit.do", new BoardEditController());
        map.put("/delete.do", new BoardDeleteController());
        map.put("/search.do", new BoardSearchController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String uri = request.getRequestURI();
        String context = request.getContextPath();
        String command = uri.substring(context.length());

        Controller controller = map.get(command);
        if (controller != null) {
            String view = controller.handle(request, response);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/" + view + ".jsp");
            rd.forward(request, response);
        }
    }
}
