package com.sys.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lrbin
 * @version 1.0.0
 * @company
 * @create 2019/11/28 18:39
 * @Description
 */
//@WebFilter("/*")
public class SysFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        // 不拦截登陆页面和登陆请求
        if (uri.endsWith("index.jsp") || uri.endsWith("login")) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            Object obj = session.getAttribute("name");

            if (obj == null || !"admin".equals(obj.toString())) {
                //无session,就是非法登陆
                response.sendRedirect("/index.jsp");
            }
            filterChain.doFilter(request, response);
        }
    }
}
