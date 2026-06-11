package org.scoula.ex04.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class DecoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("DecoFilter init");
    }

    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        System.out.println(req.getRequestURI() + " ========>");

        chain.doFilter(request, response);

        System.out.println("<========");
    }

    @Override
    public void destroy() {
        System.out.println("DecoFilter destroy");
    }
}