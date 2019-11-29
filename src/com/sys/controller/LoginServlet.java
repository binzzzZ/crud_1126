package com.sys.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author lrbin
 * @version 1.0.0
 * @company
 * @create 2019/11/26 17:55
 * @Description
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        if ("admin".equals(username)) {
            HttpSession session = request.getSession();
            session.setAttribute("name", username);
            session.setMaxInactiveInterval(30 * 60);

            request.getRequestDispatcher("/list").forward(request, response);
        } else {
            response.sendRedirect("/index.jsp");
        }
    }
}
