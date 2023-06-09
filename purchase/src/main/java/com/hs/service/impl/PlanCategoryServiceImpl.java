package com.hs.service.impl;

import com.hs.bean.planCategory.AddPlanCategoryVo;
import com.hs.bean.planCategory.PlanCategory;
import com.hs.bean.planCategory.QueryPlanCategoryVo;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;
import com.hs.mapper.PlanCategoryMapper;
import com.hs.service.PlanCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

/**
 * @author 韩善成
 * @data 2023/4/24 21:53
 */
@Service
public class PlanCategoryServiceImpl implements PlanCategoryService {
    @Autowired
    private PlanCategoryMapper planCategoryMapper;

    //分页条件查询
    @Override
    public PageVo<PlanCategory> getPlanCategoryList(QueryPlanCategoryVo queryPlanCategoryVo) {
        //如果前端没有给查询的页数，则设置页数为1
        if (queryPlanCategoryVo.getCurrentPage() == null){
            queryPlanCategoryVo.setCurrentPage(1);
        }
        //pageSize不用设置，前端已帮助做完

        //计算分页后的第一个 参数
        queryPlanCategoryVo.setOffSize((queryPlanCategoryVo.getCurrentPage()-1)*queryPlanCategoryVo.getPageSize());

        //查询数据
        List<PlanCategory> planCategoryList = planCategoryMapper.getPlanCategoryList(queryPlanCategoryVo);

        //查询总条数
        Integer count = planCategoryMapper.getCount(queryPlanCategoryVo);

        //计算总页数
        Integer totalPage = count % queryPlanCategoryVo.getPageSize() == 0 ? count / queryPlanCategoryVo.getPageSize() : count / queryPlanCategoryVo.getPageSize()+1;

        PageVo<PlanCategory> pageVo = new PageVo<>();
        pageVo.setCurrentPage(queryPlanCategoryVo.getCurrentPage());
        pageVo.setTotalSize(count);
        pageVo.setTotalPage(totalPage);
        pageVo.setDataList(planCategoryList);

        return pageVo;
    }

    //新增
    @Override
    public ResultVo addSubclass(AddPlanCategoryVo addPlanCategoryVo) {
        Integer countByCode = planCategoryMapper.getCountByCode(addPlanCategoryVo.getCode());
        if (countByCode > 0){
            return ResultVo.error("该备件小类编码重复");
        }
        Integer countByName = planCategoryMapper.getCountByName(addPlanCategoryVo.getName());
        if (countByName>0){
            return ResultVo.error("该备件小类名称重复");
        }

        planCategoryMapper.addPlanCategory(addPlanCategoryVo);
        return ResultVo.success(null);
    }

    //计划大类启用禁用
    @Override
    public ResultVo updateStatus(PlanCategory planCategory) {
        planCategoryMapper.updateStatus(planCategory);
        return ResultVo.success(null);
    }

    //修改
    @Override
    public ResultVo modifyPlanCategory(PlanCategory planCategory) {
        planCategoryMapper.modifyPlanCategory(planCategory);
        return ResultVo.success(null);
    }

    //导出
    @Override
    public ResultVo exportMater(List<PlanCategory> planCategories) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return ResultVo.success(null);
    }


}
