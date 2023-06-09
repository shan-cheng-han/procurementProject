package com.hs.service.impl;

import com.hs.bean.planCategory.PlanCategory;
import com.hs.bean.subclass.AddSubclassVo;
import com.hs.bean.subclass.QuerySubclassVo;
import com.hs.bean.subclass.Subclass;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;
import com.hs.mapper.SubclassMapper;
import com.hs.service.SubclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/4/23 14:46
 */
@Service
public class SubclassServiceImpl implements SubclassService {
    @Autowired
    private SubclassMapper subclassMapper;
    @Override
    public PageVo<Subclass> subclassList(QuerySubclassVo querySubclassVo) {
        //如果前端没有给查询的页数，则设置页数为1
        if (querySubclassVo.getCurrentPage() == null){
            querySubclassVo.setCurrentPage(1);
        }
        //pageSize不用设置，前端已帮助做完
        //计算分页后的第一个 参数
        querySubclassVo.setOffSize((querySubclassVo.getCurrentPage()-1)*querySubclassVo.getPageSize());

        //查询数据
        List<Subclass> subcategories = subclassMapper.getSubcategories(querySubclassVo);

        for (Subclass sc:subcategories
             ) {
            if (sc.getStatus()){
                sc.setStatusName("启用");
            }else {
                sc.setStatusName("禁用");
            }
        }

        //查询总条数
        Integer count = subclassMapper.getCount(querySubclassVo);

        //计算总页数
        Integer totalPage = count % querySubclassVo.getPageSize() == 0 ? count / querySubclassVo.getPageSize() : count / querySubclassVo.getPageSize()+1;

        PageVo<Subclass> pageVo = new PageVo<>();
        pageVo.setCurrentPage(querySubclassVo.getCurrentPage());
        pageVo.setTotalSize(count);
        pageVo.setTotalPage(totalPage);
        pageVo.setDataList(subcategories);

        return pageVo;
    }

    //新增
    @Override
    public ResultVo addSubclass(AddSubclassVo addSubclassVo) {

        Integer countByCode = subclassMapper.getCountByCode(addSubclassVo.getCode());
        if (countByCode > 0){
            return ResultVo.error("该备件小类编码重复");
        }
        Integer countByName = subclassMapper.getCountByName(addSubclassVo.getName());
        if (countByName>0){
            return ResultVo.error("该备件小类名称重复");
        }

        subclassMapper.addSubclass(addSubclassVo);
        return ResultVo.success(null);
    }

    //启用禁用
    @Override
    public ResultVo updateStatus(Subclass subclass) {
        subclassMapper.updateStatus(subclass);
        return ResultVo.success(null);
    }

    //修改
    @Override
    public ResultVo modifySubClass(Subclass subclass) {

        //判断是否为禁用
        if (subclassMapper.getStatus(subclass.getId()) == 1){
            return ResultVo.error("当前备件小类不是禁用状态");
        }
        //是否有名称重复

        if (subclassMapper.getCountByName(subclass.getName())>0){
            return ResultVo.error("当前备件名称不能重复");
        }
        //都行，则直接修改
        subclassMapper.modifySubClass(subclass);
        return ResultVo.success(null);
    }

    @Override
    public ResultVo planCategoryAll() {
        List<PlanCategory> planList = subclassMapper.planCategoryAll();
        return ResultVo.success(planList);
    }

    @Override
    public ResultVo subClassAll() {
        List<Subclass> subClassList = subclassMapper.subClassAll();
        return ResultVo.success(subClassList);
    }

    @Override
    public ResultVo getSubclassNameBySpareCode(String spareCode) {

        List<Subclass> subclassNameList = subclassMapper.getSubclassNameBySpareCode(spareCode);

        return ResultVo.success(subclassNameList);
    }


}
