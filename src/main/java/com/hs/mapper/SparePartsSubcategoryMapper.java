package com.hs.mapper;

import com.hs.bean.QuerySparePartsSubcategoryVo;
import com.hs.bean.SparePartsSubcategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/4/18 18:10
 */
@Mapper
public interface SparePartsSubcategoryMapper {


    /**
     * 获取备件小类列表
     *
     * @param querySparePartsSubcategoryVo
     * @return
     */
    List<SparePartsSubcategory> getSubcategories(@Param("querySparePartsSubcategoryVo") QuerySparePartsSubcategoryVo querySparePartsSubcategoryVo);

    /**
     * 查询该条件下数据总条数
     *
     * @param querySparePartsSubcategoryVo
     * @return
     */
    Integer getCount(@Param("querySparePartsSubcategoryVo") QuerySparePartsSubcategoryVo querySparePartsSubcategoryVo);


    Integer addSubclass(@Param("sparePartsSubcategory") SparePartsSubcategory sparePartsSubcategory);

    Integer enableSubclass(@Param("sparePartsSubcategory")SparePartsSubcategory sparePartsSubcategory);

    Integer updateSubclass(@Param("sparePartsSubcategory")SparePartsSubcategory sparePartsSubcategory);

    SparePartsSubcategory getSubclass(@Param("id")Integer id);
}
