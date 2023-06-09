package com.hs.dictionary.controller;

import com.hs.common.ResultVo;
import com.hs.dictionary.model.AddZiDianParentVo;
import com.hs.dictionary.model.AddZiDianSonVo;
import com.hs.dictionary.model.UpdateStatusZiDianVo;
import com.hs.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 韩善成
 * @data 2023/6/7 3:31
 */
@RestController
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    /*
    * 查询
    *
    * 响应[{"name":"状态","code":"001","sonList":[{"name":"启用","code":"1","name":"禁用","code":"0"}]},
    *      {"name":"币别","code":"000","sonList":[{"name":"人民币","code":"3","name":"美元","code":"4","name":"欧元","code":"5"}]}]
    */

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public ResultVo query(){

        return dictionaryService.query();
    }

    //增加同级
    @RequestMapping(value = "/addParent",method = RequestMethod.POST)
    public ResultVo addParent(@RequestBody @Valid AddZiDianParentVo addZiDianParentVo, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return dictionaryService.addParent(addZiDianParentVo);
    }

    //增加下级
    @RequestMapping(value = "/addSon",method = RequestMethod.POST)
    public ResultVo addSon(@RequestBody @Valid AddZiDianSonVo addZiDianSonVo,BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return dictionaryService.addSon(addZiDianSonVo);
    }

    //启用
    @RequestMapping(value = "/enable",method = RequestMethod.POST)
    public ResultVo enable(@RequestBody UpdateStatusZiDianVo statusZiDianVo){

        return dictionaryService.enable(statusZiDianVo);
    }
    //禁用
    @RequestMapping(value = "/unEnable",method = RequestMethod.POST)
    public ResultVo unEnable(@RequestBody UpdateStatusZiDianVo statusZiDianVo){

        return dictionaryService.unEnable(statusZiDianVo);
    }
}
