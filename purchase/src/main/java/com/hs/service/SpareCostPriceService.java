package com.hs.service;

import com.hs.bean.sparecostprice.AddSpareCostPriceVo;
import com.hs.common.ResultVo;
import com.hs.bean.sparecostprice.QuerySpareCostPriceVo;

/**
 * @author 韩善成
 * @data 2023/6/6 15:45
 */
public interface SpareCostPriceService {
    /*含税类型下拉列表*/
    ResultVo queryAllTaxType();

    /*工厂下拉列表*/
    ResultVo queryPlantListByLegalPersonCode(String legalPersonCode);

    ResultVo queryPage(QuerySpareCostPriceVo querySpareCostPriceVo);

    ResultVo add(AddSpareCostPriceVo addSpareCostPriceVo);
}
