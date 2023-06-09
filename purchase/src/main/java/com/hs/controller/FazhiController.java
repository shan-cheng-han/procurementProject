package com.hs.controller;

import com.hs.bean.fazhi.AddFazhiVo;
import com.hs.bean.fazhi.QueryFazhiVo;
import com.hs.bean.fazhi.UpdateFazhiVo;
import com.hs.bean.spare.Spare;
import com.hs.common.ResultVo;
import com.hs.service.FazhiService;
import com.hs.service.SpareService;
import com.hs.service.SubclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/9 10:20
 */
@RestController
@CrossOrigin
@RequestMapping( "fazhi")
public class FazhiController {
    @Autowired
    private SpareService spareService;
    @Autowired
    private SubclassService subclassService;
    @Autowired
    private FazhiService fazhiService;


    /*根据法人编码查询备件编码和备件名称*/
    @RequestMapping(value = "/getSpareCodeAndNameByLegalPersonCode",method = RequestMethod.GET)
    public ResultVo getSpareCodeAndNameByLegalPersonCode(@RequestBody String legalPersonCode){

        return  spareService.getSpareCodeAndNameByLegalPersonCode(legalPersonCode);
    }

    /*根据备件编码查询备件小类*/
    @RequestMapping(value = "/getSubclassNameBySpareCode",method = RequestMethod.GET)
    public ResultVo getSubclassNameBySpareCode(@RequestBody String spareCode){

        return  subclassService.getSubclassNameBySpareCode(spareCode);
    }

    /*新增备件数量阈值*/
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultVo addFazhi(@RequestBody @Valid AddFazhiVo addFazhiVo, BindingResult bindingResult){

        //表单验证
        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return  fazhiService.addFazhi(addFazhiVo);
    }

    /*查询备件数量阈值*/
    @RequestMapping(value = "/queryPage",method = RequestMethod.POST)
    public ResultVo queryPage(@RequestBody QueryFazhiVo queryFazhiVo){

        return  fazhiService.query(queryFazhiVo);
    }

    /*修改备件数量阈值*/
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResultVo update(@RequestBody UpdateFazhiVo updateFazhiVo){

        return  fazhiService.update(updateFazhiVo);
    }

}
