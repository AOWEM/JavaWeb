package com.yuanh.service;

import com.yuanh.pojo.Brand;
import com.yuanh.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {

    /**
     * 查询
     * @return
     */
    List<Brand> selectAll();

    /**
     * 新增数据
     * @param brand
     */
    void add(Brand brand);

    /**
     * 修改
     * @param brand
     */
    void updata(Brand brand);


    /**
     * 删除
     * @param id
     */
    void deleteById(int id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     * @param currentPage  当前页码
     * @param pageSize  每页展示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand);
}
