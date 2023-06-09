package com.hs.service;

import com.hs.bean.fazhi.AddFazhiVo;
import com.hs.bean.fazhi.QueryFazhiVo;
import com.hs.bean.fazhi.UpdateFazhiVo;
import com.hs.common.ResultVo;

/**
 * @author 韩善成
 * @data 2023/6/9 10:54
 */
public interface FazhiService {
    ResultVo addFazhi(AddFazhiVo addFazhiVo);

    ResultVo query(QueryFazhiVo queryFazhiVo);

    ResultVo update(UpdateFazhiVo updateFazhiVo);
}
