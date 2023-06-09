package com.hs.mapper;

import com.hs.bean.tax.Tax;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/5 13:13
 */
@Mapper
public interface TaxMapper {

    /*分页条件查询获取税码税率列表数量*/
    Integer getCount(@Param("tax") Tax tax);

    /*分页条件查询获取税码税率列表*/
    List<Tax> getTaxList(@Param("tax") Tax tax);

    /*含税类型下拉列表*/
    @Select("select id,tax_dec as taxDec from tax")
    List<Tax> queryAllTaxType();
}
