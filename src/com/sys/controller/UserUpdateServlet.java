package com.sys.controller;

import com.sys.entity.User;
import com.sys.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author lrbin
 * @version 1.0.0
 * @company
 * @create 2019/11/26 19:10
 * @Description
 */
@WebServlet("/update")
public class UserUpdateServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        String account = request.getParameter("account");
//        String name = request.getParameter("name");
//        String age = request.getParameter("age");
//        String sex = request.getParameter("sex");
//        String birthDate = request.getParameter("birthDate");

        User user = new User();
//        user.setId(Integer.valueOf(id));
//        user.setAccount(account);
//        user.setName(name);
//        user.setAge(Integer.valueOf(age));
//        user.setSex(Integer.valueOf(sex));
//        user.setBirthDate(birthDate);

        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        userService.updateById(user);
        response.sendRedirect("/list");
    }
}
