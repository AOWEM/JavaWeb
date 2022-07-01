package com.yuanh.web.old;

import com.alibaba.fastjson.JSON;
import com.yuanh.pojo.Brand;
import com.yuanh.service.BrandService;
import com.yuanh.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService service = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收网页上品牌的数据
        BufferedReader br = request.getReader();
        //json字符串
        String params = br.readLine();

        //把获取的json字符串变为java数据
        Brand brand = JSON.parseObject(params, Brand.class);

        //2.调用service添加
        service.add(brand);

        //3.响应成功的标识
        response.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
