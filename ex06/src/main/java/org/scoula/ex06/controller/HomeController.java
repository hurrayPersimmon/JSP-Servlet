package org.scoula.ex06.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {
    public String getIndex(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "index";
    }
}
