package org.scoula.ex06;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.scoula.ex06.command.Command;

public class DispatcherServlet extends HttpServlet {
    Map<String, Command> getMap;
    Map<String, Command> postMap;
    String prefix = "/views/";
    String suffix = ".jsp";
    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();
        createMap(getMap, postMap);
    }

    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {

    }

    private String getCommandName(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        return requestURI.substring(contextPath.length());
    }

    private Command getCommand(HttpServletRequest req) {
        String commandName = getCommandName(req);
        Command command;
        if(req.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
        } else {
            command = postMap.get(commandName);
        }
        return command;
    }

    public void execute(Command command, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String viewName = command.execute(req, resp);
        if(viewName.startsWith("redirect:")) {
            resp.sendRedirect(viewName.substring("redirect:".length()));
        } else {
            String view = prefix + viewName + suffix;
            RequestDispatcher dis = req.getRequestDispatcher(view);
            dis.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = getCommand(req);
        if(command != null) {
            execute(command, req, resp);
        }else{
            String requestUrl = req.getRequestURI();
            req.setAttribute("requestUrl", requestUrl);

            String view = prefix + "404" + suffix;
            RequestDispatcher dis = req.getRequestDispatcher(view);
            dis.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
