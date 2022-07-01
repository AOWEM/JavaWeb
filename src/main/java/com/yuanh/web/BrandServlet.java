package com.yuanh.web;


import com.alibaba.fastjson.JSON;
import com.yuanh.pojo.Brand;
import com.yuanh.pojo.PageBean;
import com.yuanh.service.BrandService;
import com.yuanh.service.impl.BrandServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private BrandService brandService = new BrandServiceImpl();

    /**
     * 查询所有
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 调用Service查询
        List<Brand> brands = brandService.selectAll();

        //2. 将集合转换为JSON数据   序列化 代替reuqest域
        String jsonString = JSON.toJSONString(brands);

        //3. 响应数据  代替reuqest域
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 新增方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.接收网页上品牌的数据
        BufferedReader br = request.getReader();
        //json字符串
        String params = br.readLine();

        //把获取的json字符串变为java数据
        Brand brand = JSON.parseObject(params, Brand.class);

        //2.调用service添加
        brandService.add(brand);

        //3.响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 修改
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.接收网页数据
        BufferedReader rb = request.getReader();
        //json字符串
        String params = rb.readLine();
        //把获取的json字符串变为java数据
        Brand brand = JSON.parseObject(params, Brand.class);

        //2.调用service添加
        brandService.updata(brand);

        //3.响应成功的标识
        response.getWriter().write("success");


    }


    /**
     * 通过id删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void  deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //接收网页id
        String _id = request.getParameter("id");
        //2.将得到的id从String格式转化为int格式
        int id = Integer.parseInt(_id);

        //2.调用service添加
        brandService.deleteById(id);
        //3.响应成功的标识
        response.getWriter().write("success");

    }

    /**
     * 批量输出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.接收数据[1,2,3]
        BufferedReader br = request.getReader();

        //json字符串
        String params = br.readLine();
        System.out.println("params....." + params);
        //把获取的json字符串变为 int[]数组
        int[] ids = JSON.parseObject(params, int[].class);

        //2.调用service添加
        brandService.deleteByIds(ids);

        //3.响应成功的标识
        response.getWriter().write("success");
    }

    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.接受对应参数 当前页码 和每页展示的条数  url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");


        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        System.out.println("currentPage pageSize....................."+currentPage+pageSize);

        //2.调用service查询分页
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

        //2. 将集合转换为JSON数据   序列化 代替reuqest域
        String jsonString = JSON.toJSONString(pageBean);

        //3. 响应数据  代替reuqest域
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 分页条件查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收 当前页码 和 每页展示条数    url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        // 获取查询条件对象
        BufferedReader br = request.getReader();
        String params = br.readLine();//json字符串

        //转为 Brand
        Brand brand = JSON.parseObject(params, Brand.class);
        //2. 调用service查询
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage,pageSize,brand);

        //2. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        //3. 写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


}
