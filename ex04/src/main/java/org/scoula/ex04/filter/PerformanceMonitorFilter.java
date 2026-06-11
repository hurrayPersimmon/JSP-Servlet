package org.scoula.ex04.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class PerformanceMonitorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("PerformanceMonitorFilter init");
    }

    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        long start = System.currentTimeMillis();

        chain.doFilter(request, response);

        long end = System.currentTimeMillis();
        long elapsedTime = end - start;

        System.out.println(
            "[" + start + "] " +
                req.getRequestURI() +
                " - " +
                elapsedTime +
                " 소요."
        );
    }

    @Override
    public void destroy() {
        System.out.println("PerformanceMonitorFilter destroy");
    }
}