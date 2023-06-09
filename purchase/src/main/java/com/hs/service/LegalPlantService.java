package com.hs.service;

import com.hs.bean.legalplant.AddLegalPlant;
import com.hs.bean.legalplant.LegalPlant;
import com.hs.bean.legalplant.QueryLegalPlantVo;
import com.hs.common.PageVo;
import com.hs.common.ResultVo;

/**
 * @author 韩善成
 * @data 2023/5/12 6:14
 */
public interface LegalPlantService {
    PageVo<LegalPlant> getLegalPlantList(QueryLegalPlantVo queryLegalPlantVo);

    ResultVo addLegalPlant(AddLegalPlant legalPlant);

    ResultVo updateStatus(LegalPlant queryLegalPlantVo);

    ResultVo modifyLegalPlant(LegalPlant queryLegalPlantVo);
}
