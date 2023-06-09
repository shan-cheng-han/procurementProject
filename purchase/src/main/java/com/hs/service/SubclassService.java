package com.hs.service;

import com.hs.bean.subclass.AddSubclassVo;
import com.hs.bean.subclass.QuerySubclassVo;
import com.hs.bean.subclass.Subclass;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;

/**
 * @author 韩善成
 * @data 2023/4/23 14:45
 */
public interface SubclassService {
    //分页条件查询
    PageVo<Subclass> subclassList(QuerySubclassVo querySubclassVo);

    //新增
    ResultVo addSubclass(AddSubclassVo addSubclassVo);

    //启用禁用
    ResultVo updateStatus(Subclass subclass);

    //修改
    ResultVo modifySubClass(Subclass subclass);


    ResultVo planCategoryAll();

    ResultVo subClassAll();

    ResultVo getSubclassNameBySpareCode(String spareCode);
}
