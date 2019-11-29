package com.sys.controller;

import com.sys.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lrbin
 * @version 1.0.0
 * @company
 * @create 2019/11/26 18:15
 * @Description
 */
@WebServlet("/delete")
public class UserDeleteServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null) {
            return;
        }
        userService.deleteById(Integer.valueOf(id));
        response.sendRedirect("/list");
    }
}
