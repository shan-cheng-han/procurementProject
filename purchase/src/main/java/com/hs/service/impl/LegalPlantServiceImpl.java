package com.hs.service.impl;

import com.hs.bean.legalplant.AddLegalPlant;
import com.hs.bean.legalplant.LegalPlant;
import com.hs.bean.legalplant.QueryLegalPlantVo;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;
import com.hs.mapper.LegalPlantMapper;
import com.hs.service.LegalPlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/5/12 6:15
 */
@Service
public class LegalPlantServiceImpl implements LegalPlantService {
    @Autowired
    private LegalPlantMapper legalPlantMapper;

    /*分页查询*/
    @Override
    public PageVo<LegalPlant> getLegalPlantList(QueryLegalPlantVo queryLegalPlantVo) {
        //如果前端没有给查询的页数，则设置页数为1
        if (queryLegalPlantVo.getCurrentPage() == null){
            queryLegalPlantVo.setCurrentPage(1);
        }
        //pageSize不用自己设置，前端会上传
        //计算分页第一个参数
        queryLegalPlantVo.setOffSize((queryLegalPlantVo.getCurrentPage()-1)*queryLegalPlantVo.getPageSize());

        //查询数据
        List<LegalPlant> list = legalPlantMapper.getLegalPlantList(queryLegalPlantVo);


        //查询总条数
        Integer count = legalPlantMapper.getCount(queryLegalPlantVo);
        //计算总页数
        Integer totalPage = count%queryLegalPlantVo.getPageSize() == 0 ? count/queryLegalPlantVo.getPageSize():count/queryLegalPlantVo.getPageSize()+1;

        PageVo<LegalPlant> pageVo = new PageVo<>();
        pageVo.setCurrentPage(queryLegalPlantVo.getCurrentPage());
        pageVo.setTotalSize(count);
        pageVo.setTotalPage(totalPage);
        pageVo.setDataList(list);

        return pageVo;
    }

    /*新增*/
    @Override
    public ResultVo addLegalPlant(AddLegalPlant legalPlant) {

        //根据前端上传的编码，查询数据库中是否已经存在该编码,如果已存在，则报错
        if (legalPlantMapper.getCountByCode(legalPlant)>0){
            return ResultVo.error("该工厂编码已经存在，请重新添加");
        }

        legalPlant.setCreateMan("韩善成");
        legalPlant.setModifyMan("韩善成");
        legalPlantMapper.addLegalPlant(legalPlant);

        return ResultVo.success(null);
    }

    /*启用禁用*/
    @Override
    public ResultVo updateStatus(LegalPlant legalPlant) {

        if (legalPlant.getEnabled()){
            return ResultVo.error("法人工厂未禁用");
        }
        Integer count = legalPlantMapper.updateEnabled(legalPlant);

        return ResultVo.success(null);
    }

    /*修改法人工厂信息*/
    @Override
    public ResultVo modifyLegalPlant(LegalPlant queryLegalPlantVo) {
        legalPlantMapper.modifyLegalPlant(queryLegalPlantVo);
        return ResultVo.success(null);
    }
}
