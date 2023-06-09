package com.hs.dictionary.service;

import com.hs.common.ResultVo;
import com.hs.dictionary.model.AddZiDianParentVo;
import com.hs.dictionary.model.AddZiDianSonVo;
import com.hs.dictionary.model.UpdateStatusZiDianVo;

/**
 * @author 韩善成
 * @data 2023/6/7 5:20
 */
public interface DictionaryService {
    ResultVo query();

    ResultVo addParent(AddZiDianParentVo addZiDianParentVo);

    ResultVo addSon(AddZiDianSonVo addZiDianSonVo);

    ResultVo enable(UpdateStatusZiDianVo statusZiDianVo);

    ResultVo unEnable(UpdateStatusZiDianVo statusZiDianVo);
}
