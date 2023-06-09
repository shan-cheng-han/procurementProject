package com.hs.mapper;

import com.hs.bean.planCategory.AddPlanCategoryVo;
import com.hs.bean.planCategory.PlanCategory;
import com.hs.bean.planCategory.QueryPlanCategoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/4/24 21:53
 */
@Mapper
public interface PlanCategoryMapper {

    List<PlanCategory> getPlanCategoryList(@Param("queryPlanCategoryVo") QueryPlanCategoryVo queryPlanCategoryVo);

    Integer getCount(@Param("queryPlanCategoryVo")QueryPlanCategoryVo queryPlanCategoryVo);

    Integer getCountByCode(@Param("code")String code);

    Integer getCountByName(@Param("name")String name);

    void addPlanCategory(@Param("addPlanCategoryVo")AddPlanCategoryVo addPlanCategoryVo);

    void updateStatus(@Param("planCategory") PlanCategory planCategory);

    void modifyPlanCategory(@Param("planCategory") PlanCategory planCategory);
}
