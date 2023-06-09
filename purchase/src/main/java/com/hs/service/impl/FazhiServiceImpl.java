package com.hs.service.impl;

import com.hs.bean.fazhi.*;
import com.hs.bean.subclass.Subclass;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;
import com.hs.common.util.MessageUtil;
import com.hs.common.util.PageUtil;
import com.hs.common.util.StatusToStatusNameUtil;
import com.hs.mapper.FazhiMapper;
import com.hs.service.FazhiService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/9 10:54
 */
@Service
public class FazhiServiceImpl implements FazhiService {

    @Autowired
    private FazhiMapper fazhiMapper;


    @Override
    @Transactional
    public ResultVo addFazhi(AddFazhiVo addFazhiVo) {

        Fazhi fazhi = new Fazhi();
        BeanUtils.copyProperties(addFazhiVo,fazhi);
        Date date = new Date();
        fazhi.setCreateTime(date);
        fazhi.setModifyTime(date);
        fazhi.setCreateMan("小明");
        fazhi.setModifyMan("小明");
        fazhiMapper.addFazhi(fazhi);

        return ResultVo.success();
    }

    @Override
    public ResultVo query(QueryFazhiVo queryFazhiVo) {

        Integer count = fazhiMapper.getCount(queryFazhiVo);
        Integer pageIndex = queryFazhiVo.getPageIndex();
        if (pageIndex == null){
            pageIndex = 1;
        }
        Integer pageSize =  queryFazhiVo.getPageSize();

        //分页第一条参数
        queryFazhiVo.setOffSize((pageIndex-1)*queryFazhiVo.getPageSize());

        List<QueryFazhiRe> fazhiList = fazhiMapper.getFazhiList(queryFazhiVo);

        //将Integer类型转为String类型供前端展示
        for (QueryFazhiRe sc: fazhiList) {
            sc.setStatusName(StatusToStatusNameUtil.statusToStatusNameUtil(sc.getStatus(),sc.getStatusName(), MessageUtil.QIYON,MessageUtil.JINYON)) ;
            sc.setIsBorrowName(StatusToStatusNameUtil.statusToStatusNameUtil(sc.getIsBorrow(),sc.getIsBorrowName(),MessageUtil.KEJIEYON,MessageUtil.BUKEJIEYO));
            sc.setIsSellName(StatusToStatusNameUtil.statusToStatusNameUtil(sc.getIsSell(),sc.getIsSellName(),MessageUtil.KEXIAOSHOU,MessageUtil.BUKEXIAOSHOU));
        }

        return ResultVo.success(PageUtil.pageUtil(count,pageIndex,pageSize,fazhiList));
    }

    @Override
    public ResultVo update(UpdateFazhiVo updateFazhiVo) {

        Fazhi fazhi = new Fazhi();
        BeanUtils.copyProperties(updateFazhiVo,fazhi);
        Date date = new Date();
        fazhi.setModifyTime(date);
        fazhi.setModifyMan("小明");

        fazhiMapper.updateFazhi(fazhi);

        return ResultVo.success();
    }


}
