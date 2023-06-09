package com.hs.service;

import com.hs.bean.legalperson.LegalPerson;
import com.hs.bean.legalperson.QueryLegalPersonVo;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;

/**
 * @author 韩善成
 * @data 2023/5/12 4:34
 */
public interface LegalPersonService {
    ResultVo legalPersonList();

    PageVo<LegalPerson> getLegalPersonList(QueryLegalPersonVo queryLegalPersonVo);
}
