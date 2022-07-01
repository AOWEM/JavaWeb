package com.yuanh.mapper;

import com.yuanh.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 新增
     * @param brand
     */
    void add(Brand brand);

    void updata(@Param("brand") Brand brand);
    /**
     * 删除
     */
    void deleteById(int id);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     * 查询总记录数
     * @return
     */
    int selectTotalCount();

    /**
     * 分页查询
     * @param begin 第几页
     * @param size  查询几条数据
     * @return
     */
    List<Brand> selectByPage(@Param("begin") int begin ,@Param("size") int size);

    /**
     * 分页条件查询
     * @param begin
     * @param size
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
     * 根据条件查询总记录数
     * @return
     */
    int selectTotalCountByCondition(Brand brand);
}
