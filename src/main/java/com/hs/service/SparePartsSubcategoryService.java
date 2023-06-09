package com.hs.service;

import com.hs.bean.PageVo;
import com.hs.bean.QuerySparePartsSubcategoryVo;
import com.hs.bean.SparePartsSubcategory;
import org.springframework.stereotype.Service;

/**
 * @author 韩善成
 * @data 2023/4/18 18:10
 */

public interface SparePartsSubcategoryService {
    PageVo<SparePartsSubcategory> subclassList(QuerySparePartsSubcategoryVo querySparePartsSubcategoryVo);


    //新增
    Integer addSubclass(SparePartsSubcategory sparePartsSubcategory);

    //启用禁用
    Integer enableSubclass(SparePartsSubcategory sparePartsSubcategory);

    //修改
    Integer updateSubclass(SparePartsSubcategory sparePartsSubcategory);

    //修改之回显
    SparePartsSubcategory getSparePartsSubcategory(Integer id);
}
