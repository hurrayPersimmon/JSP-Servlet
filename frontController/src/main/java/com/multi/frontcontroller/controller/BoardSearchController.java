package com.multi.frontcontroller.controller;

import com.multi.frontcontroller.dao.BoardDAO;
import com.multi.frontcontroller.dto.BoardDTO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardSearchController implements Controller {
    public String handle(HttpServletRequest request, HttpServletResponse response) {
        try {
            String keyword = request.getParameter("keyword");
            BoardDAO dao = new BoardDAO();
            List<BoardDTO> list = dao.search(keyword);
            request.setAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list";
    }
}