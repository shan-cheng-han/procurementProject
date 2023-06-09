package com.hs.controller;

import com.hs.bean.sparecostprice.AddSpareCostPriceVo;
import com.hs.common.ResultVo;
import com.hs.bean.sparecostprice.QuerySpareCostPriceVo;
import com.hs.service.SpareCostPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 韩善成
 * @data 2023/6/6 15:43
 */
@RestController
@CrossOrigin
@RequestMapping("materialCostPrice")
public class SpareCostPriceController {
    @Autowired
    private SpareCostPriceService spareCostPriceService;

    /*含税类型下拉列表*/
    @RequestMapping(value = "/queryAllTaxType",method = RequestMethod.GET)
    public ResultVo queryAllTaxType(){

        return spareCostPriceService.queryAllTaxType();
    }

    /*工厂下拉列表*/
    @RequestMapping(value = "/queryPlantListByLegalPersonCode",method = RequestMethod.GET)
    public ResultVo queryPlantListByLegalPersonCode(@RequestParam("legalPersonCode") String legalPersonCode){

        return spareCostPriceService.queryPlantListByLegalPersonCode(legalPersonCode);
    }

    /*分页查询*/
    @RequestMapping(value = "/queryPage",method = RequestMethod.POST)
    public ResultVo queryPage(@RequestBody QuerySpareCostPriceVo querySpareCostPriceVo){

        return spareCostPriceService.queryPage(querySpareCostPriceVo);
    }

    /*新增备件价格*/
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResultVo add(@RequestBody AddSpareCostPriceVo addSpareCostPriceVo){

        return spareCostPriceService.add(addSpareCostPriceVo);
    }
}
