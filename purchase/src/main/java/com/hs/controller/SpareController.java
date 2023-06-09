package com.hs.controller;

import com.hs.bean.spare.AddSpareVo;
import com.hs.bean.spare.QuerySpareVo;
import com.hs.bean.spare.Spare;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;
import com.hs.service.SpareService;
import com.hs.service.SubclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 韩善成
 * @data 2023/5/10 9:17
 * 备件设置控制层
 */
@RestController
@CrossOrigin
@RequestMapping("spare")
public class SpareController {

    @Autowired
    private SubclassService subclassService;
    @Autowired
    private SpareService spareService;

    //分页查询
    @RequestMapping(value = "/queryPage" ,method = RequestMethod.POST)
    public ResultVo subclassList(@RequestBody @Valid QuerySpareVo querySpareVo){

        PageVo<Spare> pageVo = spareService.getSpareList(querySpareVo);
        return ResultVo.success(pageVo);
    }

    //新增
    @RequestMapping(value = "/addSpare",method = RequestMethod.POST)
    public ResultVo addSubclass(@RequestBody @Valid AddSpareVo addSpareVo, BindingResult bindingResult){

        //表单验证
        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return spareService.addSpare(addSpareVo);
    }

    //启用与禁用
    @RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
    public ResultVo updateStatus(@RequestBody  Spare spare){

        return spareService.updateStatus(spare);
    }

    //修改
    @RequestMapping(value = "/updateSpare",method = RequestMethod.POST)
    public ResultVo modifySpare(@RequestBody Spare spare, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return spareService.modifySpare(spare);
    }
}
