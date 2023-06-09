package com.hs.mapper;

import com.hs.bean.subclass.AddSubclassVo;
import com.hs.bean.planCategory.PlanCategory;
import com.hs.bean.subclass.QuerySubclassVo;
import com.hs.bean.subclass.Subclass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/4/23 14:45
 */
@Mapper
public interface SubclassMapper {

    void addSubclass(@Param("addSubclassVo") AddSubclassVo addSubclassVo);
    Integer getCountByCode(@Param("code") String code);
    Integer getCountByName(@Param("name")String name);

    List<Subclass> getSubcategories(@Param("querySubclassVo") QuerySubclassVo querySubclassVo);
    Integer getCount(@Param("querySubclassVo")QuerySubclassVo querySubclassVo);

    Integer updateStatus(@Param("subclass")Subclass subclass);

    Integer modifySubClass(@Param("subclass") Subclass subclass);


    Integer getStatus(@Param("id")Integer id);

    List<PlanCategory> planCategoryAll();

    List<Subclass> subClassAll();


    List<Subclass> getSubclassNameBySpareCode(@Param("spareCode") String spareCode);
}
