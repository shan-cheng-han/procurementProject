package com.hs.service.impl;

import com.hs.bean.legalperson.LegalPerson;
import com.hs.bean.legalperson.QueryLegalPersonVo;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;
import com.hs.mapper.LegalPersonMapper;
import com.hs.service.LegalPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/5/12 4:35
 */
@Service
public class LegalPersonServiceImpl implements LegalPersonService {

    @Autowired
    private LegalPersonMapper legalPersonMapper;

    @Override
    public ResultVo legalPersonList() {
        List<LegalPerson> legalPersonLists = legalPersonMapper.legalPersonList(1);

        return ResultVo.success(legalPersonLists);
    }

    /*分页查询*/
    @Override
    public PageVo<LegalPerson> getLegalPersonList(QueryLegalPersonVo queryLegalPersonVo) {
        //如果前端没有给查询的页数，则设置页数为1
        if (queryLegalPersonVo.getCurrentPage() == null){
            queryLegalPersonVo.setCurrentPage(1);
        }
        //pageSize不用设置，前端已帮助做完
        //计算分页后的第一个 参数
        queryLegalPersonVo.setOffSize((queryLegalPersonVo.getCurrentPage()-1)*queryLegalPersonVo.getPageSize());

        //查询数据
        List<LegalPerson> legalPersonList = legalPersonMapper.getLegalPersonList(queryLegalPersonVo);

        for (LegalPerson sc:legalPersonList
        ) {
            if (sc.getStatus()){
                sc.setStatusName("启用");
            }else {
                sc.setStatusName("禁用");
            }
        }

        //查询总条数
        Integer count = legalPersonMapper.getCount(queryLegalPersonVo);

        //计算总页数
        Integer totalPage = count % queryLegalPersonVo.getPageSize() == 0 ? count / queryLegalPersonVo.getPageSize() : count / queryLegalPersonVo.getPageSize()+1;

        PageVo<LegalPerson> pageVo = new PageVo<>();
        pageVo.setCurrentPage(queryLegalPersonVo.getCurrentPage());
        pageVo.setTotalSize(count);
        pageVo.setTotalPage(totalPage);
        pageVo.setDataList(legalPersonList);

        return pageVo;
    }
}
