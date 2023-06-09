package com.hs.service.impl;
import com.hs.bean.spare.AddSpareVo;
import com.hs.bean.spare.QuerySpareVo;
import com.hs.bean.spare.Spare;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;
import com.hs.mapper.LegalPersonMapper;
import com.hs.mapper.PlanCategoryMapper;
import com.hs.mapper.SpareMapper;
import com.hs.mapper.SubclassMapper;
import com.hs.service.SpareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/5/11 9:50
 */
@Service
public class SpareServiceImpl implements SpareService {
    @Autowired
    private SpareMapper spareMapper;
    @Autowired
    private LegalPersonMapper legalPersonMapper;
    @Autowired
    private SubclassMapper subclassMapper;
    @Autowired
    private PlanCategoryMapper planCategoryMapper;

    //备件分页查询
    @Override
    public PageVo<Spare> getSpareList(QuerySpareVo querySpareVo) {
        //如果前端没有给查询的页数，则设置页数为1
        if (querySpareVo.getCurrentPage() == null){
            querySpareVo.setCurrentPage(1);
        }
        //pageSize不用设置，前端已帮助做完
        //计算分页后的第一个 参数
        querySpareVo.setOffSize((querySpareVo.getCurrentPage()-1)*querySpareVo.getPageSize());

        //查询数据
        List<Spare> spareList = spareMapper.getSpareList(querySpareVo);

        for (Spare sp : spareList
              ) {
            if (sp.getStatus()){
                sp.setStatusName("启用");
            }else {
                sp.setStatusName("禁用");
            }
            List<String> legalPersonNameList = legalPersonMapper.getNameList(sp.getCode());
            for (int i = 0; i < legalPersonNameList.size(); i++) {
                legalPersonNameList.set(i,legalPersonNameList.get(i)+" ");
            }
            sp.setLegalPersonNames(legalPersonNameList);
        }



        //查询总条数
        Integer count = spareMapper.getCount(querySpareVo);

        //计算总页数
        Integer totalPage = count % querySpareVo.getPageSize() == 0 ? count / querySpareVo.getPageSize() : count / querySpareVo.getPageSize()+1;

        PageVo<Spare> pageVo = new PageVo<>();
        pageVo.setCurrentPage(querySpareVo.getCurrentPage());
        pageVo.setTotalSize(count);
        pageVo.setTotalPage(totalPage);
        pageVo.setDataList(spareList);

        return pageVo;
    }

    //启用禁用
    @Override
    public ResultVo updateStatus(Spare spare) {
        Integer count = spareMapper.updateStatus(spare);
        return ResultVo.success(null);
    }


    //新增
   @Override
    public ResultVo addSpare(AddSpareVo addSpareVo) {
        Integer countByCode = spareMapper.getCountByCode(addSpareVo.getCode());
        if (countByCode > 0){
            return ResultVo.error("该备件编码重复");
        }
        Integer countByName = spareMapper.getCountByName(addSpareVo.getName());
        if (countByName>0){
            return ResultVo.error("该备件名称重复");
        }
        //判断备件小类是否存在

       //判断计划大类是否存在

        //添加备件设置
        spareMapper.addSpare(addSpareVo);
        List<Integer> personIdList = addSpareVo.getLegalPersonIds();
        Integer spareId = spareMapper.getIdByName(addSpareVo.getName());
       for (Integer personId: personIdList
            ) {
            spareMapper.addLegalPersonIdAndSpareId(spareId,personId);
       }
        return ResultVo.success(null);
    }


    //修改
    @Override
    public ResultVo modifySpare(Spare spare) {
        //判断是否为禁用
        if (spareMapper.getStatus(spare.getId()) == 1){
            return ResultVo.error("当前备件小类不是禁用状态");
        }
        //是否有名称重复

        if (spareMapper.getCountByName(spare.getName())>1){
            return ResultVo.error("当前备件名称不能重复");
        }
        //都行，则直接修改
        spareMapper.modifySubClass(spare);
        List<Integer> personIdList = spare.getLegalPersonId();
        Integer spareId = spare.getId();
        spareMapper.deleteLegalPersonIdAndSpareId(spareId);
        for (Integer personId: personIdList
        ) {
            spareMapper.addLegalPersonIdAndSpareId(spareId,personId);
        }
        return ResultVo.success(null);
    }

    /*根据法人编码查询备件编码和备件名称*/
    @Override
    public ResultVo getSpareCodeAndNameByLegalPersonCode(String legalPersonCode) {

        List<Spare> list = spareMapper.getSpareCodeAndNameByLegalPersonCode(legalPersonCode);

        return ResultVo.success(list);
    }
}
