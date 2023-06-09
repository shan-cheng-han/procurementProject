package com.hs.controller;

import com.hs.bean.subclass.AddSubclassVo;
import com.hs.bean.subclass.QuerySubclassVo;
import com.hs.bean.subclass.Subclass;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;
import com.hs.service.SubclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 韩善成
 * @data 2023/4/23 14:45
 */
@RestController
@CrossOrigin
@RequestMapping("subClass")
public class SubclassController {

    @Autowired
    private SubclassService subclassService;

    //分页查询
    @RequestMapping(value = "/queryPage" ,method = RequestMethod.POST)
    public ResultVo subclassList(@RequestBody @Valid QuerySubclassVo querySubclassVo){

        PageVo<Subclass> pageVo = subclassService.subclassList(querySubclassVo);
        return ResultVo.success(pageVo);
    }

    //新增
    @RequestMapping(value = "/addSubClass",method = RequestMethod.POST)
    public ResultVo addSubclass(@RequestBody @Valid AddSubclassVo addSubclassVo, BindingResult bindingResult){

        //表单验证
        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return subclassService.addSubclass(addSubclassVo);
    }

    //启用与禁用
    @RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
    public ResultVo updateStatus(@RequestBody  Subclass subclass){

        return subclassService.updateStatus(subclass);
    }

    //修改
    @RequestMapping(value = "/modifySubClass",method = RequestMethod.POST)
    public ResultVo modifySubClass(@RequestBody Subclass subclass,BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }
        return subclassService.modifySubClass(subclass);
    }

    //备件设置中添加功能计划大类下拉列表
    @RequestMapping(value = "/planCategoryAll" ,method = RequestMethod.GET)
    public ResultVo planCategoryAll(){

        return subclassService.planCategoryAll();
    }
    //备件设置中添加功能备件小类下拉列表
    @RequestMapping(value = "/queryAll" ,method = RequestMethod.GET)
    public ResultVo queryAll(){

        return subclassService.subClassAll();
    }

}
