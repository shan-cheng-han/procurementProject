package com.hs.controller;

import com.hs.common.PageVo;
import com.hs.common.ResultVo;
import com.hs.bean.tax.Tax;
import com.hs.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 韩善成
 * @data 2023/6/5 13:11
 */
@RestController
@CrossOrigin
@RequestMapping("tax")
public class taxController {
    @Autowired
    private TaxService taxService;

    @RequestMapping(value = "/queryPage",method = RequestMethod.POST)
    public ResultVo queryPage(@RequestBody Tax tax){
        PageVo<Tax> pageVo = taxService.getTaxList(tax);
        return ResultVo.success(pageVo);
    }
}
