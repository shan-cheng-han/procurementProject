package com.hs.controller;

import com.hs.bean.PageVo;
import com.hs.bean.QuerySparePartsSubcategoryVo;
import com.hs.bean.ResultVo;
import com.hs.bean.SparePartsSubcategory;
import com.hs.service.SparePartsSubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 韩善成
 * @data 2023/4/18 18:10
 */
@RestController
@RequestMapping("/subclass")
public class SparePartsSubcategoryController {
    @Autowired
    private SparePartsSubcategoryService sparePartsSubcategoryService;

    //分页查询
    @RequestMapping("/query")
    public ResultVo subclassList(@RequestBody @Valid QuerySparePartsSubcategoryVo querySparePartsSubcategoryVo, BindingResult bindingResult){

        PageVo<SparePartsSubcategory> pageVo = sparePartsSubcategoryService.subclassList(querySparePartsSubcategoryVo);
        return ResultVo.query(pageVo);
    }

    //新增
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultVo addSubclass(@RequestBody @Valid SparePartsSubcategory sparePartsSubcategory, BindingResult bindingResult, Model model){

        //表单验证
        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }

        Integer count = sparePartsSubcategoryService.addSubclass(sparePartsSubcategory);
        return ResultVo.add(count);
    }

    //启用与禁用
    @RequestMapping(value = "/enable",method = RequestMethod.GET)
    public String enableSubclass(SparePartsSubcategory sparePartsSubcategory){

        Integer count = sparePartsSubcategoryService.enableSubclass(sparePartsSubcategory);

        return "redirect:query";
    }

    //修改
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateSubclass(SparePartsSubcategory sparePartsSubcategory){

        Integer count = sparePartsSubcategoryService.updateSubclass(sparePartsSubcategory);

        return "redirect:query";
    }
    //修改之回显
    @RequestMapping(value = "/echo",method = RequestMethod.GET)
    public String echoSubclass(Integer id,Model model){

        //获取用户对象
        SparePartsSubcategory sparePartsSubcategory = sparePartsSubcategoryService.getSparePartsSubcategory(id);

        model.addAttribute("subclassEncoding",sparePartsSubcategory.getSubclassEncoding());
        model.addAttribute("subclassName",sparePartsSubcategory.getSubclassName());
        model.addAttribute("status",sparePartsSubcategory.getStatus());
        model.addAttribute("description",sparePartsSubcategory.getDescription());

        return null;
    }



}
