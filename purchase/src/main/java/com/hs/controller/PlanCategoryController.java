package com.hs.controller;

import com.hs.bean.planCategory.AddPlanCategoryVo;
import com.hs.bean.planCategory.PlanCategory;
import com.hs.bean.planCategory.QueryPlanCategoryVo;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;
import com.hs.service.PlanCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 韩善成
 * @data 2023/4/24 11:36
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("planCategory")
public class PlanCategoryController {
    @Autowired
    private PlanCategoryService planCategoryService;

    //分页查询
    @RequestMapping(value = "/queryPage" ,method = RequestMethod.POST)
    public ResultVo subclassList(@RequestBody @Valid QueryPlanCategoryVo queryPlanCategoryVo){

        PageVo<PlanCategory> pageVo = planCategoryService.getPlanCategoryList(queryPlanCategoryVo);

        return ResultVo.success(pageVo);
    }
    //新增
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultVo addPlanCategory(@RequestBody @Valid AddPlanCategoryVo addPlanCategoryVo, BindingResult bindingResult){

        //表单验证
        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return planCategoryService.addSubclass(addPlanCategoryVo);
    }

    //启用与禁用
    @RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
    public ResultVo updateStatus(@RequestBody PlanCategory planCategory){

        return planCategoryService.updateStatus(planCategory);
    }

    //修改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResultVo modifySubClass(@RequestBody PlanCategory planCategory){

        return planCategoryService.modifyPlanCategory(planCategory);
    }



}
