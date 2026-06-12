package com.multi.frontcontroller.controller;

import com.multi.frontcontroller.dao.BoardDAO;
import com.multi.frontcontroller.dto.BoardDTO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardEditController implements Controller {
    public String handle(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            BoardDTO dto = new BoardDTO();
            dto.setId(Integer.parseInt(request.getParameter("id")));
            dto.setTitle(request.getParameter("title"));
            dto.setContent(request.getParameter("content"));
            dto.setWriter(request.getParameter("writer"));

            BoardDAO dao = new BoardDAO();
            dao.update(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
