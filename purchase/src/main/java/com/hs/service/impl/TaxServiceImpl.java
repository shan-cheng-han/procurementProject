package com.hs.service.impl;

import com.hs.common.PageVo;
import com.hs.bean.tax.Tax;
import com.hs.mapper.TaxMapper;
import com.hs.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/5 13:12
 */
@Service
public class TaxServiceImpl implements TaxService {
    @Autowired
    private TaxMapper taxMapper;
    @Override
    public PageVo<Tax> getTaxList(Tax tax) {
        //如果前端没有给查询的页数，则设置页数为1
        if (tax.getCurrentPage() == null){
            tax.setCurrentPage(1);
        }
        //pageSize不用设置，前端已帮助做完
        //计算分页后的第一个 参数
        tax.setOffSize((tax.getCurrentPage()-1)*tax.getPageSize());

        //查询数据
        List<Tax> taxList = taxMapper.getTaxList(tax);

        for (Tax sc:taxList
        ) {
            if (sc.getStatus() == 1){
                sc.setStatusName("启用");
            }else {
                sc.setStatusName("禁用");
            }
        }

        //查询总条数
        Integer count = taxMapper.getCount(tax);
        //计算总页数
        Integer totalPage = count % tax.getPageSize() == 0 ? count / tax.getPageSize() : count / tax.getPageSize()+1;

        PageVo<Tax> pageVo = new PageVo<>();
        pageVo.setCurrentPage(tax.getCurrentPage());
        pageVo.setTotalSize(count);
        pageVo.setTotalPage(totalPage);
        pageVo.setDataList(taxList);

        return pageVo;
    }
}
