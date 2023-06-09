package com.hs.controller;

import com.hs.bean.legalperson.LegalPerson;
import com.hs.bean.legalperson.QueryLegalPersonVo;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;
import com.hs.service.LegalPersonService;
import com.hs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 韩善成
 * @data 2023/5/12 4:29
 */
@RestController
@CrossOrigin
@RequestMapping("legalPerson")
public class LegalPersonController {

    @Autowired
    private LegalPersonService legalPersonService;
    @Autowired
    private UserService userService;

    //法人下拉框
    @RequestMapping(value = "/ofCurrentUser" ,method = RequestMethod.GET)
    public ResultVo ofCurrentUser(){

        return legalPersonService.legalPersonList();
    }

    //用户名称下拉列表
    @RequestMapping(value = "/queryUser" ,method = RequestMethod.GET)
    public ResultVo queryUser(){

        return userService.getUserList();
    }

    //分页查询
    @RequestMapping(value = "/queryPage" ,method = RequestMethod.POST)
    public ResultVo subclassList(@RequestBody @Valid QueryLegalPersonVo queryLegalPersonVo){

        PageVo<LegalPerson> pageVo = legalPersonService.getLegalPersonList(queryLegalPersonVo);
        return ResultVo.success(pageVo);
    }
}
