package com.hs.service.impl;

import com.hs.bean.PageVo;
import com.hs.bean.QuerySparePartsSubcategoryVo;
import com.hs.bean.SparePartsSubcategory;
import com.hs.mapper.SparePartsSubcategoryMapper;
import com.hs.service.SparePartsSubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/4/18 18:11
 */
@Service
public class SparePartsSubcategoryServiceImpl implements SparePartsSubcategoryService {
    @Autowired
    private SparePartsSubcategoryMapper sparePartsSubcategoryMapper;

    /**
     * 获取客户信息的方法
     * @param querySparePartsSubcategoryVo 页面上传的数据
     * @return
     */
    @Override
    public PageVo subclassList(QuerySparePartsSubcategoryVo querySparePartsSubcategoryVo) {

        //如果前端没有给查询的页数，则设置页数为1
        if (querySparePartsSubcategoryVo.getCurrentPage() == null){
            querySparePartsSubcategoryVo.setCurrentPage(1);
        }
        //写死，设置每页展示5条数据
        querySparePartsSubcategoryVo.setPageSize(5);

        //计算分页后的第一个 参数
        querySparePartsSubcategoryVo.setOffSize((querySparePartsSubcategoryVo.getCurrentPage()-1)*querySparePartsSubcategoryVo.getPageSize());

        //查询数据
        List<SparePartsSubcategory> subcategories = sparePartsSubcategoryMapper.getSubcategories(querySparePartsSubcategoryVo);

        //查询总条数
        Integer count = sparePartsSubcategoryMapper.getCount(querySparePartsSubcategoryVo);

        //计算总页数
        Integer totalPage = count % querySparePartsSubcategoryVo.getPageSize() == 0 ? count / querySparePartsSubcategoryVo.getPageSize() : count / querySparePartsSubcategoryVo.getPageSize()+1;

        PageVo<SparePartsSubcategory> pageVo = new PageVo<>();
        pageVo.setCurrentPage(querySparePartsSubcategoryVo.getCurrentPage());
        pageVo.setTotalSize(count);
        pageVo.setTotalPage(totalPage);
        pageVo.setList(subcategories);

        return pageVo;
    }



    /**
     * 添加备件小类
     * @param sparePartsSubcategory
     * @return
     */
    @Override
    public Integer addSubclass(SparePartsSubcategory sparePartsSubcategory) {

        return sparePartsSubcategoryMapper.addSubclass(sparePartsSubcategory);
    }

    /**
     * 启用禁用备件小类
     * @param sparePartsSubcategory
     * @return
     */
    @Override
    public Integer enableSubclass(SparePartsSubcategory sparePartsSubcategory) {
        return sparePartsSubcategoryMapper.enableSubclass(sparePartsSubcategory);
    }

    /**
     * 修改备件小类
     * @param sparePartsSubcategory
     * @return
     */
    @Override
    public Integer updateSubclass(SparePartsSubcategory sparePartsSubcategory) {
        return sparePartsSubcategoryMapper.updateSubclass(sparePartsSubcategory);
    }

    /**
     * 修改备件小类之回显
     * @param id
     * @return
     */
    @Override
    public SparePartsSubcategory getSparePartsSubcategory(Integer id) {
        return sparePartsSubcategoryMapper.getSubclass(id);
    }

}
