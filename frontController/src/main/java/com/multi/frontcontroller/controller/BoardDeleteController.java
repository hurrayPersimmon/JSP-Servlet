package com.multi.frontcontroller.controller;

import com.multi.frontcontroller.dao.BoardDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteController implements Controller {
    public String handle(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            BoardDAO dao = new BoardDAO();
            dao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}