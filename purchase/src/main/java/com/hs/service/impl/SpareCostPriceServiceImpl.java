package com.hs.service.impl;

import com.hs.bean.legalplant.LegalPlant;
import com.hs.bean.sparecostprice.AddSpareCostPriceVo;
import com.hs.bean.sparecostprice.QuerySpareCostPriceVo;
import com.hs.bean.sparecostprice.SpareCostPrice;
import com.hs.bean.tax.Tax;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;
import com.hs.mapper.LegalPlantMapper;
import com.hs.mapper.SpareCostPriceMapper;
import com.hs.mapper.TaxMapper;
import com.hs.service.SpareCostPriceService;
import com.hs.common.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 韩善成
 * @data 2023/6/6 15:45
 */
@Service
public class SpareCostPriceServiceImpl implements SpareCostPriceService {

    @Autowired
    private SpareCostPriceMapper spareCostPriceMapper;
    @Autowired
    private TaxMapper taxMapper;
    @Autowired
    private LegalPlantMapper legalPlantMapper;

    /*含税类型下拉列表*/
    @Override
    public ResultVo queryAllTaxType() {
        List<Tax> taxTypeLists = taxMapper.queryAllTaxType();
        return ResultVo.success(taxTypeLists);
    }

    /*工厂下拉列表*/
    @Override
    public ResultVo queryPlantListByLegalPersonCode(String legalPersonCode) {

        List<LegalPlant> legalPlants = legalPlantMapper.queryPlantListByLegalPersonCode(legalPersonCode);
        return ResultVo.success(legalPlants);

    }

    @Override
    public ResultVo queryPage(QuerySpareCostPriceVo querySpareCostPriceVo) {

        if (querySpareCostPriceVo.getCurrentPage() == null){
            querySpareCostPriceVo.setCurrentPage(1);
        }
        querySpareCostPriceVo.setOffSize((querySpareCostPriceVo.getCurrentPage()-1)* querySpareCostPriceVo.getPageSize());

        //查询数据
        List<SpareCostPrice> querySpareCostPriceVoList = spareCostPriceMapper.queryPage(querySpareCostPriceVo);

        for (SpareCostPrice sc: querySpareCostPriceVoList
        ) {
            if (sc.getStatus() == 1){
                sc.setStatusName("启用");
            }else {
                sc.setStatusName("禁用");
            }
        }

        //查询总条数
        Integer count = spareCostPriceMapper.getCount(querySpareCostPriceVo);
        //计算总页数
        Integer totalPage = count % querySpareCostPriceVo.getPageSize() == 0 ? count / querySpareCostPriceVo.getPageSize() : count / querySpareCostPriceVo.getPageSize()+1;

        PageVo<SpareCostPrice> pageVo = new PageVo<>();
        pageVo.setCurrentPage(querySpareCostPriceVo.getCurrentPage());
        pageVo.setTotalSize(count);
        pageVo.setTotalPage(totalPage);
        pageVo.setDataList(querySpareCostPriceVoList);

        return ResultVo.success(pageVo);
    }

    @Override
    @Transactional
    public ResultVo add(AddSpareCostPriceVo addSpareCostPriceVo) {

        //查询同法人同工厂下的备件价格记录集合
        List<SpareCostPrice> list = spareCostPriceMapper.getListByMaterialCode(addSpareCostPriceVo.getMaterialCode());
        if (list.isEmpty()){
            spareCostPriceMapper.add(addSpareCostPriceVo);
            return ResultVo.success(null);
        }

        Set<SpareCostPrice> deleteList = new HashSet<>();
        List<SpareCostPrice> addList = new ArrayList<>();
        for (SpareCostPrice spareCostPrice: list) {
            if (TimeUtil.hasOverlap(addSpareCostPriceVo.getStartTime(), addSpareCostPriceVo.getEndTime(), spareCostPrice.getStartTime(), spareCostPrice.getEndTime())) {
               deleteList.add(spareCostPrice);
                //第一类：开始时间相同
                if (addSpareCostPriceVo.getStartTime().equals(spareCostPrice.getStartTime()) || addSpareCostPriceVo.getStartTime().before(spareCostPrice.getStartTime())) {
                    if (addSpareCostPriceVo.getEndTime().before(spareCostPrice.getEndTime())) {
                        spareCostPrice.setStartTime(TimeUtil.plusOrMinDay(addSpareCostPriceVo.getEndTime(),1));
                        addList.add(spareCostPrice);
                    }
                }

                /*//第二类：开始时间在左边  (代码与第一类一样，故而与第一类合并)
                if (addSpareCostPriceVo.getStartTime().before(spareCostPrice.getStartTime())) {
                    if (addSpareCostPriceVo.getEndTime().before(spareCostPrice.getEndTime())) {
                        spareCostPrice.setStartTime(TimeUtil.plusOrMinDay(addSpareCostPriceVo.getEndTime(),1));
                        addList.add(spareCostPrice);
                    }
                }*/

                //第三类：开始时间在右边
                if (addSpareCostPriceVo.getStartTime().before(spareCostPrice.getStartTime())) {
                    if (addSpareCostPriceVo.getEndTime().after(spareCostPrice.getEndTime())) {
                        spareCostPrice.setEndTime(TimeUtil.plusOrMinDay(addSpareCostPriceVo.getEndTime(),-1));
                        addList.add(spareCostPrice);
                    }else {
                        SpareCostPrice spareCostPrice1 = spareCostPrice;
                        spareCostPrice1.setEndTime(TimeUtil.plusOrMinDay(addSpareCostPriceVo.getEndTime(),-1));
                        addList.add(spareCostPrice1);
                        spareCostPrice.setStartTime(TimeUtil.plusOrMinDay(addSpareCostPriceVo.getEndTime(),1));
                        addList.add(spareCostPrice);
                    }
                }

            }
            //根据集合删除与添加数据库，还得单独再次添加新的数据
            if (!deleteList.isEmpty()){
                spareCostPriceMapper.deleteByList(deleteList);
            }
            if (!addList.isEmpty()){
                spareCostPriceMapper.addByList(addList);
            }
            addSpareCostPriceVo.setCreatorName("韩善成");
            spareCostPriceMapper.add(addSpareCostPriceVo);
        }

        return ResultVo.success(null);
    }

    /*新增陈安志版*/
    /*@Override
    @Transactional
    public ResultVo add(AddSpareCostPriceVo addSpareCostPriceVo) {

        //查询同法人同工厂下的备件价格记录集合
        List<SpareCostPrice> list = spareCostPriceMapper.getListByPersonCodeAndPlantCode(addSpareCostPriceVo.getLegalPersonCode(),addSpareCostPriceVo.getLegalPlantCode());
        if (list.isEmpty()){
            spareCostPriceMapper.add(addSpareCostPriceVo);
            return ResultVo.success(null);
        }

        for (SpareCostPrice spareCostPrice: list) {
            if (TimeUtil.hasOverlap(addSpareCostPriceVo.getStartTime(),addSpareCostPriceVo.getEndTime(),spareCostPrice.getStartTime(),spareCostPrice.getEndTime())){
                //第一类：开始时间相同
                if (addSpareCostPriceVo.getStartTime().equals(spareCostPrice.getStartTime())){
                    if (addSpareCostPriceVo.getEndTime().before(spareCostPrice.getEndTime())) {
                        spareCostPriceMapper.add(addSpareCostPriceVo);
                        spareCostPriceMapper.uptadeOldStartTime(TimeUtil.plusOrMinDay(addSpareCostPriceVo.getEndTime(),1),spareCostPrice.getMaterialCode());
                    }else {
                        spareCostPriceMapper.deleteOldSpareCostPrice(addSpareCostPriceVo.getMaterialCode());
                        spareCostPriceMapper.add(addSpareCostPriceVo);
                    }
                }

                //第二类：开始时间在左边

                //第三类：开始时间在右边
            }else {
                spareCostPriceMapper.add(addSpareCostPriceVo);
                return ResultVo.success(null);
            }
        }


        return null;
    }*/


}
