package com.hs.dictionary.service.impl;

import com.hs.common.ResultVo;
import com.hs.dictionary.common.ErrorMessageUtil;
import com.hs.dictionary.mapper.DictionaryMapper;
import com.hs.dictionary.model.AddZiDianParentVo;
import com.hs.dictionary.model.AddZiDianSonVo;
import com.hs.dictionary.model.UpdateStatusZiDianVo;
import com.hs.dictionary.model.ZiDianVo;
import com.hs.dictionary.service.DictionaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 韩善成
 * @data 2023/6/7 5:21
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public ResultVo query() {

        List<ZiDianVo> dictionaryList  = dictionaryMapper.query();

        //找出父类，放入父类集合
        List<ZiDianVo> parentList = new ArrayList<>();
        for (ZiDianVo ziDianVo: dictionaryList) {
            if (ziDianVo.getIsParent()){
                parentList.add(ziDianVo);
            }
        }

        //从父类集合找出子类
        for (ZiDianVo parent: parentList) {
            List<ZiDianVo> sonList = new ArrayList<>();
            for (ZiDianVo son : dictionaryList) {
                if (parent.getCode().equals(son.getParentCode())){
                    sonList.add(son);
                }
            }
            parent.setSonList(sonList);
        }

        return ResultVo.success(parentList);
    }

    @Override
    public ResultVo addParent(AddZiDianParentVo addZiDianParentVo) {

        //验证编码是否重复
        Integer countCode = dictionaryMapper.getCountByCode(addZiDianParentVo.getCode());
        if (countCode>0){
            return ResultVo.error(ErrorMessageUtil.BIANMACHONGFULE);
        }

        //验证名称是否重复
        Integer countName = dictionaryMapper.getCountByName(addZiDianParentVo.getName());
        if (countName>0){
            return ResultVo.error(ErrorMessageUtil.MINCHENGCHONGFULE);
        }

        ZiDianVo ziDianVo = new ZiDianVo();
        Date nowTime = new Date();
        ziDianVo.setCreateMan("李明");
        ziDianVo.setModifyMan("李明");
        ziDianVo.setCreateTime(nowTime);
        ziDianVo.setModifyTime(nowTime);

        BeanUtils.copyProperties(addZiDianParentVo,ziDianVo);
        dictionaryMapper.addParent(ziDianVo);

        return ResultVo.success(null);
    }

    @Override
    public ResultVo addSon(AddZiDianSonVo addZiDianSonVo) {
        //验证编码是否重复
        Integer countCode = dictionaryMapper.getCountByCode(addZiDianSonVo.getCode());
        if (countCode>0){
            return ResultVo.error(ErrorMessageUtil.BIANMACHONGFULE);
        }

        //验证名称是否重复
        Integer countName = dictionaryMapper.getCountByName(addZiDianSonVo.getName());
        if (countName>0){
            return ResultVo.error(ErrorMessageUtil.MINCHENGCHONGFULE);
        }

        ZiDianVo ziDianVo = new ZiDianVo();
        Date nowTime = new Date();
        ziDianVo.setCreateMan("李明");
        ziDianVo.setModifyMan("李明");
        ziDianVo.setCreateTime(nowTime);
        ziDianVo.setModifyTime(nowTime);
        BeanUtils.copyProperties(addZiDianSonVo,ziDianVo);

        dictionaryMapper.addSon(ziDianVo);

        return ResultVo.success(null);
    }

    @Override
    public ResultVo enable(UpdateStatusZiDianVo statusZiDianVo) {

        dictionaryMapper.enableStatus(statusZiDianVo.getCode());

        return ResultVo.success(null);
    }

    @Override
    public ResultVo unEnable(UpdateStatusZiDianVo statusZiDianVo) {

        dictionaryMapper.unEnableStatus(statusZiDianVo.getCode());

        return ResultVo.success(null);
    }
}
