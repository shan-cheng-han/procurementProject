package com.hs.service;

import com.hs.bean.spare.AddSpareVo;
import com.hs.bean.spare.QuerySpareVo;
import com.hs.bean.spare.Spare;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;

import java.util.List;

/**
 * @author 韩善成
 * @data 2023/5/11 9:50
 */
public interface SpareService {
    PageVo<Spare> getSpareList(QuerySpareVo querySpareVo);

    ResultVo updateStatus(Spare spare);

    ResultVo addSpare(AddSpareVo addSpareVo);

    ResultVo modifySpare(Spare spare);

    ResultVo getSpareCodeAndNameByLegalPersonCode(String legalPersonCode);
}
