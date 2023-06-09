package com.hs.controller;

import com.hs.bean.legalplant.AddLegalPlant;
import com.hs.bean.legalplant.LegalPlant;
import com.hs.bean.legalplant.QueryLegalPlantVo;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;
import com.hs.service.LegalPlantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 韩善成
 * @data 2023/5/12 6:13
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("legalPlant")
public class LegalPlantController {

    @Autowired
    private LegalPlantService legalPlantService;

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResultVo query(@RequestBody @Valid QueryLegalPlantVo queryLegalPlantVo){

        PageVo<LegalPlant> pageVo = legalPlantService.getLegalPlantList(queryLegalPlantVo);

        return ResultVo.success(pageVo);
    }

    @RequestMapping(value = "/addLegalPlant",method = RequestMethod.POST)
    public ResultVo addLegalPlant(@RequestBody @Valid AddLegalPlant legalPlant, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResultVo.error(bindingResult.getFieldError().getDefaultMessage());
        }

        return legalPlantService.addLegalPlant(legalPlant);
    }

    @RequestMapping(value = "updateStatus",method = RequestMethod.POST)
    public ResultVo updateStatus(@RequestBody LegalPlant queryLegalPlantVo){

        return legalPlantService.updateStatus(queryLegalPlantVo);
    }

    @RequestMapping(value = "modifyLegalPlant",method = RequestMethod.POST)
    public ResultVo modifyLegalPlant(@RequestBody LegalPlant queryLegalPlantVo){

        return legalPlantService.modifyLegalPlant(queryLegalPlantVo);
    }
}
