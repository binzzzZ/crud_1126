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
 * @create 2019/11/26 18:55
 * @Description
 */
@WebServlet("/add")
public class UserAddServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String birthDate = request.getParameter("birthDate");

        User user = new User();
        user.setAccount(account);
        user.setName(name);
        user.setAge(Integer.valueOf(age));
        user.setSex(Integer.valueOf(sex));
        user.setBirthDate(birthDate);

        userService.addUser(user);
        response.sendRedirect("/list");
    }
}
