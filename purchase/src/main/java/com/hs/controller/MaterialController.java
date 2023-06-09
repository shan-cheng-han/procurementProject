package com.hs.controller;

import com.hs.bean.planCategory.PlanCategory;
import com.hs.common.ResultVo;
import com.hs.service.PlanCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author 韩善成
 * @data 2023/4/30 14:36
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("material")
public class MaterialController {
    @Autowired
    private PlanCategoryService planCategoryService;

    //导出
    @RequestMapping(value = "exportMater" ,method = RequestMethod.POST)
    public ResultVo exportMater(@RequestBody List<PlanCategory> planCategories){

        return planCategoryService.exportMater(planCategories);
    }

    //导入
    @RequestMapping(value = "inputMater" ,method = RequestMethod.GET)
    public ResultVo inputMater(@RequestBody List<PlanCategory> planCategories){



        return planCategoryService.exportMater(planCategories);
    }

}
