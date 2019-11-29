package com.sys.controller;

import com.sys.entity.User;
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
 * @create 2019/11/26 19:11
 * @Description
 */
@WebServlet("/toUpdate")
public class UserToUpdateServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        User user = userService.getById(Integer.valueOf(id));

        request.setAttribute("user",user);
        request.getRequestDispatcher("/userUpdate.jsp").forward(request,response);
    }
}
