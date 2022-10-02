package com.example.catalog.servlet;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * we use /* for every request that receive
 */

@WebFilter(filterName = "/*")
public class ParameterFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        request.getParameterMap().forEach((key, value) -> System.out.println(" request paramKey : " + key + "request paramValue : " + value[0]));
        chain.doFilter(request, response);
    }
}
