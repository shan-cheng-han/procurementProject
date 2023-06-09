package com.hs.service;

import com.hs.bean.planCategory.AddPlanCategoryVo;
import com.hs.bean.planCategory.PlanCategory;
import com.hs.bean.planCategory.QueryPlanCategoryVo;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/4/24 21:52
 */
public interface PlanCategoryService {
    //分页查询
    PageVo<PlanCategory> getPlanCategoryList(QueryPlanCategoryVo queryPlanCategoryVo);

    //添加
    ResultVo addSubclass(AddPlanCategoryVo addPlanCategoryVo);

    ResultVo updateStatus(PlanCategory planCategory);

    ResultVo modifyPlanCategory(PlanCategory planCategory);

    ResultVo exportMater(List<PlanCategory> planCategories);

}
