package com.sys.controller;

import com.alibaba.fastjson.JSON;
import com.sys.entity.Area;
import com.sys.service.AreaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * @author lrbin
 * @version 1.0.0
 * @company
 * @create 2019/11/28 18:08
 * @Description
 */
@WebServlet("/province")
public class ProvinceServlet extends HttpServlet {
    private AreaService areaService = new AreaService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        List<Area> list = areaService.listAll();
        String listJsonStr = JSON.toJSONString(list);

        PrintWriter out = response.getWriter();
        out.append(listJsonStr);
    }
}
