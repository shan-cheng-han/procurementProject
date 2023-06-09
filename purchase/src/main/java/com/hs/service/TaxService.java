package com.hs.service;

import com.hs.common.PageVo;
import com.hs.bean.tax.Tax;

/**
 * @author 韩善成
 * @data 2023/6/5 13:12
 */
public interface TaxService {
    PageVo<Tax> getTaxList(Tax tax);
}
